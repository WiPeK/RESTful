package pl.wipek.dao.interfaces;

import pl.wipek.models.Car;

import java.util.List;

/**
 * @author Krzysztof Adamczyk on 31.05.2017.
 * Managing Car Entity
 */
public interface CarDaoInterface {

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
