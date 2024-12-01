package com.quoteExpress.quoteExpress.controler;

import com.quoteExpress.quoteExpress.model.Client;
import com.quoteExpress.quoteExpress.model.Utilisateur;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public interface UtilisateurControler {

    @GetMapping("/utilisateurs")
    ResponseEntity<List<Utilisateur>> getAllUtilisateur() throws Exception;

    @GetMapping("/utilisateur/{utilisateurId}")
    ResponseEntity<Utilisateur> getUtilisateur(@PathVariable("utilisateurId") Long utilisateurId) throws Exception;

    @PostMapping("/utilisateur")
    ResponseEntity<Boolean> addUtilisateur(@RequestBody Utilisateur utilisateur) throws Exception;

    @DeleteMapping("/utilisateur/{utilisateurId}")
    ResponseEntity<Boolean> deleteUtilisateur(@PathVariable("utilisateurId") Long utilisateurId) throws Exception;

    @PatchMapping("/utilisateur/{utilisateurId}")
    ResponseEntity<String> updateUtilisateur(@PathVariable("utilisateurId") Long utilisateurId, @RequestBody Utilisateur utilisateur) throws Exception;

    @PatchMapping("/utilisateur/connexion/{utilisateurId}")
    ResponseEntity<String> updateUtilisateurConnexion(@PathVariable("utilisateurId") Long utilisateurId) throws Exception;
}
