package pl.wipek.dao.interfaces;

import pl.wipek.models.Client;

import java.util.List;

/**
 * @author Krzysztof Adamczyk on 31.05.2017.
 * Managing Clients Entity
 */
public interface ClientDaoInterface {

    /**
     * Getting all clients from database
     * @return List of all clients
     */
    public List<Client> getClientsList();

    /**
     * Getting client entity object from database with id passing by argument
     * @param id client id
     * @return Client Entity object if exists in database
     */
    public Client findClientById(int id);
}
