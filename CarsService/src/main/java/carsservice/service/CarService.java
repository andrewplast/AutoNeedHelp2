package carsservice.service;

import carsservice.model.Car;

import java.util.Collection;

public interface CarService {

    Car add(Car car) throws Exception;

    Car update(Integer id, Car car) throws Exception;

    void delete(Car car) throws Exception;

    Collection<Car> getAll() throws Exception;

    Car getById(Integer id) throws Exception;
}
