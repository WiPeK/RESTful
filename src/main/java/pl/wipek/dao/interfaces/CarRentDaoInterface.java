package pl.wipek.dao.interfaces;

import pl.wipek.models.CarRent;

import java.util.List;

/**
 * @author Krzysztof Adamczyk on 31.05.2017.
 * Managing CarRent Entity
 */
public interface CarRentDaoInterface {

    /**
     * Getting all cars rents from database
     * @return List of all cars rents
     */
    public List<CarRent> getCarRentList();

    /**
     * Getting car rent entity object from database with id passing by argument
     * @param id car rent id
     * @return CarRent Entity object if exists in database
     */
    public CarRent findCarRentById(int id);
}
