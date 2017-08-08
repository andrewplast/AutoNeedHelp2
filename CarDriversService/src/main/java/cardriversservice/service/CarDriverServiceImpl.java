package cardriversservice.service;

import cardriversservice.dao.CarDriverDAO;
import cardriversservice.model.CarDriver;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

public class CarDriverServiceImpl implements CarDriverService {

    private CarDriverDAO carDriverDAO;

    public CarDriverServiceImpl(CarDriverDAO carDriverDAO) {
        this.carDriverDAO = carDriverDAO;
    }

    public Collection<CarDriver> getAll() throws Exception {
        return carDriverDAO.getAll();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public CarDriver add(CarDriver carDriver) throws Exception {
        CarDriver c = null;
        try {
            if (!carDriverDAO.contains(carDriver)) {
                carDriverDAO.add(carDriver);
                //Manager.getManager().addListener(carDriver);
                c = carDriver;
            } else {
                throw new Exception("CarDriver already exist " + carDriver.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return c;
    }

    public CarDriver getById(Integer id) throws Exception {
        return carDriverDAO.getById(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public CarDriver update(Integer id, CarDriver carDriver) throws Exception {
        CarDriver c = null;
        try {
            if (carDriver.getId() == id) {
                carDriverDAO.update(carDriver);
                c = carDriver;
            } else {
                throw new Exception("ID carDriver not correct for object (other ID)");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return c;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(Integer id) throws Exception {
        CarDriver carDriver = carDriverDAO.getById(id);
        carDriverDAO.delete(carDriver);
       // Manager.getManager().deleteListener(carDriver);
    }

    public CarDriver authCarDriver(String phone) throws Exception {
        CarDriver carDriver = null;
        try {
            carDriver = carDriverDAO.getByPhone(phone);
        } catch (Exception e) {
            throw new UsernameNotFoundException("User by phone not found");
        }
        return carDriver;
    }

}
