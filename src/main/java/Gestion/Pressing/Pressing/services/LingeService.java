package Gestion.Pressing.Pressing.services;

import Gestion.Pressing.Pressing.entities.Linge;

import java.util.List;
import java.util.Optional;

public interface LingeService {
    // CRUD Methods
    Linge saveLinge(Linge linge);

    List<Linge> getAllLinges();

    Optional<Linge> getLingeById(Long id);

    void deleteLinge(Long id);

    Linge updateLinge(Long id, Linge lingeDetails);

}
