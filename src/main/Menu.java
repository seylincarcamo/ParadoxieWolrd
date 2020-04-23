/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import gui.Personaje;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
public class Menu extends JPanel implements ActionListener {
    // Atributos
    //botones
    //fin botones
    private ImageIcon icono;
    private Image fondo;
    private Timer t;
    private JFrame marco;
    private int v;
    private Personaje p;    
    //botones    
    JButton playButton, exitButton;
    // Constructores
    public Menu(JFrame marco){
        setDoubleBuffered(true);
        this.marco = marco;  
        this.p = new Personaje();
        this.v = p.getVidas();
        //System.out.println("menu envio > "+this.v );
        //this.p = new Personaje();
        //this.p.setVidas(2);
        playButton = new JButton();
        exitButton = new JButton();
        setLayout(null); setFocusable(true);
        iniComponents();
        icono = new ImageIcon("src/images/PARADOXIE.gif");   fondo = icono.getImage();
        t = new Timer(5, null); t.addActionListener(this);  t.start();
    }

    public void iniComponents(){
        ImageIcon playBtn1 = new ImageIcon("src/Botones/j1.png");ImageIcon playBtn2 = new ImageIcon("src/Botones/j2.png");ImageIcon playBtn3 = new ImageIcon("src/Botones/j3.png");
        ImageIcon exitBtn1 = new ImageIcon("src/Botones/s1.png");ImageIcon exitBtn2 = new ImageIcon("src/Botones/s2.png");ImageIcon exitBtn3 = new ImageIcon("src/Botones/s3.png");
        playButton.setBounds(500,250,258,85);   playButton.addActionListener(this); configBtnPlay(playButton,playBtn1,playBtn2,playBtn3);  add(playButton);          
        exitButton.setBounds(500,400,258,85);   exitButton.addActionListener(this); configBtnExit(exitButton,exitBtn1,exitBtn2,exitBtn3);  add(exitButton);         
    }
    public void configBtnPlay(JButton boton,ImageIcon img1,ImageIcon img2,ImageIcon img3){
        boton.setIcon(img1);    boton.setBorderPainted(false);  boton.setContentAreaFilled(false);  boton.setFocusable(false);
        boton.setRolloverEnabled(true);     boton.setRolloverIcon(img2);    boton.setPressedIcon(img3);
    }
    public void configBtnExit(JButton boton,ImageIcon img1,ImageIcon img2,ImageIcon img3){
        boton.setIcon(img1);    boton.setBorderPainted(false);  boton.setContentAreaFilled(false);  boton.setFocusable(false);
        boton.setRolloverEnabled(true);     boton.setRolloverIcon(img2);    boton.setPressedIcon(img3);
    }
    // Metodos
    public void paint(Graphics g){
         g.drawImage(this.fondo,0,-10,null); 
        setOpaque(false);
        super.paint(g);
        Graphics2D g2 = (Graphics2D)g;        
        Toolkit.getDefaultToolkit().sync();
        g.dispose();    
    } 

    public void actionPerformed(ActionEvent e){
        /**Boton*/
        if (e.getSource()==playButton) {
            //System.out.println("click JUGAR");
            try{
                 new Principal(this.marco, this.v, 1);//se denifne el nivel por defecto a empezar
            } catch(Exception excep) {
                System.exit(0);
            }
        }
        if (e.getSource()==exitButton) {
            //System.out.println("click Salir");
            try{
               // Thread.sleep(500);
                System.exit(0);
            } catch(Exception excep) {
                System.exit(0);
            }
        }
        /**Boton*/        
        repaint();
    }    
}

