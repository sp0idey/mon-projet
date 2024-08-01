package Gestion.Pressing.Pressing.repositories;


import Gestion.Pressing.Pressing.entities.Comptabilite;
import Gestion.Pressing.Pressing.entities.Linge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LingeRepository extends JpaRepository<Linge, Long> {
    Linge findById(String id);
    @Query("SELECT c FROM Linge c WHERE c.Id = :id")
    Comptabilite findLingeById(@Param("id") String id);
}
