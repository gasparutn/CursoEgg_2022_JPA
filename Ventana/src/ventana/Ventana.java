package ventana;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Ventana extends JFrame {

    public JPanel panel;

    public Ventana() {
        this.setSize(500, 500); //Establecemos el tamano de la ventana
        this.setTitle("Libreria JPA"); // Titulo de la ventana
        //       this.setLocationRelativeTo(null); //Entablecemos ventana en el centro
        setLocation(1000, 200); // Establecemo la posicion inicia de la ventana
//      setBounds(800, 200, 500, 500); // Establecemos la posicion inicial y el temano de la ventana
//        setMinimumSize(new Dimension(500, 500)); // Establecemos el tamano minimo
        iniciarcomponentes();

        setDefaultCloseOperation(EXIT_ON_CLOSE); // Cierra la ejecucion del programa cuando se cierra la ventana

    }

    private void iniciarcomponentes() {
          colocarpaneles();
//        colocarEtiquetas();
//        colocarBotones();
//        colocarradiobotones();
//        colocarCajaDeTexto();
//        colocarAreaDeTexto();
//        colocarListasDesplegables();

    }

    private void colocarpaneles() {
        panel = new JPanel(); //creacion de un panel
        //  panel.setBackground(Color.green); // Establecemos el color del panel
        panel.setLayout(null); // Desctivamos el Diseno por defecto para que etiqueta tenga la pasicion asiganda
        this.getContentPane().add(panel);  //agregamos el panel a la ventana

    }

    private void colocarEtiquetas() {

        JLabel etiqueta = new JLabel();  // Creamos con JLabel una etiqueta
        // JLabel etiqueta = new JLabel("Opciones",SwingConstants.CENTER); sive para centra hacia la izq, derecha, el texto con el fondo de la etiqueta
        etiqueta.setText("Opciones"); // Establecemos el texto de la etiqueta
        etiqueta.setBounds(10, 10, 70, 40); // posicion de la etiqueta en relacion al tamano del texo
        etiqueta.setHorizontalAlignment(SwingConstants.CENTER); // Establecemos la alineacion horizontal del texto que de la etiqueta
        etiqueta.setForeground(Color.blue); // Entablecemos el color de la etiqueta
        etiqueta.setOpaque(true); // Establecemos pintar el fondo de la etiqueta
        etiqueta.setBackground(Color.red); // cambiamos el fondo de la etiqueta
        etiqueta.setFont(new Font("arial", Font.PLAIN, 14)); // Establecemos la fuente del texto
        panel.add(etiqueta); // agregamos la etiqueta a la ventana

        //Etiqueta 2 - etiqueta tipo IMAGEN
        ImageIcon imagen = new ImageIcon("gaspi.jpg");
        JLabel etiqueta2 = new JLabel(); // creamos un panel con la imagen del archivo JPG que tenemos
        etiqueta2.setBounds(80, 200, 300, 300);
        etiqueta2.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(etiqueta2.getWidth(), etiqueta.getHeight(), Image.SCALE_SMOOTH)));// ajustamos el tamano de la imagen
        panel.add(etiqueta2);
    }

    private void colocarBotones() {
        // Boton 1 de texto
        JButton boton1 = new JButton();
        boton1.setText("Click"); //Estblecemos un texto al boton
        boton1.setBounds(20, 20, 100, 40); //eje x, y , ancho , largo
        boton1.setEnabled(true); // true habilitar el boton, false inhabilitar el boton
        boton1.setMnemonic('a'); //Establecemos alt + a y el bonton funciona
        boton1.setForeground(Color.red);
        boton1.setFont(new Font("Arial", Font.BOLD, 16));

        panel.add(boton1);

        // Boton 2 de imagen
        JButton boton2 = new JButton();
        boton2.setText("Click"); //Estblecemos un texto al boton
        boton2.setBounds(20, 80, 100, 60); // eje x, y , ancho , largo
        boton2.setOpaque(true);
        ImageIcon clicAqui = new ImageIcon("boton.png");
        boton2.setIcon(new ImageIcon(clicAqui.getImage().getScaledInstance(boton2.getWidth(), boton2.getHeight(), Image.SCALE_SMOOTH)));
        boton2.setForeground(Color.red);
        panel.add(boton2);

        JButton boton3 = new JButton();
        boton3.setBounds(20, 80, 100, 60);
        boton3.setBorder(BorderFactory.createLineBorder(Color.blue, 4, false));
        panel.add(boton3);
    }

    // boton 3 radio botones / bontones de tilde opcion
    private void colocarradiobotones() {
        JRadioButton radioBoton1 = new JRadioButton("Opciones 1", true); // true esta marcado
        radioBoton1.setBounds(10, 50, 100, 50);
        radioBoton1.setEnabled(false); // desactivamos el radio boton 
        radioBoton1.setText("Menu"); // otra forma de agregar texto al boton ademas de hacerlo desde el constructor.
        radioBoton1.setFont(new Font("cooper black", 0, 16)); // fuente, tipo de fuente, y tamano
        panel.add(radioBoton1);

        JRadioButton radioBoton2 = new JRadioButton("Opciones 2", false); // no esta marcado
        radioBoton2.setBounds(10, 100, 100, 50);  //eje x, y , ancho , largo
        panel.add(radioBoton2);

        JRadioButton radioBoton3 = new JRadioButton("Opciones 3", false); // idem
        radioBoton3.setBounds(10, 150, 100, 50);  //eje x, y , ancho , largo
        panel.add(radioBoton3);

        ButtonGroup grupoRadioBotones = new ButtonGroup();

        grupoRadioBotones.add(radioBoton1); // esto permite que todos los botones no queden tildados sino que sea de un tilde la ves
        grupoRadioBotones.add(radioBoton2);
        grupoRadioBotones.add(radioBoton3);
    }

    private void colocarCajaDeTexto() {
        JTextField cajaTexto = new JTextField(); // vacia o agregar string()
        cajaTexto.setBounds(10, 50, 200, 30); //eje x, y , ancho , largo
        cajaTexto.setText("Hola");
        System.out.println("Texto que hay en la caja: "+ cajaTexto.getText());
        panel.add(cajaTexto);

    }
    
    private void colocarAreaDeTexto(){
        
        JTextArea areaTexto = new JTextArea();
        
        areaTexto.setBounds(20, 20, 300, 200);
        areaTexto.setText("Escriba el texto aqui...");
        areaTexto.append("Escribe por aqui"); // este metodo anade mas texto al area
        areaTexto.setEditable(false); // si esta en false no se puede editar el texto prestablecido
        System.out.println("El texto es:"+areaTexto.getText());
        panel.add(areaTexto);
        
    }
    
    private void colocarListasDesplegables(){
        String [] paises = {"Peru" , "Colombia" , "Argentina", "Ecuador"};
        
        JComboBox listaDesplegables = new JComboBox(paises);
        listaDesplegables.setBounds(20, 20, 100, 30);
        listaDesplegables.addItem("Chile"); // agregar objeto a la lista desplegable
        listaDesplegables.setSelectedItem("Argentina"); //Sellecciona el primer objeto visto
        panel.add(listaDesplegables);
        
    }
    
        
    
}
