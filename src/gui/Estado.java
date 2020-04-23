/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import main.ObjetoResours;
public class Estado extends ObjetoResours {//estado de las gemas y las monedas adem,asd del meni
   // public Estado(String text){
    public Estado(int text){
        super(0,0,"");
       if(text == 0){
            setImage("conta_nivel");
            this.x = 10; 
        }
        else if(text == 1){            
            setImage("conta_vidas");
            this.x = 200; 
        }
        else if(text == 2){            
            setImage("conta_c");
            this.x = 400; 
       }else if(text == 3){
            setImage("conta_g");
            this.x = 600;            
        }
       this.y = 0;
    }
    public void setImage(String ico){  
        this.icono = new ImageIcon("src/images/"+ico+".png");
        this.img = this.icono.getImage();  
    }
}
