package pl.wipek.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.wipek.models.Car;
import pl.wipek.services.CarService;

import java.util.List;

/**
 * @author Krzysztof Adamczyk on 31.05.2017.
 * Managing requests for cars
 */
@RestController
public class CarController {

    /**
     * @see CarService
     * Managing request for Car Entity
     */
    @Autowired
    private CarService carService;

    /**
     * Action for /cars path getting by GET Method
     * @return List of all cars if exists in database
     */
    @RequestMapping(value = "/cars", method = RequestMethod.GET, headers = "Accept=application/json")
    public @ResponseBody
    List<Car> getCarsList() {
        return this.carService.getCarsList();
    }

    /**
     * Action for /car/{id} path getting by GET Method
     * @param id Car id
     * @return Car object which contain Car with id from path, getting from database if exist otherwise null
     */
    @RequestMapping(value = "/car/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public @ResponseBody
    Car findById(@PathVariable("id") int id) {
        return this.carService.findCarById(id);
    }
}
