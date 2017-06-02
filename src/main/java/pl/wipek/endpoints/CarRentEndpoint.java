package pl.wipek.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import pl.wipek.models.CarRent;
import pl.wipek.services.CarRentService;

@Endpoint
public class CarRentEndpoint {
    private static final String NAMESPACE_URI = "http://localhost:8080/ecr";

    @Autowired
    private CarRentService carRentService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "findCarRentById")
    @ResponsePayload
    public CarRent findCarRentById(@RequestPayload int id) {
        return this.carRentService.findCarRentById(id);
    }
}
