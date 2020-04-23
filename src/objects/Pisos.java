/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import java.awt.*;
import java.util.Random;
public class Pisos extends MoverObjects {
    private int r_alto, s_y, s_x,r_ancho;
    public Pisos(int x, int y, int tipo){
        super(x,y,"src/images/piso"+tipo+".png");  
        s_y = 0; r_ancho = 0; s_x = 0;
        if(tipo == 1){
            setImage("piso1.png");
            r_alto = 33;
        }else if (tipo == 2){
            setImage("piso2.png");
            r_alto = 29;
        }
        else if (tipo == 3){
            setImage("piso3.png");
            r_alto = 80; s_y = 25; r_ancho = 24; s_x = 10;
        }
        else if (tipo == 4){
            setImage("piso4.png");
            r_alto = 132; s_y = 15;
        }
        else if (tipo == 5){
            setImage("piso5.png");
            r_alto = 60; s_y = 15;
        }
    }

    /*public void dibujar(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(this.img,this.x,this.y,null); 
        /*g.setColor (Color.white);    
        g.drawLine (0, 450, 1500, 450);
        g.drawRect (this.x + s_x,this.y +  s_y,this.ancho - r_ancho ,this.alto - r_alto);//cuerpo
        g.setColor (Color.green);
        g.drawLine (0, 550, 1500, 550);*/
    //}

    public Rectangle getRectangle()  {    
        //System.out.println((this.x )+" / " +( this.y)+" / " +( this.ancho)+" / " +(this.alto-r_alto));
        return this.rect = new Rectangle(this.x  + s_x, this.y +  s_y,this.ancho - r_ancho  ,this.alto - r_alto);  
    }

    @Override
    public boolean detectar(int x, int y , int w, int h){
        this.rect = new Rectangle(this.x,this.y,this.ancho ,this.alto - r_alto);  
        return this.rect.intersects(x,y,w,h);
    }
} 
