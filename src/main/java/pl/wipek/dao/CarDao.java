package pl.wipek.dao;

import org.springframework.stereotype.Repository;
import pl.wipek.dao.interfaces.CarDaoInterface;
import pl.wipek.models.Car;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author Krzysztof Adamczyk on 31.05.2017.
 */
@Repository
public class CarDao implements CarDaoInterface {

    /**
     * @see EntityManager
     */
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Getting all cars from database
     * @return List of all cars
     */
    @Override
    public List<Car> getCarsList() {
        return entityManager.createQuery("From Car cr", Car.class).getResultList();
    }

    /**
     * Getting car entity object from database with id passing by argument
     *
     * @param id car id
     * @return Car Entity object if exists in database
     */
    @Override
    public Car findCarById(int id) {
        return entityManager.find(Car.class, id);
    }
}
