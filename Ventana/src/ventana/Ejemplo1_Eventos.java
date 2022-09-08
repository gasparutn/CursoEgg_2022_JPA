/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventana;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * https://www.youtube.com/watch?v=6L5I5cc0bQ8 Video 104
 */
public class Ejemplo1_Eventos extends JFrame {

    private JPanel panel;
    private JLabel saludo;
    private JTextField cajaTexto;
    private JButton boton;

    public Ejemplo1_Eventos() {
        this.setSize(500, 500); //Establecemos el tamano de la ventana
        this.setTitle("Eventos"); // Titulo de la ventana
        //       this.setLocationRelativeTo(null); //Entablecemos ventana en el centro
        //       setLocation(500, 200); // Establecemo la posicion inicia de la ventana
//      setBounds(800, 200, 500, 500); // Establecemos la posicion inicial y el temano de la ventana
//        setMinimumSize(new Dimension(500, 500)); // Establecemos el tamano minimo

        iniciarcomponentes();

        setDefaultCloseOperation(EXIT_ON_CLOSE); // Cierra la ejecucion del programa cuando se cierra la ventana

    }

    private void iniciarcomponentes() {
        colocarpanel();
        etiquetaEvento1();
        cajaEvento2();
    //  areaEvento3();
        botonEvento4();
    }

//        private void colocarpaneles() {
//            panel = new JPanel(); //creacion de un panel
//            //  panel.setBackground(Color.green); // Establecemos el color del panel
//            panel.setLayout(null); // Desctivamos el Diseno por defecto para que etiqueta tenga la pasicion asiganda
//            this.getContentPane().add(panel);  //agregamos el panel a la ventana
//
//        }
    private void colocarpanel() {
        panel = new JPanel();
        panel.setLayout(null);
        this.add(panel);  //agregamos el panel a la ventana

    }

    private void etiquetaEvento1() {
        JLabel etiqueta = new JLabel();
        etiqueta.setText("Ingrese su nombre"); // 
        etiqueta.setBounds(60, 20, 150, 20); // 
        panel.add(etiqueta);
    }

    private void cajaEvento2() {
        cajaTexto = new JTextField(); // vacia o agregar string()
        cajaTexto.setBounds(60, 90, 200, 30); //eje x, y , ancho , largo
        panel.add(cajaTexto);
    }

    private void areaEvento3() {
        JTextArea areaTexto = new JTextArea();
        areaTexto.setBounds(60, 150, 200, 200);
        areaTexto.setEditable(true);
        panel.add(areaTexto);
    }

    private void botonEvento4() {
        boton = new JButton();
        boton.setText("!Pulsa Aqui!"); //Estblecemos un texto al boton
        boton.setBounds(60, 40, 150, 40); //eje x, y , ancho , largo
        boton.setForeground(Color.red);
        boton.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(boton);
       
        saludo = new JLabel();
        saludo.setBounds(60, 140, 300, 40);
        saludo.setFont(new Font("arial", 1, 20));
        panel.add(saludo);
        eventoOyenteDeAccion();

    }

    private void eventoOyenteDeAccion() {
        // Agragando Evento de tipo ActionListener
        ActionListener oyenteDeAccion = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                saludo.setText("Hola " + cajaTexto.getText());
            }
        };
        boton.addActionListener(oyenteDeAccion);
    }

}
