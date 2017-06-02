package pl.wipek.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import pl.wipek.models.Client;
import pl.wipek.services.ClientService;

@Endpoint
public class ClientEndpoint {
    private static final String NAMESPACE_URI = "http://localhost:8080/eclients";

    @Autowired
    private ClientService clientService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "findClientById")
    @ResponsePayload
    public Client findClientById(@RequestPayload int id) {
        return this.clientService.findClientById(id);
    }
}
