package ordersservice.dao.inmemory;

import ordersservice.dao.CarDriverDAO;
import ordersservice.dao.OrderDAO;
import ordersservice.model.Car;
import ordersservice.model.CarDriver;
import ordersservice.model.Order;

import java.util.Collection;
import java.util.HashSet;

public class InMemoryOrderDAO implements OrderDAO {

    private Collection<Order> orders = new HashSet<>();
    private CarDriverDAO carDriverDAO;

    public InMemoryOrderDAO(CarDriverDAO carDriverDAO) {
        this.carDriverDAO = carDriverDAO;
    }

    public Collection<Order> getAll() {
        return orders;
    }

    public Collection<Order> getCarDriverOrders(CarDriver carDriver) {
        Collection<Order> result = new HashSet<>();
        for (Order order : orders) {
            if (order.getCarDriverNeedHelp().equals(carDriver)) {
                result.add(order);
            }
        }
        return result;
    }

    public Collection<Order> getCarOrders(Car car) {
        Collection<Order> result = new HashSet<>();
        for (Order order : orders) {
            if (order.getCarDriverNeedHelp().getCar().equals(car)) {
                result.add(order);
            }
        }
        return result;
    }

    public Order getById(Integer id) {
        Order result = null;
        for (Order order : orders) {
            if (order.getId() == id)
                result = order;
        }
        return result;
    }

    public void add(Order order) throws Exception {
        orders.add(order);
        carDriverDAO.add(order.getCarDriverNeedHelp());
    }

    public void update(Order order) throws Exception {
        orders.remove(getById(order.getId()));
        orders.add(order);
    }

    public void delete(Order order) throws Exception {
        orders.remove(order);
    }

    public boolean contains(Order order) {
        return orders.contains(order);
    }

    public <T> Collection<Order> getByOneCriteria(String nameField, T field) throws Exception {

        Collection<Order> result = new HashSet<>();
   /*     for (Order order : orders) {
            if (order.getId() == id)
                result = order;
        }*/
        return result;
    }
}
