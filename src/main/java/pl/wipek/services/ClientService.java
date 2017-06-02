package pl.wipek.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.wipek.dao.interfaces.ClientDaoInterface;
import pl.wipek.models.Client;
import pl.wipek.services.interfaces.ClientServiceInterface;

import java.util.List;

/**
 * @author  Krzysztof Adamczyk on 31.05.2017.
 * Service for clients entities
 */
@Service
@Transactional
public class ClientService implements ClientServiceInterface {

    @Autowired
    private ClientDaoInterface clientDao;

    /**
     * Getting all clients from database
     *
     * @return List of all clients
     */
    @Override
    public List<Client> getClientsList() {
        return this.clientDao.getClientsList();
    }

    /**
     * Getting client entity object from database with id passing by argument
     *
     * @param id client id
     * @return Client Entity object if exists in database
     */
    @Override
    public Client findClientById(int id) {
        return this.clientDao.findClientById(id);
    }
}
