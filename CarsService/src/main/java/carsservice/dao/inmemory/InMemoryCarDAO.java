package carsservice.dao.inmemory;

import carsservice.dao.CarDAO;
import carsservice.model.Car;

import java.util.Collection;
import java.util.HashSet;

public class InMemoryCarDAO implements CarDAO {

    private final Collection<Car> cars = new HashSet<>();

    public Collection<Car> getAll() throws Exception {
        return cars;
    }

    public Car getById(Integer id) throws NullPointerException {
        Car result = null;
        for (Car car : cars) {
            if (car.getId() == id)
                result = car;
        }
        if (result != null)
            return result;
        else
            throw null;
    }

    public void add(Car car) throws Exception {
        cars.add(car);
    }

    public void update(Car car) throws Exception {
        cars.remove(getById(car.getId()));
        cars.add(car);
    }

    public void delete(Car car) throws Exception {
        cars.remove(car);
    }

    public boolean contains(Car car) throws Exception {
        return cars.contains(car);
    }
}
