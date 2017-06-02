package pl.wipek.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Krzysztof Adamczyk on 31.05.2017.
 * Entity for clients database table
 */
@Entity
@Table(name = "clients")
public class Client implements Serializable {

    private int idClient;

    private String name;

    private String surname;

    private String email;

    private Set<CarRent> carRent = new HashSet<>(0);

    public Client() {
    }

    public Client(int id, String name, String surname, String email) {
        this.idClient = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public Client(int id, String name, String surname, String email, Set<CarRent> carRent) {
        this.idClient = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.carRent = carRent;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_client")
    public int getId() {
        return idClient;
    }

    public void setId(int id) {
        this.idClient = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "surname")
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "client")
    public Set<CarRent> getCarRent() {
        return carRent;
    }

    public void setCarRent(Set<CarRent> carRent) {
        this.carRent = carRent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;

        Client client = (Client) o;

        if (idClient != client.idClient) return false;
        if (name != null ? !name.equals(client.name) : client.name != null) return false;
        if (surname != null ? !surname.equals(client.surname) : client.surname != null) return false;
        return email != null ? email.equals(client.email) : client.email == null;
    }

    @Override
    public int hashCode() {
        int result = idClient;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + idClient +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", carRent=" + carRent +
                '}';
    }
}
