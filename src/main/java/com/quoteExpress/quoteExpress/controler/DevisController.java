package com.quoteExpress.quoteExpress.controler;

import com.quoteExpress.quoteExpress.model.DetailsDevis;
import com.quoteExpress.quoteExpress.model.Devis;
import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@RestController
public interface DevisController {

    @GetMapping("/devis/{utilisateurId}")
    ResponseEntity<List<Devis>> getAllDevis(@PathVariable("utilisateurId") Long utilisateurId);

    @GetMapping("/devis")
    ResponseEntity<Devis> getDevis(@RequestParam Long devisId);

    @GetMapping("/devis/{utilisateurId}/{devisId}")
    ResponseEntity<String> dowloadDevis(@PathVariable("utilisateurId") Long utilisateurId,
                                   @PathVariable("devisId") Long devisId) throws IOException;

    @PostMapping("/devis")
    ResponseEntity<String> addDevis(@RequestBody Devis devis) throws Exception;

    @PatchMapping("/devis/statut/{devisId}")
    ResponseEntity<String> updateStatutDevis(@PathVariable("devisId") Long devisId,@RequestBody String statuts) throws Exception;

    @PatchMapping("/devis/detail/{devisId}")
    ResponseEntity<String> addDetail(@PathVariable("devisId") Long devisId, @RequestBody DetailsDevis detailsDevis);

    @DeleteMapping("/devis/detail/{devisId}/{index}")
    ResponseEntity<String> deleteDetail(@PathVariable("devisId") Long devisId,@PathVariable("index") int index);

    @DeleteMapping("/devis/{devisId}")
    ResponseEntity<String> deleteDevis(@PathVariable("devisId") Long devisId) throws Exception;

}
