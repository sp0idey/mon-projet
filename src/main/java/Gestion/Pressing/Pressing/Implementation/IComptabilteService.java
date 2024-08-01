package Gestion.Pressing.Pressing.Implementation;



import Gestion.Pressing.Pressing.entities.Comptabilite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Gestion.Pressing.Pressing.repositories.ComptabiliteRepository;
import Gestion.Pressing.Pressing.services.ComptabiliteService;

import java.util.List;
import java.util.Optional;

@Service
public class IComptabilteService implements ComptabiliteService {

    @Autowired
    private ComptabiliteRepository comptabiliteRepository;

    // CRUD Methods
    @Override
    public Comptabilite saveComptabilite(Comptabilite comptabilite) {
        return comptabiliteRepository.save(comptabilite);
    }

    @Override
    public List<Comptabilite> getAllComptabilites() {
        return comptabiliteRepository.findAll();
    }

    @Override
    public Optional<Comptabilite> getComptabiliteById(Long id) {
        return comptabiliteRepository.findById(id);
    }

    @Override
    public void deleteComptabilite(Long id) {
        comptabiliteRepository.deleteById(id);
    }

    @Override
    public Comptabilite updateComptabilite(Long id, Comptabilite comptabiliteDetails) {
        Optional<Comptabilite> optionalComptabilite = comptabiliteRepository.findById(id);
        if (optionalComptabilite.isPresent()) {
            Comptabilite comptabilite = optionalComptabilite.get();
            comptabilite.setDatePaiement(comptabiliteDetails.getDatePaiement());
            comptabilite.setMontantPaye(comptabiliteDetails.getMontantPaye());
            comptabilite.setEtat(comptabiliteDetails.getEtat());
            return comptabiliteRepository.save(comptabilite);
        } else {
            throw new RuntimeException("Comptabilite not found with id " + id);
        }
    }

    // Custom Methods
    @Override
    public void gererHistoriquePaiement(Long id) {
        Optional<Comptabilite> comptabilite = comptabiliteRepository.findById(id);
        if (comptabilite.isPresent()) {
            // Implémentez ici la logique pour gérer l'historique de paiement
            System.out.println("Gérer l'historique de paiement pour la comptabilité avec ID : " + id);
            // Exemple de gestion : enregistrement des paiements effectués, génération de rapports, etc.
        } else {
            throw new RuntimeException("Comptabilite not found with id " + id);
        }
    }

    @Override
    public void gererEtat(Long id) {
        Optional<Comptabilite> comptabilite = comptabiliteRepository.findById(id);
        if (comptabilite.isPresent()) {
            Comptabilite c = comptabilite.get();
            // Implémentez ici la logique pour gérer l'état de la comptabilité
            System.out.println("Gérer l'état pour la comptabilité avec ID : " + id);
            // Exemple de gestion : mise à jour de l'état, notification de changements, etc.
        } else {
            throw new RuntimeException("Comptabilite not found with id " + id);
        }
    }
}
