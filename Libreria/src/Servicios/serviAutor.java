package Servicios;

import entidades.Autor;
import java.util.Scanner;
import java.util.UUID;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class serviAutor {

    public serviAutor() {
    }

     Scanner leer = new Scanner(System.in).useDelimiter("\n");  
    public Autor libroAutor() {
        try {

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("LibreriaPU");
            EntityManager em = emf.createEntityManager();

            Autor L1autor = new Autor();
            L1autor.setId(UUID.randomUUID().toString());
            System.out.println("Ingrese el AUTOR del libro: ");
            L1autor.setNombre(leer.nextLine());
            L1autor.setAlta(true);

            em.getTransaction().begin();
            em.persist(L1autor);
            em.getTransaction().commit();
           return L1autor;
        } catch (Exception e) {
            throw e;

        }
       
    }
}
