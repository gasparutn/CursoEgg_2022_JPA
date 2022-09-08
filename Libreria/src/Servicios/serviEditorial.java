package Servicios;

import DaoLibreria.DAO;
import entidades.Editorial;
import entidades.Libro;
import java.util.Collection;
import java.util.Scanner;
import java.util.UUID;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

public class serviEditorial extends DAO {

    public serviEditorial() {
    }
    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("LibreriaPU");
    EntityManager em = emf.createEntityManager();

    public Editorial libroEditorial() throws Exception {

        try {

            Editorial L1edit = crearEditorial();
            

            em.getTransaction().begin();
            em.persist(L1edit);
            em.getTransaction().commit();
            
            return L1edit;

        } catch (Exception e) {
            throw e;
        }
    }

    public void buscarLibroxEditorial() throws Exception {
        try {

            System.out.print("Ingrese el Nombre de la Editorial: ");
            String busqEditorial = leer.nextLine();
            System.out.println("*************************");
            Collection<Libro> libroEdito = em.createQuery("select l FROM Libro l WHERE l.editorial.nombre = :nombre").setParameter("nombre", busqEditorial).getResultList();
            for (Libro listaE : libroEdito) {
                System.out.println("El libro del autor es: " + listaE.getTitulo() + ", su AUTOR se llama " + listaE.getAutor().getNombre() + ", el año de publicacion es: " + listaE.getAnio());
            }

            System.out.println("*************************\n");

        } catch (NoResultException e) {
            System.out.println("No se encontro el autor: ");
        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminarlibroxeditorial() {
        try {

            System.out.print("Ingrese el nombre de la Editorial que desea borrar:");
            String borrareditorial = leer.nextLine();

            Libro libroeditorial = (Libro) em.createQuery("Select l" + " FROM Libro l"
                    + " WHERE l.isbn = :autor").setParameter("autor", borrareditorial).getSingleResult();

            em.getTransaction().begin();
            em.remove(libroeditorial);
            em.getTransaction().commit();

        } catch (Exception e) {
            throw e;
        }
    }
    
    public Editorial buscarPorNombre(String nombre) {
        try {
            Editorial aux2 = (Editorial) em.createQuery("Select a FROM Editorial a WHERE a.nombre = :nombre").setParameter("nombre", nombre).getSingleResult();
            return aux2;
        } catch (NoResultException e) {
            return null;
        }
    }
    public Editorial crearEditorial() {
        System.out.print("Ingrese el nombre de la Editorial: ");
        String nombre = leer.nextLine();
        Editorial aux = buscarPorNombre(nombre);

        if (aux == null) {
            aux = new Editorial();
            aux.setNombre(nombre);
            aux.setId(UUID.randomUUID().toString());
            aux.setAlta(true);
        } else {
            System.out.println("La editorial no existe");
        }
        
        return aux;
    }
}

