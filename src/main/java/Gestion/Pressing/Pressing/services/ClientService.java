package Gestion.Pressing.Pressing.services;

import Gestion.Pressing.Pressing.entities.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {
    // CRUD Methods
    Client saveClient(Client client);
    List<Client> getAllClient();
    Optional<Client> getClientById(Long id);
    void deleteClient(Long id);
    Client updateClient(Long id, Client clientDetails);

    // Custom Methods
    void deposerLinge(Long id);
    void modifierLinge(Long id);
    void payerFacture(Long id);

    List<Client> getAllClients();

    void deposerLeLinge(Long id);

    void modifierLeLinge(Long id);

    void payerLaFacture(Long id);
}
