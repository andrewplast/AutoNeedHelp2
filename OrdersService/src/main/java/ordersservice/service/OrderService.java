package ordersservice.service;

import cardriversservice.model.CarDriver;
import ordersservice.model.Order;

import java.util.Collection;

public interface OrderService {

    Collection<Order> getAll() throws Exception;

    Order add(Order order) throws Exception;

    Order getById(Integer id) throws Exception;

    Order update(Integer id, Order order) throws Exception;

    Collection<Order> getByCarDriverNeedHelp(CarDriver carDriver) throws Exception;

    Collection<Order> getByCarDriverResponse(CarDriver carDriver) throws Exception;

    void delete(Integer id) throws Exception;

    void setCarDriverResponse(Integer idOrder, CarDriver carDriver) throws Exception;

    void setActive(Integer id) throws Exception;

    void setInactive(Integer id) throws Exception;

}
