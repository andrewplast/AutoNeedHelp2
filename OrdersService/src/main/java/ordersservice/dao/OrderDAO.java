package ordersservice.dao;

import ordersservice.model.Order;

import java.util.Collection;

public interface OrderDAO {

    Collection<Order> getAll() throws Exception;

    <T> Collection<Order> getByOneCriteria(String nameField, T field) throws Exception;

    Order getById(Integer id) throws Exception;

    void add(Order order) throws Exception;

    void update(Order order) throws Exception;

    void delete(Order order) throws Exception;

    boolean contains(Order order) throws Exception;

}
