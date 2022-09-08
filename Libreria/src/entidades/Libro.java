package entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Libro implements Serializable {

    @Id
    private long isbn;
    private String titulo;
    private Integer anio;
    private Integer ejemplares;
    private Integer ejemplares_Prestados;
    private Integer ejemplares_Restantes;
    private boolean alta=true;
    @OneToOne
    private Autor autor;
    @OneToOne
    private Editorial editorial;

    public Libro() {
    }
    @Override
    public Libro clone() throws CloneNotSupportedException{
        Libro titulos=null;
        try{
            titulos=(Libro)super.clone();
        }catch(CloneNotSupportedException ex){
            System.out.println(" no se puede duplicar");
        }
        return titulos;
        
    }
    
    public Libro(long isbn, String titulo, Integer anio, Integer ejemplares, Integer ejemplares_Prestados, Integer ejemplares_Restantes, boolean alta, Autor autor, Editorial editorial) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.anio = anio;
        this.ejemplares = ejemplares;
        this.ejemplares_Prestados = ejemplares_Prestados;
        this.ejemplares_Restantes = ejemplares_Restantes;
        this.alta = alta;
        this.autor = autor;
        this.editorial = editorial;
    }

   
    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public Integer getEjemplares() {
        return ejemplares;
    }

    public void setEjemplares(Integer ejemplares) {
        this.ejemplares = ejemplares;
    }

    public Integer getEjemplares_Prestados() {
        return ejemplares_Prestados;
    }

    public void setEjemplares_Prestados(Integer ejemplares_Prestados) {
        this.ejemplares_Prestados = ejemplares_Prestados;
    }

    public Integer getEjemplares_Restantes() {
        return ejemplares_Restantes;
    }

    public void setEjemplares_Restantes(Integer ejemplares_Restantes) {
        this.ejemplares_Restantes = ejemplares_Restantes;
    }

    public boolean isAlta() {
        return alta;
    }

    public void setAlta(boolean alta) {
        this.alta = alta;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }

    @Override
    public String toString() {
        return "Libro{" + " isbn= " + isbn + ", titulo= " + titulo + ", anio=" + anio + ", ejemplares= " + ejemplares + ", ejemplares_Prestados= " + ejemplares_Prestados + ", ejemplares_Restantes=" + ejemplares_Restantes + ", alta=" + alta + ", autor=" + autor + ", editorial=" + editorial + '}';
    }
}
