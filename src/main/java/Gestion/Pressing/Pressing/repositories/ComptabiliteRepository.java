package Gestion.Pressing.Pressing.repositories;


import Gestion.Pressing.Pressing.entities.Comptabilite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ComptabiliteRepository extends JpaRepository<Comptabilite, Long> {
    Comptabilite findById(String id);
    @Query("SELECT c FROM Comptabilite c WHERE c.Id = :id")
    Comptabilite findComptabiliteById(@Param("id") String id);
}
