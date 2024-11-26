package com.quoteExpress.quoteExpress.controler;

import com.quoteExpress.quoteExpress.model.Devis;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

<<<<<<< HEAD
import java.io.FileNotFoundException;
=======
>>>>>>> a42f7aa1ab5f80a0acf0814146be39b18456ac95
import java.util.List;

@RestController
public interface DevisController {

    @GetMapping("/devis/{utilisateurId}")
    ResponseEntity<List<Devis>> getAllDevis(@PathVariable("utilisateurId") Long utilisateurId);


    @GetMapping("/devis/{utilisateurId}/{devisId}")
<<<<<<< HEAD
    ResponseEntity<String> dowloadDevis(@PathVariable("utilisateurId") Long utilisateurId,
                                   @PathVariable("devisId") Long devisId) throws FileNotFoundException;

    @PostMapping("/devis")
    ResponseEntity<String> addDevis(@RequestBody Devis devis) throws Exception;
=======
    ResponseEntity<Devis> getDevis(@PathVariable("utilisateurId") Long utilisateurId,
                                   @PathVariable("devisId") Long devisId);

    @PostMapping("/Devis")
    ResponseEntity<String> addDevis(@RequestBody Devis devis);
>>>>>>> a42f7aa1ab5f80a0acf0814146be39b18456ac95

    @PutMapping("/Devis/{devisId}")
    ResponseEntity<String> updateDevis(@PathVariable("devisId") Long devisId,
                                       @RequestBody Devis devis);

    @DeleteMapping("/Devis/{devisId}")
<<<<<<< HEAD
    ResponseEntity<String> deleteDevis(@PathVariable("devisId") Long devisId) throws Exception;
=======
    ResponseEntity<String> deleteDevis(@PathVariable("devisId") Long devisId);
>>>>>>> a42f7aa1ab5f80a0acf0814146be39b18456ac95

}
