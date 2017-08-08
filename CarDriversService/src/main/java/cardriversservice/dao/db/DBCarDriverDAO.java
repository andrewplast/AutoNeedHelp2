package cardriversservice.dao.db;

import cardriversservice.dao.CarDriverDAO;
import cardriversservice.model.CarDriver;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

public class DBCarDriverDAO implements CarDriverDAO {

    @Autowired
    private HibernateUtil hibernateUtil;

    public DBCarDriverDAO() {
    }

    public DBCarDriverDAO(HibernateUtil hibernateUtil) {
        this.hibernateUtil = hibernateUtil;
    }

    public void add(CarDriver carDriver) throws Exception {
        hibernateUtil.addObject(carDriver);
    }

    public void update(CarDriver carDriver) throws Exception {
        hibernateUtil.updateObject(carDriver);
    }

    public void delete(CarDriver carDriver) throws Exception {
        hibernateUtil.deleteObject(carDriver);
    }

    public Collection<CarDriver> getAll() {
        return hibernateUtil.getAllObject(CarDriver.class);
    }

    public CarDriver getById(Integer id) throws Exception {
        return hibernateUtil.getById(CarDriver.class, id);
    }

    public CarDriver getByPhone(String phone) throws Exception {
        return hibernateUtil.getByOneCriteria(CarDriver.class, "phone", phone).iterator().next();
    }

    public boolean contains(CarDriver c) throws Exception {
        return (getById(c.getId()) != null);
    }
}
