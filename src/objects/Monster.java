/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
public class Monster extends MoverObjects{
    private int s_x, s_y, r_ancho, r_alto;
    public Monster(int x, int y, int tipo) {
    super(x, y, "src/images/m" + tipo + ".gif");
    if (tipo == 1) {
      setImage("m1.gif");
      this.r_ancho = 130;
      this.s_y = 90;
    } else if (tipo == 2) {
      setImage("m2.gif");
      this.r_ancho = 130;
      this.s_y = 90;
    } 
  } 
    /* public void dibujar(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(this.img,this.x,this.y,null); 
        g.setColor (Color.green);    
        g.drawRect (this.x+ s_x ,this.y + s_y,this.ancho - r_ancho ,this.alto - r_alto);
    }*/
    public void perseguir(){
        this.x+=2;
    }
    @Override
    public boolean detectar(int x, int y , int w, int h){
        this.rect = new Rectangle(this.x+ s_x ,this.y + s_y,this.ancho - r_ancho ,this.alto - r_alto);
        return this.rect.intersects(x,y,w,h);
    }
}
