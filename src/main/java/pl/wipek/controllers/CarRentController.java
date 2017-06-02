package pl.wipek.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.wipek.models.CarRent;
import pl.wipek.services.CarRentService;

import java.util.List;

/**
 * @author Krzysztof Adamczyk on 01.06.2017.
 * Managing requests for CarRents
 */
@RestController
public class CarRentController {

    /**
     * @see CarRentService
     * Managing request for CarRent Entity
     */
    @Autowired
    private CarRentService carRentService;

    /**
     * Action for /rents path getting by GET Method
     * @return List of all car rents if exists in database
     */
    @RequestMapping(value = "/rents", method = RequestMethod.GET, headers = "Accept=application/json")
    public @ResponseBody
    List<CarRent> getCarRentList() {
        return this.carRentService.getCarRentsList();
    }

    /**
     * Action for /rent/{id} path getting by GET Method
     * @param id car rent id
     * @return CarRent object which contain CarRent with id from path, getting from database if exist otherwise null
     */
    @RequestMapping(value = "/rent/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public @ResponseBody
    CarRent findById(@PathVariable("id") int id) {
        return this.carRentService.findCarRentById(id);
    }
}
