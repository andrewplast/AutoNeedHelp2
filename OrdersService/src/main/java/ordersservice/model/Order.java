package ordersservice.model;

import cardriversservice.model.CarDriver;
import cardriversservice.model.GeoPoint;

import javax.persistence.*;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Calendar;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "orders")
public class Order {
    private int id;
    private Timestamp date;
    private String problem;
    private boolean isActive = true;
    private CarDriver carDriverNeedHelp;
    private CarDriver carDriverResponse;
    private GeoPoint geoPoint;

    public Order() throws ParseException {
        this.date = new Timestamp(Calendar.getInstance().getTimeInMillis());
    }

    public Order(String problem, CarDriver carDriverNeedHelp, GeoPoint geoPoint) throws ParseException {
        this.date = new Timestamp(Calendar.getInstance().getTimeInMillis());
        this.problem = problem;
        this.carDriverNeedHelp = carDriverNeedHelp;
        this.geoPoint = geoPoint;
    }

    public Order(Integer id, Timestamp date, String problem, CarDriver carDriverNeedHelp, GeoPoint geoPoint, boolean isActive) {
        this.id = id;
        this.date = date;
        this.problem = problem;
        this.carDriverNeedHelp = carDriverNeedHelp;
        this.geoPoint = geoPoint;
        this.isActive = isActive;
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
    @Column(name = "date", nullable = false)
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Basic
    @Column(name = "problem", nullable = true, length = 255)
    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    @Basic
    @Column(name = "isActive", nullable = false)
    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "carDriverNeedHelpid", referencedColumnName = "id", nullable = false)
    public CarDriver getCarDriverNeedHelp() {
        return carDriverNeedHelp;
    }

    public void setCarDriverNeedHelp(CarDriver carDriverNeedHelp) {
        this.carDriverNeedHelp = carDriverNeedHelp;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "carDriverResponseid", referencedColumnName = "id")
    public CarDriver getCarDriverResponse() {
        return carDriverResponse;
    }

    public void setCarDriverResponse(CarDriver carDriverResponse) {
        this.carDriverResponse = carDriverResponse;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "geopointid", referencedColumnName = "id")
    public GeoPoint getGeoPoint() {
        return geoPoint;
    }

    public void setGeoPoint(GeoPoint geoPoint) {
        this.geoPoint = geoPoint;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order that = (Order) o;

        if (id != that.id) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (problem != null ? !problem.equals(that.problem) : that.problem != null) return false;
        if (!carDriverNeedHelp.equals(that.carDriverNeedHelp)) return false;
        if (isActive ^ (that.isActive)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (problem != null ? problem.hashCode() : 0);
        result = 31 * result + carDriverNeedHelp.hashCode();
        return result;
    }
}
