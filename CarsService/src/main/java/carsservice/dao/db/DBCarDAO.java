package carsservice.dao.db;


import carsservice.dao.CarDAO;
import carsservice.model.Car;

import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.Collection;

public class DBCarDAO implements CarDAO {

    private HibernateUtil hibernateUtil;

    public DBCarDAO(HibernateUtil hibernateUtil) {
        this.hibernateUtil = hibernateUtil;
    }

    public Collection<Car> getAll() throws URISyntaxException, SQLException {

        return hibernateUtil.getAllObject(Car.class);
    }

    public void add(Car car) throws URISyntaxException, SQLException {
        hibernateUtil.addObject(car);
    }

    public void update(Car car) throws URISyntaxException, SQLException {
        hibernateUtil.updateObject(car);
    }

    public void delete(Car car) throws URISyntaxException, SQLException {
        hibernateUtil.deleteObject(car);
    }

    public Car getById(Integer id) throws URISyntaxException, SQLException {
        return hibernateUtil.getById(Car.class, id);
    }

    public boolean contains(Car c) throws URISyntaxException, SQLException {
        return (getById(c.getId()) != null);
    }
}
