/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import main.Principal;
public class Completado extends JPanel implements ActionListener {
    // Atributos
    private ImageIcon icono;
    private Image fondo;
    private Timer t;
    JButton playButton;
    private JFrame marco;
    private Personaje p;
    private int v;
    // Constructores
    public Completado(JFrame marco){
        setDoubleBuffered(true); 
        this.marco = marco;  
        p = new Personaje();        playButton = new JButton();           
        this.v = p.getVidas();   
        setLayout(null);
        setFocusable(true);   
        iniComponents();    
        icono = new ImageIcon("src/images/final.png");         fondo = icono.getImage(); 
        t = new Timer(5, null); t.addActionListener(this);  t.start();
    }
    public void iniComponents(){
        ImageIcon playBtn1 = new ImageIcon("src/Botones/mn1.png"), playBtn2 = new ImageIcon("src/Botones/mn2.png"), playBtn3 = new ImageIcon("src/Botones/mn3.png");
        playButton.setBounds(500,480,258,85);   playButton.addActionListener(this); configBtn(playButton,playBtn1,playBtn2,playBtn3);  add(playButton); 
    }
    public void configBtn(JButton boton,ImageIcon img1,ImageIcon img2,ImageIcon img3){  boton.setIcon(img1);    boton.setBorderPainted(false);  boton.setContentAreaFilled(false);  boton.setFocusable(false);  boton.setRolloverEnabled(true);     boton.setRolloverIcon(img2);    boton.setPressedIcon(img3);    }
    // Metodos
    public void paint(Graphics g){
        g.drawImage(this.fondo,0,0,null);        setOpaque(false);      super.paint(g);        Graphics2D g2 = (Graphics2D)g;       Toolkit.getDefaultToolkit().sync();  g.dispose();  }     
    public void actionPerformed(ActionEvent e){
        if (e.getSource()==playButton) {    try{    new Principal(this.marco);  } catch(Exception excep) {  System.exit(0); }         } 
        repaint();
    }   
}