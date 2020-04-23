/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import java.awt.*;
import javax.swing.*; 
import java.awt.geom.Ellipse2D;
public class CoinGema extends MoverObjects {
    private Ellipse2D circulo;
    private boolean move,obtenida;
    private int ascenso;
    
    public CoinGema(int x, int y, int tipo){
        super(x,y,"src/images/coin.gif");
        this.move = false;
        this.obtenida = false;
        this.tipo = tipo;
        this.ascenso =0;
        if(tipo == 1){
            setImage("coin.gif");
        }else{
            setImage("gema.gif");
        }
    }  
    public void dibujar(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(this.img,this.x,this.y,null); 
        g2.setColor (Color.yellow);
       // g2.draw(new Ellipse2D.Double(this.x, this.y, this.ancho,this.alto));*/
    }
    public int isTipo(){
        return this.tipo;
    }
    @Override
    public boolean detectar(int x, int y , int w, int h){
        this.circulo =  new Ellipse2D.Double(this.x, this.y, this.ancho,this.alto); 
        return this.circulo.intersects((double)x, (double)y, (double)w,(double)h);
    }    
    public void setObtenida(boolean b){
        this.obtenida = b;
    }
    public boolean isObtenida(){
        return this.obtenida;
    }    
    public void coinObtenida(){
        if(isObtenida()){
            if(this.tipo == 1)
                this.ascenso = 400;
            else
                this.ascenso = 600;
            if(this.y > -100){
                this.y-=5;
            } 
            if(this.x >  this.ascenso){
                this.x-=10;
            }   
            else
                this.x+=2;
        }
    }
}