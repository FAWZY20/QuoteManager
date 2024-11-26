package com.quoteExpress.quoteExpress.controler;

import com.quoteExpress.quoteExpress.model.Devis;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
public interface DevisController {

    @GetMapping("/devis/{utilisateurId}")
    ResponseEntity<List<Devis>> getAllDevis(@PathVariable("utilisateurId") Long utilisateurId);


    @GetMapping("/devis/{utilisateurId}/{devisId}")
    ResponseEntity<String> dowloadDevis(@PathVariable("utilisateurId") Long utilisateurId,
                                   @PathVariable("devisId") Long devisId) throws FileNotFoundException;

    @PostMapping("/devis")
    ResponseEntity<String> addDevis(@RequestBody Devis devis) throws Exception;

    @PutMapping("/Devis/{devisId}")
    ResponseEntity<String> updateDevis(@PathVariable("devisId") Long devisId,
                                       @RequestBody Devis devis);

    @DeleteMapping("/Devis/{devisId}")
    ResponseEntity<String> deleteDevis(@PathVariable("devisId") Long devisId) throws Exception;

}
