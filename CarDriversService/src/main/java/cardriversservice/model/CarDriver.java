package cardriversservice.model;


import carsservice.model.Car;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "cardrivers")
public class CarDriver implements Listener {

    private int id;
    private String name;
    private String phone;
    private Integer notifyRadius;
    private Car car;
    private GeoPoint geoPoint;
    private String password;

    public CarDriver() {

    }

    public CarDriver(String name, String phone, Car car) {
        this.name = name;
        this.phone = phone;
        this.car = car;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 255)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        BCryptPasswordEncoder enc = new BCryptPasswordEncoder();
        this.password = password;
    }

    @Basic
    @Column(name = "phone", nullable = true, length = 50)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "notifyradius", nullable = true)
    public Integer getNotifyradius() {
        return notifyRadius;
    }

    public void setNotifyradius(Integer notifyradius) {
        this.notifyRadius = notifyradius;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "carid", referencedColumnName = "id")
    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "geopointid", referencedColumnName = "id")
    public GeoPoint getGeoPoint() {
        return geoPoint;
    }

    public void setGeoPoint(GeoPoint geopointsByGeopointid) {
        this.geoPoint = geopointsByGeopointid;
    }

    @Override
    public void update(Object o) {
        //пришло сообщение, что в радиусе уведомления появилось событие order
    }

    @Override
    public String toString() {
        return "{{" + car.toString() + "}, \"id\": \"" + id + "\",\"name\":\"" + name + "\",{" + geoPoint.toString() + "}, \"notifyRadius\":\"" + notifyRadius.toString() + "\", \"phone\":\"" + phone + "\"}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CarDriver that = (CarDriver) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (notifyRadius != null ? !notifyRadius.equals(that.notifyRadius) : that.notifyRadius != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (name != null ? name.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (notifyRadius != null ? notifyRadius.hashCode() : 0);
        return result;
    }


}
