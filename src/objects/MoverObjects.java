
package objects;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import main.ObjetoResours;
public abstract class MoverObjects extends ObjetoResours {
    private int gravity;
    public MoverObjects(int x, int y, String ico){
        super(x,y,ico);
        this.gravity = 2;
    }
    public void setImage(String ico){        
        this.icono = new ImageIcon("src/images/"+ico);
        this.img = this.icono.getImage();  
    }
    public void mover(boolean move, int direction){
            /*if(direction == 1 && move)
                this.x-=this.gravity ;
            if(direction == 0 && move)
                this.x+=this.gravity ;    
                */
            if(move)
                if(direction == 1)
                    this.x-=this.gravity;
                else
                    this.x+=this.gravity;
            
    }
    public abstract boolean detectar(int x, int y , int w, int h);    
}

