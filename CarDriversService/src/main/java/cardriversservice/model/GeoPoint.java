package cardriversservice.model;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "geopoints")
public class GeoPoint {
    private Double n, e;
    private int id;
    private static final int EARTH_RADIUS = 6371;

    public GeoPoint() {

    }

    public GeoPoint(Double n, Double e) {
        this.n = n;
        this.e = e;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "n", nullable = false, precision = 0)
    public Double getN() {
        return n;
    }

    public void setN(Double n) {
        this.n = n;
    }

    @Basic
    @Column(name = "e", nullable = false, precision = 0)
    public Double getE() {
        return e;
    }

    public void setE(Double e) {
        this.e = e;
    }

    public double getDistance(GeoPoint toGeoPoint) {
        return EARTH_RADIUS * Math.acos(Math.cos(n) * Math.cos(toGeoPoint.getN()) + Math.sin(n) * Math.sin(toGeoPoint.getN()) * Math.cos(e - toGeoPoint.getE()));
    }

    @Override
    public String toString() {
        return "{\"id\": \"" + Integer.toString(id) + "\", \"n\":\"" + Double.toString(n) + "\",\"E\":\"" + Double.toString(e) + "\"}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GeoPoint that = (GeoPoint) o;

        if (id != that.id) return false;
        if (n != null ? !n.equals(that.n) : that.n != null) return false;
        if (e != null ? !e.equals(that.e) : that.e != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (n != null ? n.hashCode() : 0);
        result = 31 * result + (e != null ? e.hashCode() : 0);
        return result;
    }

}
