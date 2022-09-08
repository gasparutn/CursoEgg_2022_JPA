package ventana;
/*
Ejemplo de las acciones del cursor del Mouse sobre un boton cualquiera.
*/
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * https://www.youtube.com/watch?v=6L5I5cc0bQ8
 */
public class Ejemplo2_Eventos_OyenteRaton extends JFrame {

    private JPanel panel;
    private JTextField cajaTexto;
    private JTextArea areaTexto;
    private JButton boton;

    public Ejemplo2_Eventos_OyenteRaton() {
        this.setSize(500, 500); //Establecemos el tamano de la ventana
        this.setTitle("Eventos"); // Titulo de la ventana
        //       this.setLocationRelativeTo(null); //Entablecemos ventana en el centro
        setLocation(1000, 200); // Establecemo la posicion inicia de la ventana
//      setBounds(800, 200, 500, 500); // Establecemos la posicion inicial y el temano de la ventana
//        setMinimumSize(new Dimension(500, 500)); // Establecemos el tamano minimo
        iniciarcomponentes();

        setDefaultCloseOperation(EXIT_ON_CLOSE); // Cierra la ejecucion del programa cuando se cierra la ventana
    }

    private void iniciarcomponentes() {
        colocarpaneles();
//            etiquetaEvento1();
//            cajaEvento2();
        areaEvento3();
        botonEvento4();
    }

    private void colocarpaneles() {
        panel = new JPanel(); //creacion de un panel
        //  panel.setBackground(Color.green); // Establecemos el color del panel
        panel.setLayout(null); // Desctivamos el Diseno por defecto para que etiqueta tenga la pasicion asiganda
        this.getContentPane().add(panel);  //agregamos el panel a la ventana

    }

//        private void colocarpanel() {
//            panel = new JPanel();
//            panel.setLayout(null);
//            this.add(panel);  //agregamos el panel a la ventana
//        }
//        private void etiquetaEvento1() {
//            JLabel etiqueta = new JLabel();
//            etiqueta.setText(); // 
//            etiqueta.setBounds(60, 20, 150, 20); // 
//            panel.add(etiqueta);
//        }
//        private void cajaEvento2() {
//            cajaTexto = new JTextField(); // vacia o agregar string()
//            cajaTexto.setBounds(60, 90, 200, 30); //eje x, y , ancho , largo
//            panel.add(cajaTexto);
//        }
    private void areaEvento3() {
        areaTexto = new JTextArea();
        areaTexto.setBounds(20, 20, 200, 300);
        areaTexto.setFont(new Font("arial", 0, 15));
        panel.add(areaTexto);
    }

    private void botonEvento4() {
        boton = new JButton();
        boton.setText("!Pulsa Aqui!"); //Estblecemos un texto al boton
        boton.setBounds(150, 350, 150, 40); //eje x, y , ancho , largo
        boton.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(boton);

        eventoOyenteDeRaton();
    }

    private void eventoOyenteDeRaton() {
        //Agregando oyente de Raton - MouseListene
        MouseListener oyenteDeRaton = new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {
                areaTexto.append("mouseClicked\n");  //click de mouse presionar y soltar
            }
            @Override
            public void mousePressed(MouseEvent me) {
                areaTexto.append("mousePressed\n");        //click solo pulsar y se da la accion
            }
            @Override
            public void mouseReleased(MouseEvent me) {  // click mouse y soltar fuera del click
                areaTexto.append("mouseReleased\n");
            }
            @Override
            public void mouseEntered(MouseEvent me) {  // con solo pasar el cursor sobre el boton se ejecuta la accion
                areaTexto.append("mouseEntered\n");
            }
            @Override
            public void mouseExited(MouseEvent me) {  // si se ingresa con el cursor al boton ocurre MouseEntered y si salimos MouseExited
                areaTexto.append("mouseExited\n");
            }
        };
        boton.addMouseListener(oyenteDeRaton);
    }
}
