package com.quoteExpress.quoteExpress.controler;

import com.quoteExpress.quoteExpress.model.Devis;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public interface DevisController {

    @GetMapping("/devis/{utilisateurId}")
    ResponseEntity<List<Devis>> getAllDevis(@PathVariable("utilisateurId") Long utilisateurId);


    @GetMapping("/devis/{utilisateurId}/{devisId}")
    ResponseEntity<Devis> getDevis(@PathVariable("utilisateurId") Long utilisateurId,
                                   @PathVariable("devisId") Long devisId);

    @PostMapping("/Devis")
    ResponseEntity<String> addDevis(@RequestBody Devis devis);

    @PutMapping("/Devis/{devisId}")
    ResponseEntity<String> updateDevis(@PathVariable("devisId") Long devisId,
                                       @RequestBody Devis devis);

    @DeleteMapping("/Devis/{devisId}")
    ResponseEntity<String> deleteDevis(@PathVariable("devisId") Long devisId);

}
