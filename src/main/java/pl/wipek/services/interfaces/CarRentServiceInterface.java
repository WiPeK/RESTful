package pl.wipek.services.interfaces;

import pl.wipek.models.CarRent;

import java.util.List;

/**
 * @author Krzysztof Adamczyk on 01.06.2017.
 * Service for Car Rent Entity
 */
public interface CarRentServiceInterface {

    /**
     * Getting all cars rents from database
     * @return List of all cars rents
     */
    public List<CarRent> getCarRentsList();

    /**
     * Getting car rent entity object from database with id passing by argument
     * @param id car rent id
     * @return CarRent Entity object if exists in database
     */
    public CarRent findCarRentById(int id);
}
