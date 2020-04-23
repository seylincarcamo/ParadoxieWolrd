/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import java.awt.*;
import javax.swing.*; 
import java.awt.geom.Ellipse2D;
public class Sierra extends MoverObjects {   
    private Ellipse2D circulo;    
    public Sierra(int x, int y, int tipo){
        super(x,y,"src/images/rueda"+tipo+".gif");
    }
   /*public void dibujar(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(this.img,this.x,this.y,null); 
        g2.setColor (Color.red);
        g2.draw(new Ellipse2D.Double(this.x, this.y, this.ancho,this.alto));     
    }*/   
    /*public Ellipse2D getCirculo()  {
        return this.circulo =  new Ellipse2D.Double(this.x,this.y,this.ancho,this.alto);  
    }*/
    @Override
    public boolean detectar(int x, int y , int w, int h){
        this.circulo =  new Ellipse2D.Double(this.x, this.y, this.ancho,this.alto); 
        return this.circulo.intersects((double)x, (double)y, (double)w,(double)h);
    }
}
