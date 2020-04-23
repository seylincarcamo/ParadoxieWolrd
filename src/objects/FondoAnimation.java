/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import java.awt.*;
public class FondoAnimation extends MoverObjects{
    public FondoAnimation(int x, int y, int tipo){
        super(x,y,"src/images/fond"+tipo+".png");
    }
    @Override
    public boolean detectar(int x, int y , int w, int h){
        /*this.rect = new Rectangle(this.x,this.y,this.ancho ,this.alto);  
        return this.rect.intersects(x,y,w,h);*/
        return false;
    }
    /*public void mover(boolean move, int direction){
            if(direction == 1 && move)
                this.x-=4;
            if(direction == 0 && move)
                this.x+=4;        
    }*/
    
}