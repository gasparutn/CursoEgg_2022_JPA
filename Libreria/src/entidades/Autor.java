package entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Autor implements Serializable {

    @Id
    private String id;
    private String nombre;
    private boolean alta=true;

    public Autor() {
    }

    public String getId() {
        return id;
    }

    public Autor(String id, String nombre, boolean alta) {
        this.id = id;
        this.nombre = nombre;
        this.alta = alta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isAlta() {
        return alta;
    }

    public void setAlta(boolean alta) {
        this.alta = alta;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return ">>> AUTOR NOMBRE= " + nombre + ", id N> " + id + ", alta= " + alta + '}';
    }
             
}
