package pl.wipek.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Krzysztof Adamczyk on 31.05.2017.
 * Entity for car_rent database table
 */
@Entity
@Table(name = "car_rent")
public class CarRent implements Serializable {

    private int id;

    private Client client;

    private Car car;

    private Date rentDate;

    public CarRent() {
    }

    public CarRent(int id, Client client, Car car, Date rentDate) {
        this.id = id;
        this.client = client;
        this.car = car;
        this.rentDate = rentDate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_car_rent")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "id_client")
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_car", nullable = false)
    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    @Column(name = "rent_date", nullable = false)
    public Date getRentDate() {
        return rentDate;
    }

    public void setRentDate(Date rentDate) {
        this.rentDate = rentDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CarRent)) return false;

        CarRent carRent = (CarRent) o;

        if (id != carRent.id) return false;
        if (client != null ? !client.equals(carRent.client) : carRent.client != null) return false;
        if (car != null ? !car.equals(carRent.car) : carRent.car != null) return false;
        return rentDate != null ? rentDate.equals(carRent.rentDate) : carRent.rentDate == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (rentDate != null ? rentDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CarRent{" +
                "id=" + id +
                ", client=" + client +
                ", car=" + car +
                ", rentDate=" + rentDate.toString() +
                '}';
    }
}
