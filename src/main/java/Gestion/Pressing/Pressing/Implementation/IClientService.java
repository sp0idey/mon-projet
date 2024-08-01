package Gestion.Pressing.Pressing.Implementation;

import Gestion.Pressing.Pressing.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Gestion.Pressing.Pressing.repositories.ClientRepository;
import Gestion.Pressing.Pressing.services.ClientService;

import java.util.List;
import java.util.Optional;

@Service
public class IClientService implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    // CRUD Methods
    @Override
    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public List<Client> getAllClient() {
        return clientRepository.findAll();
    }

    @Override
    public Optional<Client> getClientById(Long id) {
        return clientRepository.findById(id);
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public Client updateClient(Long id, Client clientDetails) {
        Optional<Client> optionalClient = clientRepository.findById(id);
        if (optionalClient.isPresent()) {
            Client client = optionalClient.get();
            client.setNom(clientDetails.getNom());
            client.setPrenom(clientDetails.getPrenom());
            client.setContact(clientDetails.getContact());
            client.setDate_debut(clientDetails.getDate_debut());
            return clientRepository.save(client);
        } else {
            throw new RuntimeException("Client not found with id " + id);
        }
    }

    // Custom Methods
    @Override
    public void deposerLinge(Long id) {
        Optional<Client> client = clientRepository.findById(id);
        if (client.isPresent()) {
            Client c = client.get();
            // Implémentez ici la logique pour déposer le linge
            System.out.println("Déposer le linge pour le client avec ID : " + id);
            c.deposerLeLinge(); // Assurez-vous que cette méthode est bien définie dans la classe Client
            clientRepository.save(c);
        } else {
            throw new RuntimeException("Client not found with id " + id);
        }
    }

    @Override
    public void modifierLinge(Long id) {
        Optional<Client> client = clientRepository.findById(id);
        if (client.isPresent()) {
            Client c = client.get();
            // Implémentez ici la logique pour modifier le linge
            System.out.println("Modifier le linge pour le client avec ID : " + id);
            c.modifierLeLinge(); // Assurez-vous que cette méthode est bien définie dans la classe Client
            clientRepository.save(c);
        } else {
            throw new RuntimeException("Client not found with id " + id);
        }
    }

    @Override
    public void payerFacture(Long id) {
        Optional<Client> client = clientRepository.findById(id);
        if (client.isPresent()) {
            Client c = client.get();
            // Implémentez ici la logique pour payer la facture
            System.out.println("Payer la facture pour le client avec ID : " + id);
            c.payerLaFacture(); // Assurez-vous que cette méthode est bien définie dans la classe Client
            clientRepository.save(c);
        } else {
            throw new RuntimeException("Client not found with id " + id);
        }
    }

    @Override
    public List<Client> getAllClients() {
        return List.of();
    }

    @Override
    public void deposerLeLinge(Long id) {

    }

    @Override
    public void modifierLeLinge(Long id) {

    }

    @Override
    public void payerLaFacture(Long id) {

    }
}
