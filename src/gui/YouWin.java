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
public class YouWin extends JPanel implements ActionListener {
    // Atributos
    private ImageIcon icono;
    private Image fondo;
    private Timer t;
    JButton playButton, volverJugar;
    private JFrame marco;
    private Personaje p;
    private Font font;
    private int v, nivel, cont_coins, total_coin, cont_gemas, total_gema;
    private String msg_coins, msg_gemas;
    // Constructores
    public YouWin(JFrame marco, int[] send){
        setDoubleBuffered(true); 
        this.marco = marco; 
        this.nivel = send[0];    cont_coins = send[1];        total_coin = send[2];   cont_gemas = send[3];   total_gema = send[4];
        setMessages();
        p = new Personaje();        playButton = new JButton();        volverJugar = new JButton();        
        this.v = p.getVidas();   
        setLayout(null);
        setFocusable(true);   
        iniComponents();    
        icono = new ImageIcon("src/images/nivelcomplete.png");         fondo = icono.getImage(); 
        t = new Timer(5, null); t.addActionListener(this);  t.start();
    }
    public void setMessages(){
        font = new Font("Intensa Fuente", Font.PLAIN,80); msg_coins = cont_coins+ " / " +total_coin;  msg_gemas =  cont_gemas+ " / " +total_gema; 
    }
    public void iniComponents(){
        ImageIcon playBtn1 = new ImageIcon("src/Botones/mn1.png"), playBtn2 = new ImageIcon("src/Botones/mn2.png"), playBtn3 = new ImageIcon("src/Botones/mn3.png"),vjBtn1 = new ImageIcon("src/Botones/sg1.png"), vjBtn2 = new ImageIcon("src/Botones/sg2.png"), vjBtn3 = new ImageIcon("src/Botones/sg3.png");
        playButton.setBounds(500,480,258,85);   playButton.addActionListener(this); configBtn(playButton,playBtn1,playBtn2,playBtn3);  add(playButton);     volverJugar.setBounds(500,600,258,85);   volverJugar.addActionListener(this); configBtn(volverJugar,vjBtn1,vjBtn2,vjBtn3);  add(volverJugar);
    }
    public void configBtn(JButton boton,ImageIcon img1,ImageIcon img2,ImageIcon img3){  boton.setIcon(img1);    boton.setBorderPainted(false);  boton.setContentAreaFilled(false);  boton.setFocusable(false);  boton.setRolloverEnabled(true);     boton.setRolloverIcon(img2);    boton.setPressedIcon(img3);    }
    // Metodos
    public void paint(Graphics g){
        g.drawImage(this.fondo,0,0,null);        setOpaque(false);      super.paint(g);        Graphics2D g2 = (Graphics2D)g;   
        g2.setColor(Color.white);   g2.setFont(font);  g2.drawString(msg_coins, 490, 410);  g2.drawString(msg_gemas, 490, 290);
        Toolkit.getDefaultToolkit().sync();  g.dispose();  }     
    public void actionPerformed(ActionEvent e){
        if (e.getSource()==playButton) {    try{    new Principal(this.marco);  } catch(Exception excep) {  System.exit(0); }         } 
        if (e.getSource()==volverJugar) {   try{    new Principal(this.marco, this.v, this.nivel);  } catch(Exception excep) {  System.exit(0);}  }     
        repaint();
    }   
}