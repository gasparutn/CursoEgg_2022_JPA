package Servicios;

import DaoLibreria.DAO;
import entidades.Libro;
import java.util.Collection;
import java.util.InputMismatchException;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

public class serviLibro extends DAO {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("LibreriaPU");
    EntityManager em = emf.createEntityManager();
    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    serviAutor sa = new serviAutor();
    serviEditorial ed = new serviEditorial();

    public serviLibro() {
    }

    public Libro buscarPorNombre(String titulo) {

        try {
            Libro LT = (Libro) em.createQuery("Select l FROM Libro l where l.titulo  = :titulo").setParameter("titulo", titulo).getSingleResult();
            return LT;
        } catch (NoResultException e) {
            return null;
        }
    }

    public Libro buscarPorISBN(long AuxISBN) {

        try {
            Libro LISBN = (Libro) em.createQuery("Select l FROM Libro l where l.isbn  = :isbn").setParameter("isbn", AuxISBN).getSingleResult();
            return LISBN;
        } catch (NoResultException e) {
            return null;
        }
    }

    public void crearlibro() throws Exception {

        try {
            // creamos un libro
            Libro Laux = new Libro();
            Libro L1 = new Libro();
            long AuxISBN;
            do {
                try {
                    System.out.println("Ingrese el ISBN del libro: ");
                    AuxISBN = leer.nextLong();
                    leer.nextLine(); // baja el cursor a la siguiente liniea(limpia el bufer)
                    Laux = buscarPorISBN(AuxISBN); //Laux guarda el dato que compara con la Query
                    if (Laux != null) {  // Con el IF, Arroja el mensaje de que se encuentra repetido
                        System.out.println("Ya existe ese ISBN, ingrese otro");
                    }
                } catch (InputMismatchException e) { // capturamos el tipo de error y arrojamos el mensaje
                    leer.nextLine();
                    System.out.println("Se ha ingresado un caracter de tipo STRING, ingrese numeros solamente:\n");
                    Laux = new Libro(); // se crea un libro nuevo para reiniciar el bucle.
                }
            } while (Laux != null); //Si el ISBN se encuentra repetido, se repite el bucle, de lo contrario abandona y continua.
            String AuxTitulo;
            do {
                System.out.println("Ingrese el titulo del libro: ");
                AuxTitulo = leer.nextLine();
                Laux = buscarPorNombre(AuxTitulo);
                if (Laux != null) {
                    System.out.println("Ya existe ese libro, ingrese otro");
                }
            } while (Laux != null); // condicion principal de que no exista un mismo ISBN en la consulta Query
            L1.setTitulo(AuxTitulo);

            System.out.println("Ingrese el año de publicacion: ");
            L1.setAnio(leer.nextInt());
            leer.nextLine();

            System.out.println("Ingrese cuanto ejemplares hay: ");
            L1.setEjemplares(leer.nextInt());
            leer.nextLine();
            do {
                System.out.println("Ingrese el numero de ejemplares prestados: ");
                L1.setEjemplares_Prestados(leer.nextInt());

                leer.nextLine();
                if (L1.getEjemplares() < L1.getEjemplares_Prestados()) {
                    // throw new Exception("No chavon, no podes prestar mas de los que tenes");
                }

                if (L1.getEjemplares_Prestados() == 0) {
                    L1.setEjemplares_Restantes(L1.getEjemplares());
                    System.out.println("No se presto ningun ejemplar ");

                } else {
                    L1.setEjemplares_Restantes(L1.getEjemplares() - L1.getEjemplares_Prestados());
                }
                System.out.println("Los ejemplares restantes son: " + L1.getEjemplares_Restantes());

                if (L1.getEjemplares_Restantes() >= 0) {
                    L1.setAlta(true);
                } else {
                    L1.setAlta(false);
                    System.out.println("\n<<<<NO PUEDE PRESTAR MAS DE LO QUE TIENE>>>>, INGRESE UN N° VALIDO \n");
                }
            } while (L1.getEjemplares_Restantes() < 0);
            L1.setAutor(sa.libroAutor());
            L1.setEditorial(ed.libroEditorial());

            em.getTransaction().begin();
            em.persist(L1);
            em.getTransaction().commit();
            System.out.println("");
            System.out.println("     <<<<<<<Libro agregado con exito>>>>>>");

        } catch (CloneNotSupportedException e) {
            System.out.println("No se puede clonar el tipo de dato");
        } catch (Exception e) {
            throw e;
        }

    }

