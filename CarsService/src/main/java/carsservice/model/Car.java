package carsservice.model;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "cars")
public class Car {

    private int id;
    private String brand;
    private String model;
    private String color;
    private String stateNumber;
    public Car() {

    }

    public Car(String brand, String model, String color, String stateNumber) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.stateNumber = stateNumber;
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
    @Column(name = "brand", nullable = false, length = 255)
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Basic
    @Column(name = "model", nullable = false, length = 255)
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Basic
    @Column(name = "color", nullable = false, length = 255)
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Basic
    @Column(name = "statenumber", nullable = false, length = 255)
    public String getStateNumber() {
        return stateNumber;
    }

    public void setStateNumber(String statenumber) {
        this.stateNumber = statenumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car that = (Car) o;

        if (id != that.id) return false;
        if (brand != null ? !brand.equals(that.brand) : that.brand != null) return false;
        if (model != null ? !model.equals(that.model) : that.model != null) return false;
        if (color != null ? !color.equals(that.color) : that.color != null) return false;
        if (stateNumber != null ? !stateNumber.equals(that.stateNumber) : that.stateNumber != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (brand != null ? brand.hashCode() : 0);
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + (stateNumber != null ? stateNumber.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "\"car\"{" +
                "\"brand\":\"" + brand + '\"' +
                ",\"model\":'" + model + '\"' +
                ",\"color\":\"" + color + '\"' +
                ",\"stateNumber\":\"" + stateNumber + '\"' +
                '}';
    }

}
