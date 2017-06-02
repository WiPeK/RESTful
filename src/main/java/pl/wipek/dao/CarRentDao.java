package pl.wipek.dao;

import org.springframework.stereotype.Repository;
import pl.wipek.dao.interfaces.CarRentDaoInterface;
import pl.wipek.models.CarRent;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author Krzysztof Adamczyk on 31.05.2017.
 */
@Repository
public class CarRentDao implements CarRentDaoInterface {

    /**
     * @see EntityManager
     */
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Getting all cars rents from database
     * @return List of all cars rents
     */
    @Override
    public List<CarRent> getCarRentList() {
        return this.entityManager.createQuery("From CarRent crr", CarRent.class).getResultList();
    }

    /**
     * Getting car rent entity object from database with id passing by argument
     *
     * @param id car rent id
     * @return CarRent Entity object if exists in database
     */
    @Override
    public CarRent findCarRentById(int id) {
        return this.entityManager.find(CarRent.class, id);
    }
}
