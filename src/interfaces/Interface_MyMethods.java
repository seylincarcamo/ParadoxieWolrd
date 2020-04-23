/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import objects.*;

public interface  Interface_MyMethods
{
    FondoAnimation[] getSetFondoAnimation(int dig, int tipo);
    Pisos[] getPisos(int tipo);
    CoinGema[] getCoinsGemas(int nivel);
    Sierra[] getSierras();
    Suelo[] getSetSuelo(int dig, int tipo);
}