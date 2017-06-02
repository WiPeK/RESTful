package pl.wipek.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import pl.wipek.models.Car;
import pl.wipek.services.CarService;

@Endpoint
public class CarEndpoint {
    private static final String NAMESPACE_URI = "http://localhost:8080/ecars";

    @Autowired
    private CarService carService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "findCarById")
    @ResponsePayload
    public Car findCarById(@RequestPayload int id) {
        return this.carService.findCarById(id);
    }
}
