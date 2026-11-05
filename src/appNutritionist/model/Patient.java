package appNutritionist.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Patients")
public class Patient implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String lastName;
    private double weight;
    private double height;
    private String observations;

    public Patient() {
        //constructor sin argumentos
    }

    public Patient(String name, String lastName, double weight, double height, String observations) {
        this.name = name;
        this.lastName = lastName;
        this.weight = weight;
        this.height = height;
        this.observations = observations;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public double getWeight() { return weight; }
    public void setWeight(double weight) { this.weight = weight; }

    public double getHeight() { return height; }
    public void setHeight(double height) { this.height = height; }

    public String getObservations() { return observations; }
    public void setObservations(String observations) { this.observations = observations; }
}