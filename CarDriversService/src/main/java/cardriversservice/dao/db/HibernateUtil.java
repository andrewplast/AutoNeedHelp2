package cardriversservice.dao.db;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.Collection;

public class HibernateUtil extends HibernateDaoSupport {

    public void addObject(Object o) {
        getHibernateTemplate().save(o);
        getHibernateTemplate().flush();
    }

    public void updateObject(Object o) {
        getHibernateTemplate().update(o);
        getHibernateTemplate().flush();
    }

    public void deleteObject(Object o) {
        getHibernateTemplate().delete(o);
        getHibernateTemplate().flush();
    }

    public <T> Collection<T> getAllObject(Class<T> type) {
        return getHibernateTemplate().loadAll(type);
    }

    public <T, O> Collection<T> getByOneCriteria(Class<T> type, String nameField, O valueFiled) {
        DetachedCriteria criteria = DetachedCriteria.forClass(type);
        criteria.add(Property.forName(nameField).eq(valueFiled));
        return (Collection<T>) getHibernateTemplate().findByCriteria(criteria);
    }

    public <T> T getById(Class<T> type, Integer id) {
        return getHibernateTemplate().get(type, id);
    }
}
