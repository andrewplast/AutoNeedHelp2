package cardriversservice.service;

import cardriversservice.model.CarDriver;

import java.util.Collection;

public interface CarDriverService {

    Collection<CarDriver> getAll() throws Exception;

    CarDriver add(CarDriver carDriver) throws Exception;

    CarDriver getById(Integer id) throws Exception;

    CarDriver update(Integer id, CarDriver carDriver) throws Exception;

    void delete(Integer id) throws Exception;

    CarDriver authCarDriver(String phone) throws Exception;

}