    public void consultarlibros1() throws Exception {
        try {
            System.out.println("********************************************************************************************************");
            System.out.println("Los libros disponibles son: ");

            Collection<Libro> listaLibros = em.createQuery("Select l" + " FROM Libro l").getResultList();
            for (Libro l : listaLibros) {

                System.out.println("Libro: " + l.getTitulo() + " >> ID ISBN: " + l.getIsbn() + l.getAutor() + " >>ANIO: " + l.getAnio()
                        + " >>" + l.getEditorial());
            }
            System.out.println("********************************************************************************************************\n");

        } catch (NoResultException e) {
            System.out.println("Error al mostra listado de libro existentes");
        } catch (Exception e) {
        }
    }

    public void consultarlibros2() throws Exception {
        try {
            System.out.println("*************************");
            System.out.println("Los libros disponibles son: \n");

            Collection<Libro> titulo = em.createQuery("Select l" + " FROM Libro l").getResultList();
            for (Libro l : titulo) {
                System.out.println("Libro: " + l.getTitulo());
            }
            System.out.println("*************************\n");

        } catch (NoResultException e) {
            System.out.println("No encontro el producto");
        } catch (Exception e) {
        }
    }

    public void buscarLibroxTitulo() throws Exception {
        try {

            System.out.print("Ingrese el Titulo del Libro: ");
            String busqAutor = leer.nextLine();

            Libro libroTitulo = (Libro) em.createQuery("Select l" + " FROM Libro l" + " WHERE l.titulo = :titulo").setParameter("titulo", busqAutor).getSingleResult();

            System.out.println("\nEl titulo es: " + libroTitulo.getTitulo() + ", año de Publicion>> " + libroTitulo.getAnio() + ", el autor del libro es: " + libroTitulo.getAutor().getNombre() + "\n");

            System.out.println("*************************\n");

        } catch (NoResultException e) {
            System.out.println("No se encontro el autor");
        } catch (Exception e) {
            throw e;
        }
    }

