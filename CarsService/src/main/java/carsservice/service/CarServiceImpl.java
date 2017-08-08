package carsservice.service;

import carsservice.dao.CarDAO;
import carsservice.model.Car;
import net.sf.ehcache.ObjectExistsException;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

public class CarServiceImpl implements CarService {

    private CarDAO carDAO;

    public CarServiceImpl(CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public Car add(Car car) throws Exception {
        Car c = null;
        try {
            if (!carDAO.contains(car)) {
                carDAO.add(car);
                c = car;
            } else {
                throw new ObjectExistsException("Car already exist " + car.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return c;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public Car update(Integer id, Car car) throws Exception {
        Car c = null;
        try {
            if (car.getId() == id) {
                carDAO.update(car);
                c = car;
            } else {
                throw new Exception("ID car not correct for object (other ID)");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return c;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(Car car) throws Exception {
        carDAO.delete(car);
    }

    public Collection<Car> getAll() throws Exception {
        return carDAO.getAll();
    }

    public Car getById(Integer id) throws Exception {
        return carDAO.getById(id);
    }
}
