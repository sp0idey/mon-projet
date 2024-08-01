package Gestion.Pressing.Pressing.Controller;



import Gestion.Pressing.Pressing.entities.Comptabilite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import Gestion.Pressing.Pressing.services.ComptabiliteService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comptabilites")
public class ComptabiliteController {

    @Autowired
    private ComptabiliteService comptabiliteService;

    // CRUD Methods

    @PostMapping
    public ResponseEntity<Comptabilite> createComptabilite(@RequestBody Comptabilite comptabilite) {
        Comptabilite savedComptabilite = comptabiliteService.saveComptabilite(comptabilite);
        return new ResponseEntity<>(savedComptabilite, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Comptabilite>> getAllComptabilites() {
        List<Comptabilite> comptabilites = comptabiliteService.getAllComptabilites();
        return new ResponseEntity<>(comptabilites, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comptabilite> getComptabiliteById(@PathVariable Long id) {
        Optional<Comptabilite> comptabilite = comptabiliteService.getComptabiliteById(id);
        if (comptabilite.isPresent()) {
            return new ResponseEntity<>(comptabilite.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comptabilite> updateComptabilite(
            @PathVariable Long id, @RequestBody Comptabilite comptabiliteDetails) {
        try {
            Comptabilite updatedComptabilite = comptabiliteService.updateComptabilite(id, comptabiliteDetails);
            return new ResponseEntity<>(updatedComptabilite, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComptabilite(@PathVariable Long id) {
        try {
            comptabiliteService.deleteComptabilite(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Custom Methods

    @PostMapping("/{id}/historique-paiement")
    public ResponseEntity<Void> gererHistoriquePaiement(@PathVariable Long id) {
        try {
            comptabiliteService.gererHistoriquePaiement(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/{id}/etat")
    public ResponseEntity<Void> gererEtat(@PathVariable Long id) {
        try {
            comptabiliteService.gererEtat(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
