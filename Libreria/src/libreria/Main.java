package libreria;

import Servicios.serviAutor;
import Servicios.serviEditorial;
import Servicios.serviLibro;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        
        try {

            serviLibro BiblioLibro = new serviLibro();
            serviEditorial BiblioEdit = new serviEditorial();
            serviAutor BiblioAuto = new serviAutor();
            orquestador submenu1 = new orquestador();
            
            while (true) {

                System.out.println(">>>>>>>INGRESE LA OPCION DE CONSULTA QUE DESEE INDICANDO EL NUMERO<<<<<<<");
                System.out.println("");
                System.out.println("1. Crear base de datos Librería.");
                System.out.println("2. Agregar, modificar o elimianar libros");
                System.out.println("3. Búsqueda de un Autor por TITULO.");
                System.out.println("4. Búsqueda de un libro por ISBN.");
                System.out.println("5. Búsqueda de un libro por Título.");
                System.out.println("6. Búsqueda de un libro/s por nombre de Autor.");
                System.out.println("7. Búsqueda de un libro/s por nombre de Editorial.");
                System.out.println("8. CONSULTAR BASE COMPLETA");
                System.out.println("9. Salir");

                int menu = 0;
                menu = leer.nextInt();
                System.out.println("");
                
                if (menu < 1 || menu > 9) {
                    do {
                        System.out.print("Por favor, ingrese una opcion correcta > ");
                        menu = leer.nextInt();
                    } while (menu < 1 || menu > 9);
                }
                if (menu == 9) {
                    break;
                }

                switch (menu) {

                    case 1:
                        BiblioLibro.crearlibro();
                        
                        break;
                    case 2:
                        submenu1.submenu();
                        break;
                    case 3:
                        BiblioLibro.consultarlibros1();
                        BiblioAuto.buscarAutorxNombre();
                        break;
                    case 4:
                        BiblioLibro.consultarlibros1();
                        BiblioLibro.buscarlibroxisbn();
                        break;
                    case 5:
                        BiblioLibro.consultarlibros2();
                        BiblioLibro.buscarLibroxTitulo();
                        break;
                    case 6:
                        BiblioLibro.consultarlibros1();
                        BiblioAuto.buscarLibroxAutor();
                        break;
                    case 7:
                        BiblioLibro.consultarlibros1();
                        BiblioEdit.buscarLibroxEditorial();
                       
                        break;
                    case 8:
                        BiblioLibro.consultarlibros1();
                        break;
                        
                    default:
                        System.out.println("*****Ha ingresado un numero incorrecto******\n     >>>>VUELVA A INTENTAR<<<<\n");
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
