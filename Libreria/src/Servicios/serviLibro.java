package Servicios;

import entidades.Libro;
import static entidades.Libro_.isbn;
import java.util.Scanner;
import java.util.UUID;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class serviLibro {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("LibreriaPU");
    EntityManager em = emf.createEntityManager();
    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    serviAutor sa = new serviAutor();
    serviEditorial ed = new serviEditorial();

    public serviLibro() {
    }

    public void crearlibro() {
        try {

            // creamos un libro
            Libro L1 = new Libro();
            L1.setIsbn(UUID.randomUUID().hashCode());
            System.out.println("Ingrese el titulo del libro: ");
            L1.setTitulo(leer.nextLine());
            System.out.println("Ingrese el año de publicacion: ");
            L1.setAnio(leer.nextInt());
            System.out.println("Ingrese cuanto ejemplares hay: ");
            L1.setEjemplares(leer.nextInt());
            System.out.println("Ingrese el numero de ejemplares prestados: ");
            L1.setEjemplares_Prestados(leer.nextInt());
            System.out.println("Ingrese el numero de ejemplares restantes: ");
            L1.setEjemplares_Restantes(leer.nextInt());
            L1.setAlta(true);
            L1.setAutor(sa.libroAutor());
            L1.setEditorial(ed.libroEditorial());

            em.getTransaction().begin();
            em.persist(L1);
            em.getTransaction().commit();

        } catch (Exception e) {
            throw e;
        }

    }

    public void eliminarlibro() {
        try {
                   
        System.out.println("Ingrese el nombre del libro que desea borrar:");
        String borrar= leer.nextLine();
        
        Libro libro1 = (Libro) em.createQuery("Select l" + " FROM Libro l"
                + " WHERE l.titulo = :titulo").setParameter("titulo", borrar).getSingleResult();
                
       
        em.getTransaction().begin();
        em.remove(libro1);
        em.getTransaction().commit();
        
        
        
        
        } catch (Exception e) {
           throw e;
        }
        
    }

}
