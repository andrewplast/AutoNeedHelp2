package cardriversservice.dao;

import cardriversservice.model.CarDriver;

import java.util.Collection;

public interface CarDriverDAO {

    void add(CarDriver carDriver) throws Exception;

    void update(CarDriver carDriver) throws Exception;

    void delete(CarDriver carDriver) throws Exception;

    Collection<CarDriver> getAll();

    CarDriver getById(Integer id) throws Exception;

    CarDriver getByPhone(String phone) throws Exception;

    boolean contains(CarDriver carDriver) throws Exception;


}
