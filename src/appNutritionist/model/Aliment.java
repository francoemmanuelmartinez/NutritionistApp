package appNutritionist.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Aliments")

public class Aliment implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String aliment;
    private String category;
    private double caloriesPerServing;
    

    public Aliment() {
        //constructor sin argumentos
    }

    public Aliment(String aliment, String category, double caloriesPerServing) {
        this.aliment = aliment;
        this.category = category;
        this.caloriesPerServing = caloriesPerServing;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getAliment() { return aliment; }
    public void setAliment(String aliment) { this.aliment = aliment; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public double getCaloriesPerServing() { return caloriesPerServing; }
    public void setCaloriesPerServing(double caloriesPerServing) { this.caloriesPerServing = caloriesPerServing; }

}