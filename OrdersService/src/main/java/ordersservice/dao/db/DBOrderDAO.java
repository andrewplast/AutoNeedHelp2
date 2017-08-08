package ordersservice.dao.db;

import ordersservice.dao.OrderDAO;
import ordersservice.model.Order;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

public class DBOrderDAO implements OrderDAO {

    @Autowired
    private HibernateUtil hibernateUtil;

    public DBOrderDAO() {
    }

    public DBOrderDAO(HibernateUtil hibernateUtil) {
        this.hibernateUtil = hibernateUtil;
    }

    public Collection<Order> getAll() throws Exception {
        return hibernateUtil.getAllObject(Order.class);
    }

    public Order getById(Integer id) throws Exception {
        return hibernateUtil.getById(Order.class, id);
    }

    public void add(Order order) throws Exception {
        hibernateUtil.addObject(order);
    }

    public void update(Order order) throws Exception {
        hibernateUtil.addObject(order);
    }

    public void delete(Order order) throws Exception {
        hibernateUtil.deleteObject(order);
    }

    public boolean contains(Order o) throws Exception {
        return (getById(o.getId()) != null);
    }

    public <T> Collection<Order> getByOneCriteria(String nameField, T field) throws Exception {
        return hibernateUtil.getByOneCriteria(Order.class, nameField, field);
    }
}
