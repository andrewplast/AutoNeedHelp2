package carsservice.dao;


import carsservice.model.Car;

import java.util.Collection;


public interface CarDAO {

    Collection<Car> getAll() throws Exception;

    void add(Car car) throws Exception;

    void update(Car car) throws Exception;

    void delete(Car car) throws Exception;

    Car getById(Integer id) throws Exception;

    boolean contains(Car car) throws Exception;

}
