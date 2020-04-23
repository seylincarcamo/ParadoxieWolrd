
package levels;
import gui.Estado;
import gui.Personaje;
import main.Principal;
import interfaces.Interface_MyMethods;
import interfaces.MyMethods;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import javax.sound.sampled.*;
import java.io.File;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import objects.*;

public class Escenario extends JPanel implements ActionListener, KeyListener {
    // Atributos
    private ImageIcon icono;
    private Image fondo;
    private Timer t;
    private MyMethods mis_metodos;
    private Personaje p1;
    private MoverObjects fnd[], pisos[], sierras[], door;    
    private CoinGema coins[];
    private String msg_coins, msg_gemas, msg_vidas, msg_nivel;
    private Font font;
    private boolean gameEnded,coinsVerif, cancel;;
    private Estado est[];
    private JFrame marco;
    private int comprobar,nivel,cont_coins, cont_gemas, cont_vidas, rest_vidas;
    private JButton playButton = new JButton();
    
    private Clip song;
    // Constructores
    // public Escenario(){
    public void play(){
        /*try {
          AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new java.io.File("caminando.wav").getAbsoluteFile());
          song = AudioSystem.getClip();
          song.open(audioInputStream);
          song.loop(song.LOOP_CONTINUOUSLY);
          song.start();          
        }
        catch (Exception e) {
            System.out.println(e);//" problema con el audio"
        }*/
       /* try {
            
            Clip sonido = AudioSystem.getClip();
            sonido.open(AudioSystem.getAudioInputStream(new File("caminando.wav")));
            sonido.start();
            while (sonido.isRunning())
                Thread.sleep(1000);
            
            // Se cierra el clip.
            sonido.close();
        } catch (Exception e) {
            System.out.println("" + e);
        }*/
    }
    void stop(){
        song.stop();
    }
    public Escenario(JFrame marco, int v, int nivel){
        setDoubleBuffered(true); 
        this.marco = marco; rest_vidas = v;  
        this.nivel = nivel;
        initVariables();       
        iniButtons();
         play();
        t = new Timer(5, null); t.addActionListener(this);  t.start();
        addKeyListener(this);   setFocusable(true); 
        setMessages();
    }
    public void initVariables(){
        p1 = new Personaje();        est = new Estado[4];   mis_metodos = new MyMethods(); animar(mis_metodos); door = new Door(fnd[fnd.length-1].getX()-2800,250,nivel);  
        for(int x = 0; x<est.length;x++) est[x] = new Estado(x);
        cont_coins =0;     cont_gemas = 0;    gameEnded = false;  coinsVerif = false;     cancel = true;
    }
    public void setMessages(){
        font = new Font("Intensa Fuente", Font.PLAIN,20); msg_coins = ""+cont_coins;  msg_gemas = ""+cont_gemas;  msg_vidas = ""+rest_vidas; msg_nivel = ""+nivel;
    }
    public void iniButtons(){
        ImageIcon btn1 = new ImageIcon("src/images/Botones/m1.png"),btn2 = new ImageIcon("src/images/Botones/m2.png"), btn3 = new ImageIcon("src/images/Botones/m3.png");
        playButton.setBounds(1150,5,67,62);     playButton.addActionListener(this);     ConfigurarBoton(playButton,btn1,btn2,btn3);     add(playButton);
    }
    public void ConfigurarBoton(JButton boton,ImageIcon img1,ImageIcon img2,ImageIcon img3){
        boton.setIcon(img1);  setLayout(null);  boton.setBorderPainted(false);  boton.setContentAreaFilled(false);  boton.setFocusable(false);  boton.setRolloverEnabled(true);
        boton.setRolloverIcon(img2);  boton.setPressedIcon(img3);
    }
    public void animar(Interface_MyMethods c){
        fnd = c.getSetFondoAnimation(5,nivel);        pisos = c.getPisos(nivel);        sierras = c.getSierras();        coins = c.getCoinsGemas(nivel);
    }
    public void keyPressed(KeyEvent ev){    p1.keyPressed(ev);  }
    public void keyReleased(KeyEvent ev){   p1.keyReleased(ev); }
    public void keyTyped(KeyEvent ev){}//abtract
    // Metodos
public void paint(Graphics g)    {
    for(int x = 0; x < fnd.length; x++) fnd[x].dibujar(g);
    door.dibujar(g);        
    for(int x = 0; x<est.length;x++)    est[x].dibujar(g);
    setOpaque(false);        super.paint(g);        Graphics2D g2 = (Graphics2D)g; 
    for(int x = 0; x<pisos.length;x++)      pisos[x].dibujar(g);         
    for(int x = 0; x<sierras.length;x++)    sierras[x].dibujar(g);
    for(int x = 0; x<coins.length;x++)      coins[x].dibujar(g);        
    p1.dibujar(g);
    g2.setColor(Color.white);   g2.setFont(font); 
    g2.drawString(msg_nivel, 61, 47); g2.drawString(msg_vidas, 251, 47);
    g2.drawString(msg_coins, 448, 47);  g2.drawString(msg_gemas, 648, 47);
    
    Toolkit.getDefaultToolkit().sync();
    g.dispose();        //repaint();      
} 
    public void actionPerformed(ActionEvent e){
        p1.mover(fnd[fnd.length-1].getX());//enviar la distancia final
        door.mover(p1.getMove(),p1.getDirection()); 
        if(door.detectar(p1.getX(), p1.getY(), p1.getWidth(), p1.getHeight())&& cancel){
            int send[] = {++nivel,  cont_coins, 50,cont_gemas,5 };
            cancel = false; new Principal(this.marco,send);
        }
        comprobar = 0;
        for(int x = 0; x<pisos.length;x++){     pisos[x].mover(p1.getMove(),p1.getDirection());
            if(p1.detectarPiso(pisos[x].getRectangle())){   p1.setSuelo(pisos[x].getY()-p1.getHeight());    comprobar = x;  }
            else{   if(p1.detectarPiso(pisos[comprobar].getRectangle())== false)    p1.resetSuelo();    }      
        }
        for(int x = 0; x<sierras.length;x++){   sierras[x].mover(p1.getMove(),p1.getDirection());
            if(sierras[x].detectar(p1.getX(), p1.getY(), p1.getWidth(), p1.getHeight())&& cancel)
            {new Principal(this.marco, this.rest_vidas-1, this.nivel);  cancel = false;  /**stop();*/  }          
        }
        for(int x = 0; x<coins.length;x++){     coins[x].mover(p1.getMove(),p1.getDirection());
            if(coins[x].detectar(p1.getX(), p1.getY(), p1.getWidth(), p1.getHeight())){
                coinsVerif = true;  comprobar = x;
                if(coins[x].isObtenida() == false){if(coins[x].isTipo()==1){    cont_coins++;} else{    cont_gemas++;  }   coins[x].setObtenida(true);  }                
            }
            coins[x].coinObtenida();
        }
        for(int x = 0; x<fnd.length; x++)
            fnd[x].mover(p1.getMove(),p1.getDirection());
        if (e.getSource()==playButton) 
            try{    Thread.sleep(3000); new Principal(this.marco);  }catch(Exception excep){System.exit(0);}
        msg_coins = ""+cont_coins;        msg_gemas = ""+cont_gemas;        msg_vidas = ""+this.rest_vidas;  msg_nivel = ""+nivel;
        repaint();
    }
    /*private class Listener extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e){
            p1.keyPressed(e);            
            if(e.getKeyCode() == KeyEvent.VK_ENTER){
                if(gameEnded){
                    p1.restaurar();
                    gameEnded = false;
                    t.start();
                }
            }
        }
        @Override
        public void keyReleased(KeyEvent e){
            p1.keyReleased(e);
        }
    }*/
    public void gameOver(int status){
        /*gameEnded = true;
        if(status == 0)
           // msg = "You lose!";
        else
            //msg = "You won!";
       // msg += " - Press [ENTER] to play again.";
        t.stop();*/
    }
}
