package pl.wipek.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.wipek.dao.interfaces.CarDaoInterface;
import pl.wipek.models.Car;
import pl.wipek.services.interfaces.CarServiceInterface;

import java.util.List;

/**
 * @author Krzysztof Adamczyk on 01.06.2017.
 * Service for Car entities
 */
@Service
@Transactional
public class CarService implements CarServiceInterface{

    @Autowired
    private CarDaoInterface carDao;

    /**
     * Getting all cars from database
     *
     * @return List of all cars
     */
    @Override
    public List<Car> getCarsList() {
        return this.carDao.getCarsList();
    }

    /**
     * Getting car entity object from database with id passing by argument
     *
     * @param id car id
     * @return Car Entity object if exists in database
     */
    @Override
    public Car findCarById(int id) {
        return this.carDao.findCarById(id);
    }
}
