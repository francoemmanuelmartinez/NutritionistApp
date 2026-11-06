package appNutritionist.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DietsDetails")


public class DietDetail implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    /*private List<Aliment> aliments = new ArrayList<>();*/
   
    
    public DietDetail() {
        //constructor sin argumentos
    }

    public DietDetail(String nombre) {
        this.nombre = nombre;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    /*public List<Aliment> getAliments() { return aliments; }
    public void setAliments(List<Aliment> aliments) { this.aliments = aliments; }*/
    
}
