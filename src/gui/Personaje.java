
package gui;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import main.ObjetoResours;
public class Personaje extends ObjetoResours {
    //Atributos
    private int cont;
    private boolean status, salto, caida, gateo, move;
    private int dy, dx;
    private int gravity, gravity2;
    private int direction, distancia;
    private int cnt_cl,cnt_cr ,cnt_saltos, cont_x ,cont_y, temp_y, MARGIN_BTM_Y;
    private int s_x, s_y, r_ancho, r_alto;
    private int vidas;
    //Contructor
    public Personaje(){
        super(0,300,"src/images/static1.png");//"images/static1.png");
       // setImage("static1.png");
        this.vidas = 3;
        this.direction = 1;//1 es derecha 0 es izquierda
        this.distancia = 0;
        this.cont_x = 150;
        this.cont_y = 880;
        this.dy = 0;   
        this.dx = 0;
        this.cont= 0;
        this.cnt_cl = 0; this.cnt_cr = 0;
        this.cnt_saltos = 0;
        this.gravity = 2;
        this.gravity2 = 1;
        this.visible = true;
        this.status = true;
        this. salto = false;
        this. caida = false;
        this.move = false;
        this.gateo = false;
        this.MARGIN_BTM_Y = 550;
        this.temp_y = 550;
        setRectangleNormal();
    }
    //Metodos
     /*public void restaurar(){
        this.x = 0; 
        this.direction = 1;
        this.distancia = 0;
        this.cont_x = 150;
        this.cont_y = 880;
        this.dy = 0;   
        this.dx = 0;
        this.cont= 0;
        this.cnt_saltos = 0;
        this.MARGIN_BTM_Y = 550;
        this.salto = false;
        this.caida = false;
        this.move = false;
        this.gateo = false;
        this.y = 550;
        resetSuelo();
        setImage("static1.png");
        setRectangleNormal();   
    }*/
    /*public void dibujar(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(this.img,this.x,this.y,null);         
        g.setColor (Color.blue);
        g.drawRect (this.x+ s_x ,this.y + s_y,this.ancho - r_ancho ,this.alto - r_alto);//cuerpo
        g.setColor (Color.yellow);
        g.drawRect (this.x+35,this.y+147,this.ancho-85,this.alto-147);//detector de pisos
    }*/
    /*public boolean detectar(Rectangle r){//Aqui se detectaran las monedasa u objetos
    this.rect = new Rectangle (this.x,this.y,this.ancho-20,this.alto);
    return this.rect.intersects(r);
    }*/
    public boolean detectarPiso(Rectangle r){
        this.rect = new Rectangle (this.x+35,this.y+147,this.ancho-85,this.alto-147);
        return this.rect.intersects(r);
    }
    public void setRectangleNormal(){        s_x = 25;   s_y = 0;  r_ancho = 52;   r_alto = 0;    }
    public void setRectangleGateo(){        s_x = 0;   s_y = 0;  r_ancho = -40;   r_alto = 75;    }    
    public int getWidth(){        return this.ancho-r_ancho;    }
    public int getX(){        return this.x+s_x;    }    
    public void setVidas(int v){             this.vidas = v;              }
    public void restarVidas(int v){          this.vidas = this.vidas-v;   }
    public int getVidas(){                   return this.vidas;           }   
    public void setSuelo(int _ny){           this.MARGIN_BTM_Y = _ny;     }
    public void resetSuelo(){                this.MARGIN_BTM_Y = 550;     }    
    public boolean getMove(){                return this.move;            }
    public void setMove(boolean m){          this.move = m;               }
    public int getDirection(){               return this.direction;       }
    public int getDistance(){                return this.distancia;       }
    public void setSalto(boolean s){         this.salto = s;              }
    public void keyPressed(KeyEvent ev){    
        int tecla = ev.getKeyCode();
        if(tecla == KeyEvent.VK_LEFT){
            this.dx = -this.gravity2;
            this.direction = 0;         
        }
        if(tecla == KeyEvent.VK_RIGHT){
            this.dx = this.gravity2 ;
            this.direction = 1;
        }
        if(tecla == KeyEvent.VK_UP){
            if(this.cnt_saltos < 2){
                this.salto = true;
                this.cnt_saltos++;
            }
        }
        if(tecla == KeyEvent.VK_DOWN){
            if(this.salto == false && this.cnt_saltos ==0){
                this.dy = this.gravity2;
                this.gateo = true;
                this.y = 635;
                setRectangleGateo();
            }            
        }
    }
    public void keyReleased(KeyEvent ev){    
        int tecla= ev.getKeyCode();
        if(tecla == KeyEvent.VK_LEFT){
            this.dx = 0;
        }
        if(tecla == KeyEvent.VK_RIGHT){
            this.dx =  0;
        }
        if(tecla == KeyEvent.VK_UP && this.dy < 0){
            //  this.dy = 0;
        }
        if(tecla == KeyEvent.VK_DOWN && this.dy > 0){
            this.dy = 0;
            this.gateo = false;
            this.y = 550;
            setRectangleNormal();
        }
    }
    public void setImage(String ico){        
        this.icono = new ImageIcon("src/images/"+ico);
        this.img = this.icono.getImage();  
    }
    public void mover(int _x){
        /**Cambios de imagen**/
        if(this.gateo == false){
            if(this.cnt_saltos == 2)
                setImage("giro"+this.direction+".gif");        
            if(this.cont < 200 && this.salto == true ){           
                this.y-=this.gravity;
                this.cont+=this.gravity; 
            }
            else{
                setSalto(false);
                this.cont = 0;
                if( this.y < MARGIN_BTM_Y ){
                    setImage("caida"+this.direction+".png");
                    this.y+=this.gravity;
                }
                else{
                    setImage("static"+this.direction+".png");
                    this.cnt_saltos=0;
                }
            }
            if(dx!=0 && this.salto == false )
                setImage("correr"+this.direction+".gif");              
        }
        else{
            if(this.salto == false)
                setImage("gateo"+this.direction+".gif"); 
        } 
        /**Cambios de imagen**/
        /**Limitadores del fondo (INICIO)**/
        if(dx!=0){
            if(dx > 0){
                if(this.distancia < _x){
                    this.distancia+=this.gravity;
                    setMove(true);
                }
                else{
                    setMove(false);
                }
            }
            else{
                if(this.distancia > 0){
                    this.distancia-=this.gravity;
                    setMove(true);
                }
                else {
                    setMove(false);
                }
            }
        }
        else{
            setMove(false);
        }
        /**Limitadores del fondo (FIN)**/
        /**margenes && movimiento dx**/
        if(this.x < this.cont_y && dx > 0){
            this.x += dx;
        }
        else{
            if(this.distancia >= _x )
                if(this.cont_y  < 1150){ this.cont_y +=this.gravity;}
                else{    this.cont_y  = 880;  }      
            if(this.x > this.cont_x && dx < 0 )
                this.x += dx;        
            else {
                if(this.distancia == 0 )
                    if(this.cont_x  > 0){    this.cont_x -=this.gravity;}
                    else{    this.cont_x  = 150;}
            }
        }/**margenes && movimiento dx**/
    }   
}
