package com.quoteExpress.quoteExpress.service;

import com.quoteExpress.quoteExpress.controler.UtilisateurControler;
import com.quoteExpress.quoteExpress.model.Utilisateur;
import com.quoteExpress.quoteExpress.repository.UtilisateurRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.Date;
import java.util.List;


@Service
public class UtilisateurService implements UtilisateurControler {

    private final UtilisateurRepository utilisateurRepository;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UtilisateurService(UtilisateurRepository utilisateurRepository, PasswordEncoder passwordEncoder) {
        this.utilisateurRepository = utilisateurRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public ResponseEntity<List<Utilisateur>> getAllUtilisateur() throws Exception {
        try {
            List<Utilisateur> utilisateurs = utilisateurRepository.findAll();
            return new ResponseEntity<>(utilisateurs, HttpStatus.OK);
        }catch (Exception e){
            throw new Exception("Aucun utilisateur trouvee");
        }
    }

    @Override
    public ResponseEntity<Utilisateur> getUtilisateur(Long userId) throws Exception {
        try {
            Utilisateur utilisateurs = utilisateurRepository.findUtilisateurById(userId);
            return new ResponseEntity<>(utilisateurs, HttpStatus.OK);
        }catch (Exception e){
            throw new Exception("Aucun utilisateur trouvee");
        }
    }

    @Override
    public ResponseEntity<Boolean> addUtilisateur(Utilisateur utilisateur) throws Exception {
        try {
            if (utilisateurRepository.findByEmail(utilisateur.getEmail()) == null) {
                utilisateur.setMdp(passwordEncoder.encode(utilisateur.getMdp()));
                utilisateurRepository.save(utilisateur);
                return ResponseEntity.ok(true);
            }else {
                return (ResponseEntity<Boolean>) ResponseEntity.badRequest();
            }
        }catch (Exception e){
            throw new Exception("L'utilisateur n'a pas pu etre ajouter ajouter");
        }
    }

    @Override
    public ResponseEntity<Boolean> deleteUtilisateur(Long utilisateurId) throws Exception {
        try {
            utilisateurRepository.deleteById(utilisateurId);
            return ResponseEntity.ok(true);
        }catch (Exception e){
            throw new Exception("L'utilisateur n'a pas pu etre supprimer :" + e);
        }
    }

    @Override
    public ResponseEntity<String> updateUtilisateur(Long utilisateurId, Utilisateur utilisateur) throws Exception {
        try {
            Utilisateur uti = utilisateurRepository.findUtilisateurById(utilisateurId);

            uti.setNom(utilisateur.getNom());
            uti.setPrenom(utilisateur.getNom());
            uti.setMdp(passwordEncoder.encode(utilisateur.getMdp()));
            uti.setEmail(utilisateur.getEmail());

            utilisateurRepository.save(uti);

            return new ResponseEntity<>("L'utilisateur a etait modiifer", HttpStatus.OK);
        }catch (Exception e){
            throw new Exception("L'utilisateur n'a pas pu etre supprimer");
        }
    }

    @Override
    public ResponseEntity<String> updateUtilisateurConnexion(Long utilisateurId) throws Exception {
        try {
            Utilisateur uti = utilisateurRepository.findUtilisateurById(utilisateurId);
            uti.setDateconnexion(new Date());
            utilisateurRepository.save(uti);
            return new ResponseEntity<>("date de connexion modifier", HttpStatus.OK);
        }catch (Exception e){
            throw new Exception("date de connexion n'a pas pu etre modifer");
        }
    }


}
