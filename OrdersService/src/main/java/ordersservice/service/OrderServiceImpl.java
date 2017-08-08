package ordersservice.service;

import cardriversservice.model.CarDriver;
import ordersservice.dao.OrderDAO;
import cardriversservice.model.Manager;
import ordersservice.model.Order;
import net.sf.ehcache.ObjectExistsException;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

public class OrderServiceImpl implements OrderService {

    private OrderDAO orderDAO;

    public OrderServiceImpl(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    public Collection<Order> getAll() throws Exception {
        return orderDAO.getAll();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public Order add(Order order) throws Exception {
        Order o = null;
        try {
            if (!orderDAO.contains(order)) {
                orderDAO.add(order);
                Manager.getManager().notifyAll(order);
                o = order;
            } else {
                throw new ObjectExistsException("Order already exist " + order.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return o;
    }

    public Order getById(Integer id) throws Exception {
        return orderDAO.getById(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public Order update(Integer id, Order order) throws Exception {
        Order o = null;
        try {
            if (order.getId() == id) {
                orderDAO.update(order);
                o = order;
            } else {
                throw new Exception("Order car not correct for object (other ID)");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return o;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(Integer id) throws Exception {
        orderDAO.delete(orderDAO.getById(id));
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void setCarDriverResponse(Integer idOrder, CarDriver carDriver) throws Exception {
        Order order = orderDAO.getById(idOrder);
        order.setCarDriverResponse(carDriver);
        orderDAO.update(order);
    }

    public void setActive(Integer id) throws Exception {
        setFlagActive(id, true);
    }

    public void setInactive(Integer id) throws Exception {
        setFlagActive(id, false);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    private void setFlagActive(Integer idOrder, boolean flag) throws Exception {
        Order order = orderDAO.getById(idOrder);
        order.setIsActive(flag);
        orderDAO.update(order);
    }

    public Collection<Order> getByCarDriverNeedHelp(CarDriver carDriver) throws Exception {
        return orderDAO.getByOneCriteria("carDriverNeedHelp", carDriver);
    }

    public Collection<Order> getByCarDriverResponse(CarDriver carDriver) throws Exception {
        return orderDAO.getByOneCriteria("carDriverResponse", carDriver);
    }
}
