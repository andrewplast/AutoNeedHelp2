package cardriversservice.dao.inmemory;

import cardriversservice.dao.CarDriverDAO;
import cardriversservice.model.CarDriver;
import carsservice.model.Car;

import java.util.Collection;
import java.util.HashSet;
import java.util.Observable;

public class InMemoryCarDriverDAO extends Observable implements CarDriverDAO {

    private final Collection<CarDriver> carDrivers = new HashSet<>();

    public Collection getAll() {
        return carDrivers;
    }

    public void add(CarDriver carDriver) throws Exception {
        carDrivers.add(carDriver);
        //Manager.getManager().addListener(carDriver);
    }

    public void update(CarDriver carDriver) throws Exception {
        carDrivers.remove(getById(carDriver.getId()));
        carDrivers.add(carDriver);
    }

    public void delete(CarDriver carDriver) throws Exception {
        carDrivers.remove(carDriver);
        //Manager.getManager().deleteListener(carDriver);
    }

    public Car getCar(CarDriver carDriver) {
        Car result = null;
        for (CarDriver c : carDrivers) {
            if (carDriver == c)
                result = c.getCar();
        }
        return result;
    }

    public CarDriver getById(Integer id) {
        CarDriver result = null;
        for (CarDriver carDriver : carDrivers) {
            if (carDriver.getId() == id)
                result = carDriver;
        }
        return result;
    }

    public boolean contains(CarDriver carDriver) {
        return carDrivers.contains(carDriver);
    }

    public CarDriver getByPhone(String phone) throws Exception {
        CarDriver result = null;
        for (CarDriver carDriver : carDrivers) {
            if (carDriver.getPhone() == phone)
                result = carDriver;
        }
        return result;
    }
}
