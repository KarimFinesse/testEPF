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
public class Cellule {
    
    Jeton jetonCourant;
    boolean trou_noir;
    boolean désintegrateur;
    
    
    // constructeur appelé a la création d'une cellule
    Cellule(){
        jetonCourant = null; // pas de jeton a la creation de la cellule
        trou_noir = false ; // pas de trou noir 
        désintegrateur = false ; // pas de desintegrateur 
        
    }
    
    boolean affecterJeton(Jeton un_jeton){
        if(jetonCourant == null){
            jetonCourant = un_jeton;
            return true;
        }
        return false;
    }
    
    // permet de récupérer le jeton de la cellule.
    // on renvoie une référence vers le jeton, et on l'enleve de la cellule.
    // si la cellule ne contenait pas de jeton, on renvoie juste null
    Jeton recupererJeton(){
        Jeton jetonRetour = jetonCourant;
        jetonCourant  = null;
        return jetonRetour;
    }
    
    
    boolean supprimerJeton(){
        if(jetonCourant == null){
            return false;
        }
        jetonCourant = null;
        return true;
    }
    
    // renvoie la couleur du jeton affecté a la cellule, ou le mot "vide" sinon
    String lireCouleurDuJeton(){
        if(jetonCourant == null){
            return "vide";
        }
        return jetonCourant.Couleur;
    }
    
    // place un trou noir sur la cellule et renvoie vrai
    // ou renvoie faux si le trou noir était déja placé
    Boolean placerTrouNoir(){
        if(trou_noir){
            return false;
        }
        trou_noir = true;
        return true;
    }
    
    Boolean presenceTrouNoir(){
        return trou_noir;
    }
    
    Boolean activerTrouNoir(){
        if(trou_noir){
            jetonCourant = null;
            trou_noir = false;
            System.out.println("Votre pion c'est fait engloutir dans le trou noir !");
            return true;
        }
        return false;
    }
    
    Boolean placerDesintegrateur(){
        if(désintegrateur){
            return false;
        }
        désintegrateur = true;
        return true;
    }
    
    Boolean presenceDesintegrateur(){
        return désintegrateur;
    }
    
    Boolean recupererDesintegrateur(){
        if(presenceDesintegrateur()){
            désintegrateur = false;
            return true;
        }
        return false;
    }
    
    
}
