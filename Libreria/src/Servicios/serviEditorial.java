package Servicios;

import entidades.Editorial;
import java.util.Scanner;
import java.util.UUID;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class serviEditorial {

    public serviEditorial() {
    }
    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    public Editorial libroEditorial() {

        try {

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("LibreriaPU");
            EntityManager em = emf.createEntityManager();

            Editorial L1edit = new Editorial();
            L1edit.setId(UUID.randomUUID().toString());
            System.out.println("Ingrese el nombre de la editorial: ");
            L1edit.setNombre(leer.nextLine());
            L1edit.setAlta(true);

            em.getTransaction().begin();
            em.persist(L1edit);
            em.getTransaction().commit();
            return L1edit;
        } catch (Exception e) {
            throw e;
        }

    }

}
