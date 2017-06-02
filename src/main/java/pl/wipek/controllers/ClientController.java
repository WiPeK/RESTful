package pl.wipek.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.wipek.models.Client;
import pl.wipek.services.ClientService;

import java.util.List;

/**
 * @author Krzysztof Adamczyk on 31.05.2017.
 * Managing requests for clients
 */
@RestController
public class ClientController {

    /**
     * @see ClientService
     * Managing request for ClientService Entity
     */
    @Autowired
    private ClientService clientService;

    /**
     * Action for /clients path getting by GET Method
     * @return List of all clients if exists in database
     */
    @RequestMapping(value = "/clients", method = RequestMethod.GET, headers = "Accept=application/json")
    public @ResponseBody
    List<Client> getClientList() {
        return this.clientService.getClientsList();
    }

    /**
     * Action for /client/{id} path getting by GET Method
     * @param id Client id
     * @return Client object which contain Client with id from path, getting from database if exist otherwise null
     */
    @RequestMapping(value = "/client/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public @ResponseBody
    Client findById(@PathVariable("id") int id) {
        return clientService.findClientById(id);
    }
}