    public void buscarlibroxisbn() {
        try {
            System.out.print("Ingrese el ID ISBN del libro que desea buscar:");
            long busqueISBN = leer.nextLong();

            Libro libroisbn = (Libro) em.createQuery("SELECT l" + " FROM Libro l" + " WHERE l.isbn = :isbn").setParameter("isbn", busqueISBN).getSingleResult();

            System.out.println("\nEl libro encontrado es: " + libroisbn.getTitulo() + "\n");

            System.out.println("*************************\n");
        } catch (NoResultException e) {
            System.out.println("<<<<El ISBN ingresado no existe, ingrese uno valido porfavor>>>\n");
        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminarlibroxti() {
        try {
            System.out.print("Ingrese el NOMBRE del libro que desea borrar:");
            String borrarti = leer.nextLine();

            Libro libroEL = (Libro) em.createQuery("Select l" + " FROM Libro l"
                    + " WHERE l.titulo = :titulo").setParameter("titulo", borrarti).getSingleResult();

            em.getTransaction().begin();
            em.remove(libroEL);
            em.getTransaction().commit();
            em.close();
        } catch (NoResultException e) {
            System.out.println("El nombre del Libro no existe, ingrese uno valido");
        }
    }

    public void eliminarlibroxisbn() {
        try {
            System.out.print("Ingrese el ID ISBN del libro que desea borrar:");
            long borrarid = leer.nextLong();

            Libro libroID = (Libro) em.createQuery("Select l" + " FROM Libro l"
                    + " WHERE l.isbn = :isbn").setParameter("isbn", borrarid).getSingleResult();

            em.getTransaction().begin();
            em.remove(libroID);
            em.getTransaction().commit();

        } catch (Exception e) {
            throw e;
        }
    }

    public void editarlibroTI() {
        try {
            System.out.print("Ingrese el nombre del libro que desea modificar:");
            String modificar = leer.nextLine(); // variable que paso por referencia a la Query en su SET PARAMETRER

            Libro libroED = (Libro) em.createQuery("Select l" + " FROM Libro l"
                    + " WHERE l.titulo = :titulo").setParameter("titulo", modificar).getSingleResult();

            System.out.print("Ingrese el nuevo nombre: ");
            libroED.setTitulo(leer.nextLine());

            em.getTransaction().begin();
            em.merge(libroED);
            em.getTransaction().commit();

        } catch (Exception e) {
            throw e;
        }
    }

    public void editarlibroxAutor() throws Exception {

        try {
            System.out.print("Ingrese el Autor del libro que desea modificar:");
            String modificar2 = leer.nextLine();

            Collection<Libro> librosAU = em.createQuery("Select l FROM Libro l WHERE l.autor.nombre = :nombre").setParameter("nombre", modificar2).getResultList();

            int v1 = 1; // variable de eleccion del libro
            // CODIGO PARA EXTRAER UN OBJERO DE UN ARREGLO PARA eliminar, modificar etc.
            if (librosAU.isEmpty()) { // <<Devuelve el valor 1 (true) si hay un campo vacío; de lo contrario, devuelve el valor 0 (false).
                throw new Exception("No existe autor"); //Si esta vacia, capto la Exception y arrojo mensaje
            }
            System.out.println("Los libros encontrados son: \n");
            for (Libro libroUNI : librosAU) {
                System.out.println(String.format("%d. %s", v1, libroUNI.getTitulo()));
                v1++;// muesto los libros ENUMARADOS por titulo que estan en la base
            }
            int v2 = 1; // creo variable contador de libros 
            System.out.println("");
            System.out.println("Ingrese el numero del Libro que quiere modificar ");
            v1 = leer.nextInt(); // Selecciono el numero de libro que deseo modificar
            leer.nextLine();
            Libro libroaux = new Libro(); //creo un LIBROAUX para iterar el libro selecionado con el consultado en la Query
            for (Libro aux : librosAU) {
                if (v1 == v2) {  // si el Autor V1(selecciono) es igual a la posicion en donde se encuentra el libro encontrado
                    libroaux = aux; // el objeto creado es igual al libro encontrado
                }
                v2++;
            }
            libroaux.setAutor(sa.crearAutor()); // seteo el libro por AUTOR

            em.getTransaction().begin();
            em.merge(libroaux);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw e;
        }
    }

    public void editarlibroxNombreEDIT() throws Exception {

        try {

            System.out.print("Ingrese el NOMBRE de la EDITORIAL que desea modificar:");
            String modificar3 = leer.nextLine();

            Collection<Libro> librosED = em.createQuery("Select e FROM Libro e WHERE e.editorial.nombre = :nombre").setParameter("nombre", modificar3).getResultList();
            int v1 = 1;
            if (librosED.isEmpty()) {
                throw new Exception("No existe la Editorial que busca");
            }
            System.out.print("Las editoriales encontradas son: \n");
            for (Libro editoriales : librosED) {
                System.out.println(String.format("%d. %s", v1, editoriales.getTitulo()));
                v1++;
            }
            System.out.println("");
            System.out.println("Ingrese la editorial del Libro que desea modificar: ");
            v1 = leer.nextInt();
            int v2 = 1;
            Libro editos = new Libro();
            for (Libro aux : librosED) {
                if (v1 == v2) {
                    editos = aux;
                }
                v2++;
            }
            editos.setEditorial(ed.libroEditorial());
            em.getTransaction().begin();
            em.merge(librosED);
            em.getTransaction().commit();

        } catch (Exception e) {
            throw e;
        }
    }
}
