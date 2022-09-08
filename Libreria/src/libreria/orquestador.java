package libreria;

import DaoLibreria.DAO;
import Servicios.serviAutor;
import Servicios.serviEditorial;
import Servicios.serviLibro;
import java.util.Scanner;
import javax.persistence.NoResultException;

public class orquestador extends DAO {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    serviLibro Libros = new serviLibro();
    serviEditorial LibroE = new serviEditorial();
    serviAutor LibroA = new serviAutor();

    public void submenu() throws Exception {
        try {
            System.out.println("\n*******************************************************");
            System.out.println("Ha ingresado al Submenu opcion 2>>>Indique una <LETRA>");
            System.out.println("*******************************************************");

            while (true) {
                System.out.println("a. Agregar: ");
                System.out.println("b. Modificar: ");
                System.out.println("c. Eliminar:");
                System.out.println("d. Volver al menu anterior: ");

                String submenu = leer.nextLine();
                if (submenu.equals("d")) {
                    break;
                }
                switch (submenu) {

                    case "a":
                        Libros.crearlibro();
                        Libros.consultarlibros2();
                        break;
                    case "b":
                        submenuB();
                        break;
                    case "c":
                        submenuC();
                        break;
                    default:
                        System.out.println("Ha ingresa una letra incorrecta");
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void submenuB() throws Exception {
        try {
            System.out.println("*******************************************************\n");
            System.out.println("Ha ingresado al Submenu opcion 'B' >>>Indique una <LETRA>");
            System.out.println("*******************************************************\n");

            while (true) {
                System.out.println("a. Modificar por TITULO: ");
                System.out.println("b. Modificar por NOMBRE AUTOR: ");
                System.out.println("c. Modificar por nombre IDITORIAL: ");
                System.out.println("d. Consultar Lista: ");
                System.out.println("e. Volver al menu >>Agregar,Modificar,Eliminar<< ");

                String submenu = leer.nextLine();
                if (submenu.equals("e")) {
                    break;
                }
                switch (submenu) {

                    case "a":
                        Libros.consultarlibros1();
                        Libros.editarlibroTI();
                        break;
                    case "b":
                        try {
                            Libros.consultarlibros1();
                            Libros.editarlibroxAutor();
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                        break;
                    case "c":
                        try {
                            Libros.consultarlibros1();
                            Libros.editarlibroxNombreEDIT();
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                        break;
                    case "d":
                        Libros.consultarlibros1();
                        break;
                    case "e":

                        break;

                    default:
                        System.out.println("Ha ingresa una letra incorrecta");
                }
            }
        } catch (NoResultException e) {
            System.out.println("Ha ingreso un tipo de dato incorrecto, intente nuevamente");
        } catch (Exception e) {
        }
    }

    public void submenuC() throws Exception {
        try {
            System.out.println("*******************************************************");
            System.out.println("Ha ingresado al Submenu opcion 'B' >>>Indique una <LETRA>");
            System.out.println("*******************************************************");

            while (true) {
                System.out.println("a. Eliminar por TITULO: ");
                System.out.println("b. Eliminar por numero de ID ISBN: ");
                System.out.println("c. Eliminar por NOMBRE AUTOR: ");
                System.out.println("d. Eliminar por nombre IDITORIAL: ");
                System.out.println("e. Volver al menu >>Agregar,Modificar,Eliminar<< ");

                String submenu = leer.nextLine();
                if (submenu.equals("e")) {
                    break;
                }
                switch (submenu) {

                    case "a":
                        Libros.consultarlibros1();
                        Libros.eliminarlibroxti();
                        break;
                    case "b":
                        Libros.consultarlibros1();
                        Libros.eliminarlibroxisbn();
                        break;
                    case "c":
                        Libros.consultarlibros1();
                        Libros.editarlibroxAutor();
                        break;
                    case "d":
                        Libros.consultarlibros1();
                        LibroE.eliminarlibroxeditorial();
                        break;
                    case "e":

                        break;

                    default:
                        System.out.println("Ha ingresa una letra incorrecta");
                }
            }
        } catch (NoResultException e) {
            System.out.println("Ha ingreso un tipo de dato incorrecto, intente nuevamente");
        } catch (Exception e) {
        }
    }

}
