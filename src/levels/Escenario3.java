/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package levels;
import gui.Estado;
import gui.Personaje;
import interfaces.Interface_MyMethods;
import interfaces.MyMethods;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import main.Principal;
import objects.CoinGema;
import objects.Door;
import objects.Monster;
import objects.MoverObjects;

public class Escenario3 extends JPanel implements ActionListener, KeyListener {
  private ImageIcon icono;
  
  private Image fondo;
  
  private Timer t;
  
  private MyMethods mis_metodos;
  
  private Personaje p1;
  
  private Monster[] monster_wolf;
  
  private MoverObjects[] fnd;
  
  private MoverObjects[] suelo;
  
  private MoverObjects[] pisos;
  
  private MoverObjects[] sierras;
  
  private MoverObjects door;
  
  private CoinGema[] coins;
  
  private String msg_coins;
  
  private String msg_gemas;
  
  private String msg_vidas;
  
  private String msg_nivel;
  
  private Font font;
  
  private boolean gameEnded;
  
  private boolean coinsVerif;
  
  private boolean cancel;
  
  private Estado[] est;
  
  private JFrame marco;
  
  private int comprobar;
  
  private int nivel;
  
  private int cont_coins;
  
  private int cont_gemas;
  
  private int cont_vidas;
  
  private int rest_vidas;
  
  JButton playButton = new JButton();
  
  public Escenario3(JFrame marco, int v, int nivel) {
    setDoubleBuffered(true);
    this.marco = marco;
    this.rest_vidas = v;
    this.nivel = nivel;
    initVariables();
    iniButtons();
    this.t = new Timer(5, null);
    this.t.addActionListener(this);
    this.t.start();
    addKeyListener(this);
    setFocusable(true);
    setMessages();
  }
  
  public void initVariables() {
    this.p1 = new Personaje();
    this.est = new Estado[4];
    this.mis_metodos = new MyMethods();
    animar((Interface_MyMethods)this.mis_metodos);
    this.door = (MoverObjects)new Door(7727, 268, this.nivel);
    this.monster_wolf = new Monster[4];
    this.monster_wolf[0] = new Monster(-1500, 500, 2);
    this.monster_wolf[1] = new Monster(-1700, 500, 2);
    this.monster_wolf[2] = new Monster(-2200, 500, 2);
    this.monster_wolf[3] = new Monster(-2650, 500, 2);
    for (int x = 0; x < this.est.length; x++)
      this.est[x] = new Estado(x); 
    this.cont_coins = 0;
    this.cont_gemas = 0;
    this.gameEnded = false;
    this.coinsVerif = false;
    this.cancel = true;
  }
  
  public void setMessages() {
    this.font = new Font("Intensa Fuente", 0, 20);
    this.msg_coins = "" + this.cont_coins;
    this.msg_gemas = "" + this.cont_gemas;
    this.msg_vidas = "" + this.rest_vidas;
    this.msg_nivel = "" + this.nivel;
  }
  
  public void iniButtons() {
    ImageIcon btn1 = new ImageIcon("src/images/Botones/m1.png"), btn2 = new ImageIcon("src/images/Botones/m2.png"), btn3 = new ImageIcon("src/images/Botones/m3.png");
    this.playButton.setBounds(1150, 5, 67, 62);
    this.playButton.addActionListener(this);
    ConfigurarBoton(this.playButton, btn1, btn2, btn3);
    add(this.playButton);
  }
  
  public void ConfigurarBoton(JButton boton, ImageIcon img1, ImageIcon img2, ImageIcon img3) {
    boton.setIcon(img1);
    setLayout((LayoutManager)null);
    boton.setBorderPainted(false);
    boton.setContentAreaFilled(false);
    boton.setFocusable(false);
    boton.setRolloverEnabled(true);
    boton.setRolloverIcon(img2);
    boton.setPressedIcon(img3);
  }
  
  public void animar(Interface_MyMethods c) {
    this.fnd = (MoverObjects[])c.getSetFondoAnimation(12, this.nivel);
    this.coins = c.getCoinsGemas(this.nivel);
  }
  
  public void keyPressed(KeyEvent ev) {
    this.p1.keyPressed(ev);
  }
  
  public void keyReleased(KeyEvent ev) {
    this.p1.keyReleased(ev);
  }
  
  public void keyTyped(KeyEvent ev) {}
  
  public void paint(Graphics g) {
    int x;
    for (x = this.fnd.length - 1; x >= 0; x--)
      this.fnd[x].dibujar(g); 
    this.door.dibujar(g);
    for (x = 0; x < this.est.length; x++)
      this.est[x].dibujar(g); 
    setOpaque(false);
    super.paint(g);
    Graphics2D g2 = (Graphics2D)g;
    this.p1.dibujar(g);
    int i;
    for (i = 0; i < this.monster_wolf.length; i++)
      this.monster_wolf[i].dibujar(g); 
    for (i = 0; i < this.coins.length; i++)
      this.coins[i].dibujar(g); 
    g2.setColor(Color.white);
    g2.setFont(this.font);
    g2.drawString(this.msg_nivel, 61, 47);
    g2.drawString(this.msg_vidas, 251, 47);
    g2.drawString(this.msg_coins, 448, 47);
    g2.drawString(this.msg_gemas, 648, 47);
    Toolkit.getDefaultToolkit().sync();
    g.dispose();
  }
  
  public void actionPerformed(ActionEvent e) {
    this.p1.mover(this.fnd[this.fnd.length - 1].getX());
    this.door.mover(this.p1.getMove(), this.p1.getDirection());
    int x;
    for (x = 0; x < this.monster_wolf.length; x++) {
      this.monster_wolf[x].mover(this.p1.getMove(), this.p1.getDirection());
      this.monster_wolf[x].perseguir();
      if (this.monster_wolf[x].detectar(this.p1.getX(), this.p1.getY(), this.p1.getWidth(), this.p1.getHeight()) && this.cancel) {
        new Principal(this.marco, this.rest_vidas - 1, this.nivel);
        this.cancel = false;
      } 
    } 
    if (this.door.detectar(this.p1.getX(), this.p1.getY(), this.p1.getWidth(), this.p1.getHeight()) && this.cancel) {
      int[] send = { ++this.nivel, this.cont_coins, 50, this.cont_gemas, 5 };
      this.cancel = false;
      new Principal(this.marco, send);
    } 
    this.comprobar = 0;
    for (x = 0; x < this.coins.length; x++) {
      this.coins[x].mover(this.p1.getMove(), this.p1.getDirection());
      if (this.coins[x].detectar(this.p1.getX(), this.p1.getY(), this.p1.getWidth(), this.p1.getHeight())) {
        this.coinsVerif = true;
        this.comprobar = x;
        if (!this.coins[x].isObtenida()) {
          if (this.coins[x].isTipo() == 1) {
            this.cont_coins++;
          } else {
            this.cont_gemas++;
          } 
          this.coins[x].setObtenida(true);
        } 
      } 
      this.coins[x].coinObtenida();
    } 
    for (x = 0; x < this.fnd.length; x++)
      this.fnd[x].mover(this.p1.getMove(), this.p1.getDirection()); 
    if (e.getSource() == this.playButton)
      try {
        Thread.sleep(3000L);
        new Principal(this.marco);
      } catch (Exception excep) {
        System.exit(0);
      }  
    this.msg_coins = "" + this.cont_coins;
    this.msg_gemas = "" + this.cont_gemas;
    this.msg_vidas = "" + this.rest_vidas;
    this.msg_nivel = "" + this.nivel;
    repaint();
  }
  
  public void gameOver(int status) {}
}
