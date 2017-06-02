package pl.wipek.services.interfaces;

import pl.wipek.models.Car;

import java.util.List;

/**
 * @author Krzysztof Adamczyk on 01.06.2017.
 * Service for Car Entity
 */
public interface CarServiceInterface {
    /**
     * Getting all cars from database
     * @return List of all cars
     */
    public List<Car> getCarsList();

    /**
     * Getting car entity object from database with id passing by argument
     * @param id car id
     * @return Car Entity object if exists in database
     */
    public Car findCarById(int id);
}
