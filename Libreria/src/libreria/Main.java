package libreria;

import Servicios.serviLibro;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        try {

            serviLibro BiblioLibro = new serviLibro();
            while (true) {

                System.out.println("*******INGRESE LA OPCION DE CONSULTA QUE DESEE INDICANDO EL NUMERO*******");
                System.out.println("");
                System.out.println("1. Crear base de datos Librería.");
                System.out.println("2. ******");
                System.out.println("3. Búsqueda de un Autor por nombre.");
                System.out.println("4. Búsqueda de un libro por ISBN.");
                System.out.println("5. Búsqueda de un libro por Título.");
                System.out.println("6. Búsqueda de un libro/s por nombre de Autor.");
                System.out.println("7. Búsqueda de un libro/s por nombre de Editorial.");
                System.out.println("8. *****");
                System.out.println("9. Salir");

                int menu = 0;
                menu = leer.nextInt();
                System.out.println("");

                if (menu == 9) {
                    break;

                }

                switch (menu) {

                    case 1:
                        BiblioLibro.crearlibro();

                        break;

                    case 2:
                        BiblioLibro.eliminarlibro();
                        break;
//                    case 3:
//                        break;

                    default:
                        System.out.println("*****Ha ingresado un letra incorrecta******\n          >>>>VUELVA A INTENTAR<<<<\n");

                }

            }

        } catch (Exception e) {
            throw e;
        }

    }

}
