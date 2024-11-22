package com.quoteExpress.quoteExpress.service;

import com.quoteExpress.quoteExpress.controler.ClientController;
import com.quoteExpress.quoteExpress.model.Client;
import com.quoteExpress.quoteExpress.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService implements ClientController {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }


    @Override
    public ResponseEntity<List<Client>> getClients() throws Exception {
        try{
            List<Client> clients = clientRepository.findAll();
            return new ResponseEntity<>(clients, HttpStatus.OK);
        }catch (Exception e){
            throw new Exception("Aucun utilisateur trouver");
        }
    }

    @Override
    public ResponseEntity<Client> getClient(String clientEmail) {
       try {
           Client client = clientRepository.findByEmail(clientEmail);
           return new ResponseEntity<>(client, HttpStatus.OK);
       }catch (RuntimeException e){
           throw new RuntimeException("aucun client trouvee");
       }
    }

    @Override
    public ResponseEntity<String> addClient(Client client) throws Exception {
        try {
            if (clientRepository.findByEmail(client.getEmail()) == null){
                clientRepository.save(client);
                return new ResponseEntity<>("le client a bien etait ajouter", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("le client existe deja", HttpStatus.OK);
            }
        }catch (Exception e){
            throw new Exception("le client n'a pas pu etre ajouter");
        }
    }

    @Override
    public ResponseEntity<String> deleteClient(Long clientId) throws Exception {
        try {
            clientRepository.deleteById(clientId);
            return new ResponseEntity<>("le client a bien etait supprimer", HttpStatus.OK);
        }catch (Exception e){
            throw new Exception("le client n'a pas pu etre supprimer");
        }
    }

    @Override
    public ResponseEntity<String> updateClient(Long clientId, Client client) throws Exception {
        try {
            Client clt = clientRepository.findClientById(clientId);

            clt.setNomContact(client.getNomContact());
            clt.setNomEntreprise(client.getNomEntreprise());
            clt.setEmail(client.getEmail());
            clt.setTelephone(client.getTelephone());
            clt.setCode_postal(client.getCode_postal());
            clt.setAdresse(client.getAdresse());
            clt.setPays(client.getPays());
            clt.setSiret(client.getSiret());
            clt.setStatut(client.getStatut());
            clt.setNotes(client.getNotes());

            clientRepository.save(clt);

            return new ResponseEntity<>("le client a bien etait modifier", HttpStatus.OK);
        }catch (Exception e){
            throw new Exception("le client n'a pas pu etre modifier");
        }
    }
}
