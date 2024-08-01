package Gestion.Pressing.Pressing.Implementation;

import Gestion.Pressing.Pressing.entities.Linge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Gestion.Pressing.Pressing.repositories.LingeRepository;
import Gestion.Pressing.Pressing.services.LingeService;

import java.util.List;
import java.util.Optional;

@Service
public class ILingeService implements LingeService {

    @Autowired
    private LingeRepository lingeRepository;

    // CRUD Methods
    @Override
    public Linge saveLinge(Linge linge) {
        return lingeRepository.save(linge);
    }

    @Override
    public List<Linge> getAllLinges() {
        return lingeRepository.findAll();
    }

    @Override
    public Optional<Linge> getLingeById(Long id) {
        return lingeRepository.findById(id);
    }

    @Override
    public void deleteLinge(Long id) {
        lingeRepository.deleteById(id);
    }

    @Override
    public Linge updateLinge(Long id, Linge lingeDetails) {
        Optional<Linge> optionalLinge = lingeRepository.findById(id);
        if (optionalLinge.isPresent()) {
            Linge linge = optionalLinge.get();
            linge.setPoidsLinge(lingeDetails.getPoidsLinge());
            linge.setLibelle(lingeDetails.getLibelle());
            linge.setPrixUnitaire(lingeDetails.getPrixUnitaire());
            return lingeRepository.save(linge);
        } else {
            throw new RuntimeException("Linge not found with id " + id);
        }
    }
}
