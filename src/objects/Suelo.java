/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import java.awt.*;
public class Suelo extends MoverObjects{
    public Suelo(int x, int y, int tipo){
        super(x,y,"src/images/suelo"+tipo+".gif");
    }
    @Override
    public boolean detectar(int x, int y , int w, int h){
        this.rect = new Rectangle(this.x,this.y,this.ancho ,this.alto);  
        return this.rect.intersects(x,y,w,h);
    }
    
}
