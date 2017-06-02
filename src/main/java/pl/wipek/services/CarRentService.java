package pl.wipek.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.wipek.dao.interfaces.CarRentDaoInterface;
import pl.wipek.models.CarRent;
import pl.wipek.services.interfaces.CarRentServiceInterface;

import java.util.List;

/**
 * @author Krzysztof Adamczyk on 01.06.2017.
 * Service for Car Rents entities
 */
@Service
@Transactional
public class CarRentService implements CarRentServiceInterface {

    @Autowired
    private CarRentDaoInterface carRentDao;

    /**
     * Getting all cars rents from database
     *
     * @return List of all cars rents
     */
    @Override
    public List<CarRent> getCarRentsList() {
        return this.carRentDao.getCarRentList();
    }

    /**
     * Getting car rent entity object from database with id passing by argument
     *
     * @param id car rent id
     * @return CarRent Entity object if exists in database
     */
    @Override
    public CarRent findCarRentById(int id) {
        return this.carRentDao.findCarRentById(id);
    }
}
