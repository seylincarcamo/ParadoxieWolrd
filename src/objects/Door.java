/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import java.awt.*;
import javax.swing.*; 
import java.awt.geom.Ellipse2D;
public class Door extends MoverObjects {   
    public Door(int x, int y, int tipo){
       super(x,y,"src/images/d"+tipo+".png");   
        //System.out.println(x);
        if(tipo == 1){
            setImage("d1.png");
        }else if (tipo == 2){
            setImage("d2.png");
        }
    }
    public Rectangle getRectangle()  {    
        return this.rect = new Rectangle(this.x,this.y,this.ancho ,this.alto);  
    }

    @Override
    public boolean detectar(int x, int y , int w, int h){
        this.rect = new Rectangle(this.x,this.y,this.ancho ,this.alto);  
        return this.rect.intersects(x,y,w,h);
    }
   
}