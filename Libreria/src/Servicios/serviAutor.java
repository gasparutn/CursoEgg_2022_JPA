package Servicios;

import entidades.Autor;
import entidades.Libro;
import java.util.Collection;
import java.util.Scanner;
import java.util.UUID;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

public class serviAutor {

    public serviAutor() {
    }
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("LibreriaPU");
    EntityManager em = emf.createEntityManager();

    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public Autor libroAutor() {
        try {
            Autor L1autor = crearAutor();

            em.getTransaction().begin();
            em.persist(L1autor);
            em.getTransaction().commit();
            return L1autor;
        } catch (Exception e) {
            throw e;
        }
    }

    public void buscarLibroxAutor() throws Exception {
        try {

            System.out.print("Ingrese el Nombre del autor: ");
            String busqAutor = leer.nextLine();

            Collection<Libro> libroAutor = em.createQuery("SELECT l FROM Libro l WHERE l.autor.nombre = :nombre").setParameter("nombre", busqAutor).getResultList();
            for (Libro lista : libroAutor) {

                System.out.println("\nEl libro del autor es: " + lista.getTitulo() + "\n");
            }
            System.out.println("*************************\n");

        } catch (NoResultException e) {
            System.out.println("No se encontro el autor: ");
        } catch (Exception e) {
            throw e;
        }
    }

    public void buscarAutorxNombre() throws Exception {
        try {

            System.out.print("Ingrese el Nombre del autor:");
            String busqAutor = leer.nextLine();
            System.out.println("*************************");
            Collection<Autor> libroAutor = em.createQuery("Select a FROM Autor a WHERE a.nombre = :nombre").setParameter("nombre", busqAutor).getResultList();
            for (Autor listautor : libroAutor) {
                System.out.println(listautor.toString());
            }

            System.out.println("*************************\n");

        } catch (NoResultException e) {
            System.out.println("No se encontro el autor");
        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminarlibroxautor() {
        try {

            System.out.print("Ingrese el ID ISBN del libro que desea borrar:");
            String borrarautor = leer.nextLine();

            Libro libroautor = (Libro) em.createQuery("Select l" + " FROM Libro l"
                    + " WHERE l.isbn = :autor").setParameter("autor", borrarautor).getSingleResult();

            em.getTransaction().begin();
            em.remove(libroautor);
            em.getTransaction().commit();

        } catch (Exception e) {
            throw e;
        }
    }

    public Autor buscarPorNombre(String nombre) {
        try {
            Autor aux = (Autor) em.createQuery("Select a FROM Autor a WHERE a.nombre = :nombre").setParameter("nombre", nombre).getSingleResult();
            return aux;
        } catch (NoResultException e) {
            return null;
        }
    }

    public Autor crearAutor() {
        System.out.print("Ingrese el nombre del autor: ");
        String nombre = leer.nextLine();
        Autor aux = buscarPorNombre(nombre);

        if (aux == null) {
            aux = new Autor();
            aux.setNombre(nombre);
            aux.setId(UUID.randomUUID().toString());
            aux.setAlta(true);
        } else {
            System.out.println("El autor ya existe");
        }
        
        return aux;
    }
}