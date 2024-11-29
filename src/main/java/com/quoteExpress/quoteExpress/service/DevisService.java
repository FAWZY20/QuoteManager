package com.quoteExpress.quoteExpress.service;

import com.quoteExpress.quoteExpress.controler.DevisController;
import com.quoteExpress.quoteExpress.model.Client;
import com.quoteExpress.quoteExpress.model.DetailsDevis;
import com.quoteExpress.quoteExpress.model.Devis;
import com.quoteExpress.quoteExpress.model.Utilisateur;
import com.quoteExpress.quoteExpress.repository.ClientRepository;
import com.quoteExpress.quoteExpress.repository.DevisRepository;
import com.quoteExpress.quoteExpress.repository.UtilisateurRepository;
import org.apache.poi.xwpf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class DevisService implements DevisController {

    private final UtilisateurRepository utilisateurRepository;
    private final ClientRepository clientRepository;;

    private final DevisRepository devisRepository;
    @Autowired
    public DevisService(UtilisateurRepository utilisateurRepository, ClientRepository clientRepository, DevisRepository devisRepository) {
        this.utilisateurRepository = utilisateurRepository;
        this.clientRepository = clientRepository;
        this.devisRepository = devisRepository;
    }

    @Override
    public ResponseEntity<List<Devis>> getAllDevis(Long utilisateurId) throws Exception {
        try {
            List<Devis> devis = devisRepository.findDevisByUtilisateurid(utilisateurId);
            return new ResponseEntity<>(devis, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception("aucun devis n'a etait trouvee");
        }
    }

    @Override
    public ResponseEntity<Devis> getDevis(Long devisId) throws Exception {
        try{
            Devis devis = devisRepository.findDevisById(devisId);
            return new ResponseEntity<>(devis, HttpStatus.OK);
        }catch (Exception e){
            throw new Exception("aucun devis et trouver");
        }
    }

    @Override
    public ResponseEntity<String> dowloadDevis(Long utilisateurId, Long devisId) throws IOException {

        Devis devis = devisRepository.findDevisById(devisId);
        File outputFile = new File("devisTelecharger.docx");

       try( FileInputStream fis = new FileInputStream(devis.getDevis().getAbsolutePath());
            FileOutputStream fileOut = new FileOutputStream(outputFile);
            XWPFDocument document = new XWPFDocument(fis);) {

            document.write(fileOut);

            return new ResponseEntity<>("votre devis c'est telecharger", HttpStatus.OK);
       }catch (IOException e){
            throw new IOException("le devis ne c'est aps telecharger");
       }
    }

    @Override
    public ResponseEntity<String> addDevis(Devis devis) throws Exception {
        try{
            devis.setNumerodevis(generateNumeroDevis());
            devis.setStatus(Devis.Status.ATTENTE);
            devis.getDetails().forEach( res -> {
                    res.setPrixTotal(res.getPrix() * res.getQuantite());
            });
            devis.setDevis(generateDevis(devis));
            devisRepository.save(devis);
            return new ResponseEntity<>("le devis a bien etait ajouter", HttpStatus.OK);
        }catch (Exception e){
            throw new Exception("le devis n'a pas pu etre ajouter ", e);
        }
    }


    @Override
    public ResponseEntity<String> updateStatutDevis(Long devisId, String statuts) throws Exception {
        try {
            Devis dvs = devisRepository.findDevisById(devisId);
            if (statuts == "ACCEPT"){
                dvs.setStatus(Devis.Status.ACCEPT);
            } else if (statuts == "REFUSE"){
                dvs.setStatus(Devis.Status.REFUSE);
            } else if (statuts == "EXPIRE"){
                dvs.setStatus(Devis.Status.EXPIRE);
            }
            dvs.setDatevalidation(new Date());
            devisRepository.save(dvs);
            return new ResponseEntity<>("le status a etait changer", HttpStatus.OK);
        }catch (Exception e){
            throw new Exception("le statut n'a pas reussi aetre modifier");
        }
    }

    @Override
    public ResponseEntity<String> addDetail(Long devisId, DetailsDevis detailsDevis) throws Exception {
        try {
            Devis devis = devisRepository.findDevisById(devisId);
            devis.getDetails().add(detailsDevis);
            devisRepository.save(devis);
            return new ResponseEntity<>("le detail a bien etait ajouter", HttpStatus.OK);
        }catch (Exception e){
            throw new Exception("le detail n'a pas pu etre ajouter");
        }
    }

    @Override
    public ResponseEntity<String> deleteDetail(Long devisId, int index) throws Exception {
        try {
            Devis devis = devisRepository.findDevisById(devisId);
            devis.getDetails().remove(devis.getDetails().get(index));
            devisRepository.save(devis);
            return new ResponseEntity<>("le detail a bien etait supprimer", HttpStatus.OK);
        }catch (Exception e){
            throw new Exception("le detail n'a pas pu etre supprimer");
        }
    }

    @Override
    public ResponseEntity<String> deleteDevis(Long devisId) throws Exception {
        try {
            devisRepository.deleteById(devisId);
            return new ResponseEntity<>("la suppression à etait reussi", HttpStatus.OK);
        }catch (Exception e){
            throw new Exception("le devis n'a pas pu etre supprimer");
        }
    }

    private int calculeTva(Devis devis) throws Exception {
        try {
            int tva = 0;
            for (var res : devis.getDetails()) {
                tva += res.getPrixTotal();
            }
            int tvaFinale = tva *  devis.getTva() / 100;
            return  tvaFinale;
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception("la tva n'a pas pu etre calculer");
        }
    }

    private int calculeTotalHt(Devis devis) throws Exception {
        try {
            int total = 0;
            for (var res : devis.getDetails()) {
                total += res.getPrixTotal();
            }
            return  total;
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception("le totalHt n'a pas pu etre calculer");
        }
    }

    private String generateNumeroDevis() throws Exception {
        try {
            List<Integer> listNumero = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                listNumero.add(ThreadLocalRandom.current().nextInt(1,9));
            }
            String nDevis = listNumero.stream().map(String::valueOf).collect(Collectors.joining(""));
            return nDevis;
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception("le numero de devis n'a pas pu etre modifier");
        }
    }

    private File generateDevis(Devis devis) throws Exception {
        Utilisateur utilisateur = utilisateurRepository.findUtilisateurById(devis.getUtilisateurid());
        Client client = clientRepository.findClientById(devis.getClientid());
        int tvaSum = calculeTva(devis);
        int totalHt= calculeTotalHt(devis);

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String dateCreation = formatter.format(devis.getDatecreation());

        File file = new File("Devis.docx");

        try(XWPFDocument document = new XWPFDocument(); FileOutputStream fos = new FileOutputStream(file)){

            XWPFParagraph paragraph2 = document.createParagraph();
            XWPFRun run2 = paragraph2.createRun();

            run2.setText(utilisateur.getNom());
            run2.addBreak();

            run2.setText(utilisateur.getNomEntreprise());
            run2.addBreak();

            run2.setText(utilisateur.getAdresse());
            run2.addBreak();

            run2.setText(String.valueOf(utilisateur.getCodepostal()));
            run2.addBreak();

            run2.setText(String.valueOf(utilisateur.getVille()));
            run2.addBreak();

            run2.setText("siret : " + utilisateur.getSiret());
            run2.addBreak();

            run2.setText("Tél : " + utilisateur.getTelephone());

            run2.setFontSize(12);
            run2.setCapitalized(true);

            XWPFParagraph paragraph = document.createParagraph();
            XWPFRun run = paragraph.createRun();

            run.setText(client.getNomContact());
            run.addBreak();

            run.setText(client.getAdresse());
            run.addBreak();

            run.setText(String.valueOf(client.getCode_postal()));
            run.addBreak();

            run.setText(client.getVille()) ;
            run.addBreak();

            run.setText("siret : " + client.getSiret());
            run.addBreak();

            run.setText("Tél : " + client.getTelephone());
            run.addBreak();

            run.setFontSize(12);
            run.setCapitalized(true);
            paragraph.setAlignment(ParagraphAlignment.RIGHT);

            XWPFTable tableDate =  document.createTable();
            XWPFTableRow tableRO = tableDate.getRow(0);
            tableDate.setWidth("30%");

            tableRO.getCell(0).setText("Date");
            tableRO.getCell(0).setColor("E7E6E6");

            tableRO.getCell(0).getParagraphs().get(0).setAlignment(ParagraphAlignment.CENTER);
            tableRO.getCell(0).getParagraphs().get(0).setSpacingBefore(100);
            tableRO.getCell(0).getParagraphs().get(0).setSpacingAfter(100);

            tableRO.addNewTableCell().setText(dateCreation);
            tableRO.getCell(1).getParagraphs().get(0).setAlignment(ParagraphAlignment.CENTER);
            tableRO.getCell(1).getParagraphs().get(0).setSpacingBefore(100);
            tableRO.getCell(1).getParagraphs().get(0).setSpacingAfter(100);

            XWPFParagraph beforeTable = document.createParagraph();
            beforeTable.setSpacingBefore(200);

            XWPFTable table = document.createTable();
            table.setWidth("100%");

            XWPFTableRow tableRowOne = table.getRow(0);

            tableRowOne.getCell(0).setText("Description");
            tableRowOne.getCell(0).setColor("E7E6E6");
            tableRowOne.getCell(0).getParagraphs().get(0).setAlignment(ParagraphAlignment.CENTER);
            tableRowOne.getCell(0).getParagraphs().get(0).setSpacingBefore(200);

            tableRowOne.addNewTableCell().setText("Quantité");
            tableRowOne.getCell(1).setColor("E7E6E6");
            tableRowOne.getCell(1).getParagraphs().get(0).setAlignment(ParagraphAlignment.CENTER);
            tableRowOne.getCell(1).getParagraphs().get(0).setSpacingBefore(200);

            tableRowOne.addNewTableCell().setText("Prix unitaire HT");
            tableRowOne.getCell(2).setColor("E7E6E6");
            tableRowOne.getCell(2).getParagraphs().get(0).setAlignment(ParagraphAlignment.CENTER);
            tableRowOne.getCell(2).getParagraphs().get(0).setSpacingBefore(200);

            tableRowOne.addNewTableCell().setText("Prix total HT");
            tableRowOne.getCell(3).setColor("E7E6E6");
            tableRowOne.getCell(3).getParagraphs().get(0).setAlignment(ParagraphAlignment.CENTER);
            tableRowOne.getCell(3).getParagraphs().get(0).setSpacingBefore(200);

            devis.getDetails().forEach(res -> {
                XWPFTableRow tableRow = table.createRow();
                tableRow.getCell(0).setText(res.getDescription());
                tableRow.getCell(0).getParagraphs().get(0).setAlignment(ParagraphAlignment.CENTER);
                tableRow.getCell(0).getParagraphs().get(0).setSpacingBefore(200);

                tableRow.getCell(1).setText(String.valueOf(res.getQuantite()));
                tableRow.getCell(1).getParagraphs().get(0).setAlignment(ParagraphAlignment.CENTER);
                tableRow.getCell(1).getParagraphs().get(0).setSpacingBefore(200);

                tableRow.getCell(2).setText(String.valueOf(res.getPrix()) + "€");
                tableRow.getCell(2).getParagraphs().get(0).setAlignment(ParagraphAlignment.CENTER);
                tableRow.getCell(2).getParagraphs().get(0).setSpacingBefore(200);

                tableRow.getCell(3).setText(String.valueOf(res.getPrixTotal()) + "€");
                tableRow.getCell(3).getParagraphs().get(0).setAlignment(ParagraphAlignment.CENTER);
                tableRow.getCell(3).getParagraphs().get(0).setSpacingBefore(200);
            });

            XWPFParagraph afterTable = document.createParagraph();
            afterTable.setSpacingBefore(400);

            XWPFTable tableDeux = document.createTable();

            XWPFTableRow tableROne = tableDeux.getRow(0);

            tableROne.getCell(0).setText("Total HT");
            tableROne.getCell(0).getParagraphs().get(0).setAlignment(ParagraphAlignment.CENTER);
            tableROne.getCell(0).getParagraphs().get(0).setSpacingBefore(200);
            tableROne.getCell(0).setColor("E7E6E6");
            tableROne.getCell(0).setWidth("25%");

            tableROne.addNewTableCell().setText(String.valueOf(totalHt)+  "€");
            tableROne.getCell(1).getParagraphs().get(0).setAlignment(ParagraphAlignment.CENTER);
            tableROne.getCell(1).getParagraphs().get(0).setSpacingBefore(200);

            tableROne.getCell(1).setWidth("25%");

            XWPFTableRow tableRTwo = tableDeux.createRow();

            tableRTwo.getCell(0).setText("TVA ("+ String.valueOf(devis.getTva()) +"%)");
            tableRTwo.getCell(0).getParagraphs().get(0).setAlignment(ParagraphAlignment.CENTER);
            tableRTwo.getCell(0).getParagraphs().get(0).setSpacingBefore(200);
            tableRTwo.getCell(0).setColor("E7E6E6");

            tableROne.getCell(0).setWidth("25%");

            tableRTwo.getCell(1).setText(String.valueOf(tvaSum)+  "€");
            tableRTwo.getCell(1).getParagraphs().get(0).setAlignment(ParagraphAlignment.CENTER);
            tableRTwo.getCell(1).getParagraphs().get(0).setSpacingBefore(200);
            tableROne.getCell(1).setWidth("25%");

            XWPFTableRow tableRThree = tableDeux.createRow();

            tableRThree.getCell(0).setText("Total TTC");
            tableRThree.getCell(0).getParagraphs().get(0).setAlignment(ParagraphAlignment.CENTER);
            tableRThree.getCell(0).getParagraphs().get(0).setSpacingBefore(200);
            tableRThree.getCell(0).setWidth("25%");
            tableRThree.getCell(0).setColor("E7E6E6");

            tableRThree.getCell(1).setText(String.valueOf(totalHt + tvaSum +  "€"));
            tableRThree.getCell(1).getParagraphs().get(0).setAlignment(ParagraphAlignment.CENTER);
            tableRThree.getCell(1).getParagraphs().get(0).setSpacingBefore(200);
            tableRThree.getCell(1).setWidth("25%");

            tableDeux.setWidth("50%");
            tableDeux.setTableAlignment(TableRowAlign.RIGHT);

            document.write(fos);

            return file;

        }catch (Exception e){
            throw new RuntimeException("Erreur lors de la génération du devis", e);
        }
    }
}
