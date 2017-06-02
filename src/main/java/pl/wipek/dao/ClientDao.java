package pl.wipek.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.wipek.dao.interfaces.ClientDaoInterface;
import pl.wipek.models.Client;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author Krzysztof Adamczyk on 31.05.2017.
 */
@Component
public class ClientDao implements ClientDaoInterface {

    /**
     * @see EntityManager
     */
    @Autowired
    private EntityManager entityManager;

    /**
     * Getting all clients from database
     * @return List of all clients
     */
    @Override
    public List<Client> getClientsList() {
        return entityManager.createQuery("From Client cl", Client.class).getResultList();
    }

    /**
     * Getting client entity object from database with id passing by argument
     *
     * @param id client id
     * @return Client Entity object if exists in database
     */
    @Override
    public Client findClientById(int id) {
        return entityManager.find(Client.class, id);
    }
}
