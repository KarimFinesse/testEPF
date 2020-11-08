/*
* TP3 Projet Super Puissance 4
TDC1 
Chakir EL HADDAOUI et Maeldane MAINGUY
23 Octobre 2020
 */
package com.mycompany.projetsuperpuissance4;

/**
 *
 * @author maeldicomputer
 */
public class Jeton {
    
    String Couleur;
    
    public Jeton(String Une_Couleur) {
        
        Couleur = Une_Couleur;
        
    }
    
    String lireCouleur() {
        return Couleur;
    }
    
    @Override
    public String toString () {
        String lireCouleur = "La couleur du jeton est " +Couleur;
        return lireCouleur;  
        
        
    }
    
    
}
