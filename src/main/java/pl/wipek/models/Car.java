package pl.wipek.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Krzysztof Adamczyk on 31.05.2017.
 * Entity for cars database table
 */
@Entity
@Table(name = "cars")
public class Car implements Serializable {

    private int idCar;

    private String producer;

    private String model;

    private int mileage;

    private Set<CarRent> carRent = new HashSet<>(0);

    public Car() {
    }

    public Car(int id, String producer, String model, int mileage) {
        this.idCar = id;
        this.producer = producer;
        this.model = model;
        this.mileage = mileage;
    }

    public Car(int id, String producer, String model, int mileage, Set<CarRent> carRent) {
        this.idCar = id;
        this.producer = producer;
        this.model = model;
        this.mileage = mileage;
        this.carRent = carRent;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_car")
    public int getId() {
        return idCar;
    }

    public void setId(int id) {
        this.idCar = id;
    }

    @Column(name = "producer")
    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    @Column(name = "model")
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Column(name = "mileage")
    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "car")
    public Set<CarRent> getCarRent() {
        return carRent;
    }

    public void setCarRent(Set<CarRent> carRent) {
        this.carRent = carRent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;

        Car car = (Car) o;

        if (idCar != car.idCar) return false;
        if (mileage != car.mileage) return false;
        if (producer != null ? !producer.equals(car.producer) : car.producer != null) return false;
        return model != null ? model.equals(car.model) : car.model == null;
    }

    @Override
    public int hashCode() {
        int result = idCar;
        result = 31 * result + (producer != null ? producer.hashCode() : 0);
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + mileage;
        return result;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + idCar +
                ", producer='" + producer + '\'' +
                ", model='" + model + '\'' +
                ", mileage=" + mileage +
                ", carRent=" + carRent +
                '}';
    }
}
