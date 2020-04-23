
package main;

import java.awt.*;
import javax.swing.*;
import java.util.Random;   
public class ObjetoResours
{
    //Atributos globales
    protected int x;
    protected int y;
    protected Image img;
    protected ImageIcon icono;
    protected int alto;
    protected int ancho;
    protected int tipo; 
    protected boolean visible;
    protected Rectangle rect;
    protected Random r;
    protected int salto;
    //Contructor
    public ObjetoResours(int x, int y, String icon){
        this.x=x;
        this.y=y;
        this.icono = new ImageIcon(icon);
        this.img = this.icono.getImage();  
        this.ancho = this.icono.getIconWidth();
        this.alto = this.icono.getIconHeight(); 
        this.visible = true;
        salto = 90;
    }
    //Metodos
    public void dibujar(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        if(this.visible)
            g2.drawImage(this.img,this.x,this.y,null);
    }
    
    public boolean isVisible(){
        return this.visible;
    }
    
    public void setVisible(boolean visible){
        this.visible = visible;
    }
    
    public Rectangle getRectangle(){
        return this.rect = new Rectangle(this.x,this.y,this.ancho,this.alto);
    }

    public int getHeight(){
        return this.alto; 
    }

    public int getWidth(){
        return this.ancho; 
    }

    public int getX(){
        return this.x; 
    }

    public int getY(){
        return this.y; 
    }   
    
}

