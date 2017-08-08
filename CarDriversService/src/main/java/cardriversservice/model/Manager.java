package cardriversservice.model;

import java.util.Collection;
import java.util.HashSet;

public class Manager {
    private Collection<Listener> listeners = new HashSet<>();

    private static Manager uniqueManager = new Manager();

    private Manager() {

    }

    public static Manager getManager() {
        return uniqueManager;
    }

    public void addListener(Listener listener) {
        listeners.add(listener);
    }

    public void deleteListener(Listener listener) {
        listeners.remove(listener);
    }

    public void notifyAll(Object o) {
        if (listeners.iterator().hasNext()) {
            if ((listeners.iterator().next().getClass().equals(CarDriver.class)) && (o.getClass().equals(Order.class))) {
                for (Listener l : listeners) {
                    CarDriver carDriver = (CarDriver) l;
                    Order order = (Order) o;
                    if (carDriver.getNotifyradius() != null && carDriver.getGeoPoint() != null) {
                        if (order.getGeoPoint().getDistance(carDriver.getGeoPoint()) <= carDriver.getNotifyradius()) {
                            l.update(order);
                        }
                    }
                }
            } else
                for (Listener l : listeners) {
                    l.update(o);
                }
        }
    }
}
