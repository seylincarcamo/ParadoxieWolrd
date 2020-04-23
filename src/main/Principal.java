/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import gui.Completado;
import gui.GameOver;
import gui.YouWin;
import javax.swing.JFrame;
import java.util.Calendar;
import levels.Escenario;
import levels.Escenario2;
import levels.Escenario3;
public class Principal extends JFrame{    
    public static void main(String args []){
        new Principal();
    }

    public Principal(){//menu inicial
       add(new Menu(this));  
       // add(new Escenario(this,2));
        iniComponents("Run");
    }

    public Principal(JFrame marco){//retro a limentacion de menu
        marco.dispose();
        add(new Menu(this));  
        iniComponents("MENU");
    }

    public Principal(JFrame marco, int[] send){///cuando gana
        marco.dispose();
        add(new YouWin(this,send));    
        iniComponents("Ganaste");
    }

    public Principal(JFrame marco, int v, int nivel){
        marco.dispose();   
         
        if(v<=0)
            add(new GameOver(this));        
        else{           
            if(nivel == 1)
                add(new Escenario(this, v, nivel));            
            else if(nivel == 2)
                add(new Escenario2(this, v, nivel));            
           else if(nivel == 3)
                add(new Escenario3(this, v, nivel));
            else
                add(new Completado(this));          
        }        
        iniComponents("Nivel " + nivel );
    } 
    public void iniComponents(String title){ 
        setTitle(title );
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1250,740);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }
}
