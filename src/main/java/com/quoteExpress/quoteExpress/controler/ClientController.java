package com.quoteExpress.quoteExpress.controler;

import com.quoteExpress.quoteExpress.model.Client;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public interface ClientController {

    @GetMapping("/clients")
    ResponseEntity<List<Client>> getClients() throws Exception;

    @GetMapping("/client/{clientEmail}")
    ResponseEntity<Client> getClient(@PathVariable("clientEmail") String clientEmail);

    @PostMapping("/client")
    ResponseEntity<String> addClient(@RequestBody Client client) throws Exception;

    @DeleteMapping("/client/{clientId}")
    ResponseEntity<String> deleteClient(@PathVariable("clientId") Long clientId) throws Exception;

    @PatchMapping("/client/{clientId}")
    ResponseEntity<String> updateClient(@PathVariable("clientId") Long clientId, @RequestBody Client client) throws Exception;

}
