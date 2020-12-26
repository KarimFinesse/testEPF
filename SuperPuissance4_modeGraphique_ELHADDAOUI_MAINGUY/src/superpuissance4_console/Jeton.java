/*
* TP3 Projet Super Puissance 4
TDC1 
Chakir EL HADDAOUI et Maeldane MAINGUY
23 Octobre 2020
 */
package superpuissance4_console;

/**
 *
 * @author bdarties
 */
public class Jeton {
    String Couleur;
    
    Jeton(String coul){
        Couleur = coul;
    }
    
    // ajout d'un commentaire
    String lireCouleur(){
        return Couleur;
    }
    
    // notez le vert
    @Override
    public String toString(){
        if("Rouge".equals(Couleur))
            return "\u001B[31m O ";
        return "\u001B[33m O ";
    }
}
