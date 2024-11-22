package com.quoteExpress.quoteExpress.controler;

import com.quoteExpress.quoteExpress.model.Client;
import com.quoteExpress.quoteExpress.model.Utilisateur;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public interface UtilisateurControler {

    @GetMapping("/utilisateurs")
    ResponseEntity<List<Utilisateur>> getClients() throws Exception;

    @GetMapping("/utilisateur/{email}")
    ResponseEntity<Utilisateur> getUtilisateur(@PathVariable("email") String email) throws Exception;

    @PostMapping("/utilisateur")
    ResponseEntity<String> addUtilisateur(@RequestBody Utilisateur utilisateur) throws Exception;

    @DeleteMapping("/utilisateur/{utilisateurId}")
    ResponseEntity<String> deleteUtilisateur(@PathVariable("utilisateurId") Long utilisateurId) throws Exception;

    @PatchMapping("/utilisateur/{utilisateurId}")
    ResponseEntity<String> updateUtilisateur(@PathVariable("utilisateurId") Long utilisateurId, @RequestBody Utilisateur utilisateur) throws Exception;

    @PatchMapping("/utilisateur/connexion/{utilisateurId}")
    ResponseEntity<String> updateUtilisateurConnexion(@PathVariable("utilisateurId") Long utilisateurId) throws Exception;
}
