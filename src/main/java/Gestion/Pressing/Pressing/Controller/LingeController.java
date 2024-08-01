package Gestion.Pressing.Pressing.Controller;

import Gestion.Pressing.Pressing.entities.Linge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import Gestion.Pressing.Pressing.services.LingeService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/linge")
public class LingeController {

    @Autowired
    private LingeService lingeService;

    // Create a new Linge
    @PostMapping("/add")
    public Linge createLinge(@RequestBody Linge linge) {
        return lingeService.saveLinge(linge);
    }

    // Get all Linges
    @GetMapping
    public List<Linge> getAllLinges() {
        return lingeService.getAllLinges();
    }

    // Get a single Linge by ID
    @GetMapping("/{id}")
    public ResponseEntity<Linge> getLingeById(@PathVariable Long id) {
        Optional<Linge> linge = lingeService.getLingeById(id);
        if (linge.isPresent()) {
            return ResponseEntity.ok(linge.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Update a Linge by ID
    @PutMapping("/{id}")
    public ResponseEntity<Linge> updateLinge(@PathVariable Long id, @RequestBody Linge lingeDetails) {
        try {
            Linge updatedLinge = lingeService.updateLinge(id, lingeDetails);
            return ResponseEntity.ok(updatedLinge);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a Linge by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLinge(@PathVariable Long id) {
        try {
            lingeService.deleteLinge(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
