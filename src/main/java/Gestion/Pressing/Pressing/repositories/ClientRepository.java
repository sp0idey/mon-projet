package Gestion.Pressing.Pressing.repositories;


import Gestion.Pressing.Pressing.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    Client findById(String id);
    @Query("SELECT c FROM Client c WHERE c.Id = :id")
    Client findClientById(@Param("id") String id);
}
