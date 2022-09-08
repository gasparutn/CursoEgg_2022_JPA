/*
 Acciones con el teclado en un panel de ventana
 */
package ventana;


import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


/**
 * https://www.youtube.com/watch?v=2_AteD52jCg
 */
public class Ejemplo3_EventoTeclado extends JFrame {

    private JPanel panel;
    private JTextField cajaTexto;
    private JTextArea areaTexto;
    private JButton boton;

    public Ejemplo3_EventoTeclado() {
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
//      etiquetaEvento1();
        cajaEvento2();
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
        
    private void cajaEvento2() {
        cajaTexto = new JTextField(); // vacia o agregar string()
        cajaTexto.setBounds(20, 30, 150, 30); //eje x, y , ancho , largo
        panel.add(cajaTexto);
       eventoDelTeclado();
    }

    private void areaEvento3() {
        areaTexto = new JTextArea();
        areaTexto.setBounds(230, 30, 200, 300);
        areaTexto.setFont(new Font("arial", 0, 15));
        panel.add(areaTexto);
    }

    private void botonEvento4() {
        boton = new JButton();
        boton.setText("!Pulsa Aqui!"); //Estblecemos un texto al boton
        boton.setBounds(150, 350, 150, 40); //eje x, y , ancho , largo
        boton.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(boton);

 
    }
    
    
    public void eventoDelTeclado(){
        KeyListener eventoTeclado = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent ke) {
           areaTexto.append("keyTyped\n"); // Funciones con caracteres comunes a,b,c etc , menos alt, ctrl etc
           }

            @Override
            public void keyPressed(KeyEvent ke) {
              areaTexto.append("keyPressed\n"); // Con solo presionar cualquier tecla ocurre Keypressed
            }

            @Override
            public void keyReleased(KeyEvent ke) {  /// si se mantiene presionada alguna tecla no ocurre la accion.
             areaTexto.append("keyReleased\n");
           //   condicionales. Solo funcionan la teclas que asignamos como condicion
              
              if(ke.getKeyChar() == 'p') {
                  areaTexto.append("Letra p\n");
              }
              if(ke.getKeyChar() == '\n') {
                  areaTexto.append("Enter\n");
              }
              if(ke.getKeyChar() == ' ') {
                  areaTexto.append("Espacio\n");
        }
           }
        };
        
        cajaTexto.addKeyListener(eventoTeclado);
    }
}
    
    