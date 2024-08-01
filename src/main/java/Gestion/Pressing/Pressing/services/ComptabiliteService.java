package Gestion.Pressing.Pressing.services;

import Gestion.Pressing.Pressing.entities.Comptabilite;

import java.util.List;
import java.util.Optional;

public interface ComptabiliteService {
    // CRUD Methods
    Comptabilite saveComptabilite(Comptabilite comptabilite);
    List<Comptabilite> getAllComptabilites();
    Optional<Comptabilite> getComptabiliteById(Long id);
    void deleteComptabilite(Long id);
    Comptabilite updateComptabilite(Long id, Comptabilite comptabiliteDetails);

    // Custom Methods
    void gererHistoriquePaiement(Long id);
    void gererEtat(Long id);
}
