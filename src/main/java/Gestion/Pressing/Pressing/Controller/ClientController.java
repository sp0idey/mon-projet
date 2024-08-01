package Gestion.Pressing.Pressing.Controller;


import Gestion.Pressing.Pressing.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import Gestion.Pressing.Pressing.services.ClientService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class ClientController {

    @Autowired
    private ClientService clientService;

    // Creation d'un nouveau client
    @PostMapping ("/add/clients")
    public ResponseEntity<Client> createClient(@RequestBody Client client) {
        Client savedClient = clientService.saveClient(client);
        return ResponseEntity.ok(savedClient);
    }

    // Recuperer tous les clients
    @GetMapping ("/get/client")
    public ResponseEntity<List<Client>> getAllClients() {
        List<Client> clients = clientService.getAllClients();
        return ResponseEntity.ok(clients);
    }



    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable Long id) {
        Optional<Client> client = clientService.getClientById(id);
        return client.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    // Modifier  un  client par id
    @PutMapping("/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable Long id, @RequestBody Client clientDetails) {
        try {
            Client updatedClient = clientService.updateClient(id, clientDetails);
            return ResponseEntity.ok(updatedClient);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }


    // Supprimer un  client par id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        try {
            clientService.deleteClient(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }



    @PostMapping("/{id}/deposer-le-linge")
    public ResponseEntity<Void> deposerLeLinge(@PathVariable Long id) {
        try {
            clientService.deposerLeLinge(id);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{id}/modifier-le-linge")
    public ResponseEntity<Void> modifierLeLinge(@PathVariable Long id) {
        try {
            clientService.modifierLeLinge(id);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{id}/payer-la-facture")
    public ResponseEntity<Void> payerLaFacture(@PathVariable Long id) {
        try {
            clientService.payerLaFacture(id);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
