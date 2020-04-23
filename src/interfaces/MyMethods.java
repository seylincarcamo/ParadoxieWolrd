/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.Random;
import objects.*;

public class MyMethods implements Interface_MyMethods{
    //Atributos    
    private FondoAnimation fondoanimation[];
    private Pisos pisos[];
    private CoinGema coinsgema[], gemas[];
    private Sierra sierras[];
    private Suelo suelo[];
    private int temp_x, temp_y;
    //Contructir
    public MyMethods(){
    }

    public FondoAnimation[] getSetFondoAnimation(int dig, int tipo){
        fondoanimation = new FondoAnimation[dig];
        if(tipo == 2){temp_x = 420;        }else{temp_x =0;}
        fondoanimation[0] = new FondoAnimation(0,0, tipo);
        for(int x = 1; x < fondoanimation.length; x++)
            fondoanimation[x] = new FondoAnimation(fondoanimation[x-1].getX()+ fondoanimation[x-1].getWidth()-temp_x,fondoanimation[x-1].getY(), tipo);     
        return fondoanimation;
    }
    public Suelo[] getSetSuelo(int dig, int tipo){
        suelo = new Suelo[dig]; 
        if(tipo == 2){temp_y = 650;        }else{temp_y =0;}
        suelo[0] = new Suelo(0,temp_y, tipo);
        for(int x = 1; x < suelo.length; x++)
            suelo[x] = new Suelo(suelo[x-1].getX()+ suelo[x-1].getWidth(),suelo[x-1].getY(), tipo);     
        return suelo;
    }
    public Pisos[] getPisos(int nivel){
        if(nivel == 1){
            pisos = new Pisos[6];//6
            pisos[0] = new Pisos(985,500,1);//985
            pisos[1] = new Pisos(pisos[0].getX() + pisos[0].getWidth()+180,320,2);
            pisos[2] = new Pisos(pisos[1].getX() + pisos[1].getWidth()+50+450+300,550,1);
            pisos[3] = new Pisos(pisos[2].getX() + pisos[2].getWidth()+70 ,320,2);
            pisos[4] = new Pisos(pisos[3].getX() + pisos[3].getWidth() + 350+40,550,2);
            pisos[5] = new Pisos(pisos[4].getX() + pisos[4].getWidth()+150,300,2);
       }
       else if(nivel == 2){
            pisos = new Pisos[17];
            pisos[0] = new Pisos(10,346,3);
            pisos[1] = new Pisos(400,515,4);            
            pisos[2] = new Pisos(660,405,4);            
            pisos[3] = new Pisos(928,321,5);            
            pisos[4] = new Pisos(1382,431,4);            
            pisos[5] = new Pisos(1651,400,4);            
            pisos[6] = new Pisos(2025,336,3);            
            pisos[7] = new Pisos(2557,528,5);            
            pisos[8] = new Pisos(3009,400,4);            
            pisos[9] = new Pisos(3471,291,4);            
            pisos[10] = new Pisos(3894,502,4);            
            pisos[11] = new Pisos(4236,425,4);            
            pisos[12] = new Pisos(4781,339,5);            
            pisos[13] = new Pisos(5536,540,5);            
            pisos[14] = new Pisos(6009,261,5);            
            pisos[15] = new Pisos(6593,476,4);            
            pisos[16] = new Pisos(7310,520,4);
       }
       return pisos;
    }
    public CoinGema[] getCoinsGemas(int nivel) {
    this.coinsgema = new CoinGema[55];
    int temporal = 100, cont = 0, distancia = 0;
    if (nivel == 1) {
      this.coinsgema[0] = new CoinGema(350, 620, 1);
      int x;
      for (x = 1; x < 8; x++)
        this.coinsgema[x] = new CoinGema(this.coinsgema[x - 1].getX() + this.coinsgema[x - 1].getWidth() + 5, this.coinsgema[x - 1].getY(), 1); 
      this.coinsgema[8] = new CoinGema(this.coinsgema[7].getX() + this.coinsgema[7].getWidth() - 15, this.coinsgema[7].getY() - this.coinsgema[7].getHeight(), 1);
      for (x = 9; x < 11; x++)
        this.coinsgema[x] = new CoinGema(this.coinsgema[x - 1].getX() + this.coinsgema[x - 1].getWidth() + 5, this.coinsgema[x - 1].getY() - this.coinsgema[x - 1].getHeight(), 1); 
      for (x = 11; x < 15; x++)
        this.coinsgema[x] = new CoinGema(this.coinsgema[x - 1].getX() + this.coinsgema[x - 1].getWidth() + 5, this.coinsgema[x - 1].getY(), 1); 
      for (x = 15; x < 17; x++)
        this.coinsgema[x] = new CoinGema(this.coinsgema[x - 1].getX() + this.coinsgema[x - 1].getWidth() + 5, this.coinsgema[x - 1].getY() - this.coinsgema[x - 1].getHeight(), 1); 
      this.coinsgema[17] = new CoinGema(this.coinsgema[16].getX() + this.coinsgema[16].getWidth() + 100, this.coinsgema[16].getY() - 65, 0);
      for (x = 18; x < 24; x++)
        this.coinsgema[x] = new CoinGema(this.coinsgema[x - 1].getX() + this.coinsgema[x - 1].getWidth() + 5, this.coinsgema[x - 1].getY() + this.coinsgema[x - 1].getHeight(), 1); 
      for (x = 24; x < 31; x++)
        this.coinsgema[x] = new CoinGema(this.coinsgema[x - 1].getX() + this.coinsgema[x - 1].getWidth() + 5, this.coinsgema[x - 1].getY(), 1); 
      for (x = 31; x < 33; x++)
        this.coinsgema[x] = new CoinGema(this.coinsgema[x - 1].getX() + this.coinsgema[x - 1].getWidth() + 5, this.coinsgema[x - 1].getY() - this.coinsgema[x - 1].getHeight(), 1); 
      for (x = 33; x < 34; x++)
        this.coinsgema[x] = new CoinGema(this.coinsgema[x - 1].getX() + this.coinsgema[x - 1].getWidth() + 5, this.coinsgema[x - 1].getY(), 1); 
      for (x = 34; x < 38; x++)
        this.coinsgema[x] = new CoinGema(this.coinsgema[x - 1].getX() + this.coinsgema[x - 1].getWidth() + 5, this.coinsgema[x - 1].getY() - this.coinsgema[x - 1].getHeight(), 1); 
      this.coinsgema[38] = new CoinGema(this.coinsgema[37].getX() + this.coinsgema[37].getWidth() + 50, this.coinsgema[37].getY() - 65, 0);
      for (x = 39; x < 42; x++)
        this.coinsgema[x] = new CoinGema(this.coinsgema[x - 1].getX() + this.coinsgema[x - 1].getWidth() + 5, this.coinsgema[x - 1].getY() + this.coinsgema[x - 1].getHeight(), 1); 
      this.coinsgema[42] = new CoinGema(this.coinsgema[41].getX() + this.coinsgema[41].getWidth() + 200, this.coinsgema[41].getY() + 100, 0);
      for (x = 43; x < 46; x++)
        this.coinsgema[x] = new CoinGema(this.coinsgema[x - 1].getX() + this.coinsgema[x - 1].getWidth() + 5, this.coinsgema[x - 1].getY() - this.coinsgema[x - 1].getHeight(), 1); 
      this.coinsgema[46] = new CoinGema(this.coinsgema[45].getX() + this.coinsgema[45].getWidth() + 200, this.coinsgema[45].getY() + 100, 0);
      this.coinsgema[47] = new CoinGema(this.coinsgema[46].getX() + this.coinsgema[46].getWidth() + 350, 620, 0);
      for (x = 48; x < 55; x++)
        this.coinsgema[x] = new CoinGema(this.coinsgema[x - 1].getX() + this.coinsgema[x - 1].getWidth() + 5, this.coinsgema[x - 1].getY(), 1); 
    } else if (nivel == 2) {
      this.coinsgema[0] = new CoinGema(300, 266, 1);
      cont = 1;
      for (int x = 1; x < 50; x++) {
        if (cont >= 3) {
          cont = 0;
          distancia = 266;
        } else {
          distancia = 5;
        } 
        this.coinsgema[x] = new CoinGema(this.coinsgema[x - 1].getX() + this.coinsgema[x - 1].getWidth() + distancia, this.coinsgema[x - 1].getY(), 1);
        cont++;
      } 
      this.coinsgema[50] = new CoinGema(1533, 220, 0);
      this.coinsgema[51] = new CoinGema(2152, 220, 0);
      this.coinsgema[52] = new CoinGema(3496, 220, 0);
      this.coinsgema[53] = new CoinGema(4876, 220, 0);
      this.coinsgema[54] = new CoinGema(6620, 392, 0);
    } else if (nivel == 3) {
      this.coinsgema = new CoinGema[55];
      this.coinsgema[0] = new CoinGema(350, 620, 1);
      cont = 1;
      for (int x = 1; x < 50; x++)
        this.coinsgema[x] = new CoinGema(this.coinsgema[x - 1].getX() + this.coinsgema[x - 1].getWidth() + 35, this.coinsgema[x - 1].getY(), 1); 
      this.coinsgema[50] = new CoinGema(1533, 510, 0);
      this.coinsgema[51] = new CoinGema(2152, 550, 0);
      this.coinsgema[52] = new CoinGema(3496, 450, 0);
      this.coinsgema[53] = new CoinGema(4876, 500, 0);
      this.coinsgema[54] = new CoinGema(6620, 480, 0);
    } 
    return this.coinsgema;
  }
    public Sierra[] getSierras(){
        sierras =  new Sierra[15];
        sierras[0] = new Sierra(450,300,0);        
            sierras[1] = new Sierra(sierras[0].getX()+sierras[0].getWidth()+150,650,1);
            sierras[2] = new Sierra(sierras[1].getX()+sierras[1].getWidth(),650,1);
            sierras[3] = new Sierra(sierras[2].getX()+sierras[2].getWidth(),650,1);        
                sierras[4] = new Sierra(sierras[3].getX()+sierras[3].getWidth()+70,380,0);        
                    sierras[5] = new Sierra(sierras[4].getX()+sierras[4].getWidth()+200,460,1);
                    sierras[6] = new Sierra(sierras[5].getX()+sierras[5].getWidth(),460,1);
                    sierras[7] = new Sierra(sierras[6].getX()+sierras[6].getWidth(),460,1);        
                sierras[8] = new Sierra(sierras[7].getX()+sierras[7].getWidth()+160+310,380,1);
                sierras[9] = new Sierra(sierras[8].getX(),533,1);//
                sierras[10] = new Sierra(sierras[9].getX()+sierras[9].getWidth()+110,457,1);
                sierras[11] = new Sierra(sierras[10].getX()+sierras[10].getWidth(),533,1);        
        sierras[12] = new Sierra(sierras[11].getX()+sierras[11].getWidth()+220,350,1);
        sierras[13] = new Sierra(sierras[12].getX()+sierras[12].getWidth()+75,550,1);
        sierras[14] = new Sierra(sierras[13].getX()+sierras[13].getWidth(),350,1);
        return sierras;
    }
}