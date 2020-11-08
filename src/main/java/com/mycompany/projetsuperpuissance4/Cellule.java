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
public class Cellule {
    
    boolean trouNoir; // initialisation des variables
    boolean desintegrateur;
    Jeton jetonCourant;
    
    
    public Cellule() {  // création de la cellule de jeu
       jetonCourant = null; // initialisation de la cellule sans jetons
       desintegrateur = false; // initialisation de la cellule sans désintégrateurs
       trouNoir = false; // initialisation de la cellule sans trous noirs
    }
    
    public boolean affecterJeton(Jeton Un_Jeton) {
        if (jetonCourant == null) {  //si la case est vide de jeton on peut lui affecter un jeton
            jetonCourant = Un_Jeton;
            return true;
        } else { 
            return false;
        }
    }
    
    public Jeton recupererJeton() {  //quand on doit récupérer un jeton de la cellule, on va changer la référence du jeton 
        Jeton jetonRecup = jetonCourant;  // on passe du jetonCourant (présent dans la cellule) à un jeton qui sera récupéré (jetonRecup)
        jetonCourant = null; // si la cellule ne contient pas de jeton, rien ne se passe (on renvoie null)
        return jetonRecup;
    }
    
    public boolean supprimerJeton() {
        if (jetonCourant == null) {  //si la case est vide de jeton, il n'est pas nécessaire de supprimer le jeton, on renvoie false
            return false;
        }
        jetonCourant = null; 
        return true;
        
    }
    
    public boolean placerTrouNoir() {
        if (trouNoir == false) {  //placer un trou noir si celui-ci n'est pas présent dans la cellule
            trouNoir = true ;
            return true;
        } else {
            return false; //la fonction renvoie faux si un trou noir a déjà été placé dans la cellule (on ne peut pas placer un trou noir par dessus un autre trou noir)
        }
    }
    
    public boolean placerDesintegrateur() { //même fonctionnement que la fonction "placerTrouNoir"
        if (desintegrateur == false) {
            desintegrateur = true;
            return true;
        } else {
            return false;
        }
    }
    
    public boolean presenceTrouNoir() {
        return trouNoir;
    }
    
    public boolean presenceDesintegrateur() {
        return desintegrateur;
    }
    
    public String lireCouleurDuJeton() { // permet de renvoyer la couleur du jeton, 
        if (jetonCourant == null) {
            return "rien"; // si il n'y a pas de jetons la cellule, il n'y a pas de couleur à renvoyer (on renvoie juste "rien")
        } else {
        return jetonCourant.Couleur;
        }
       
    }
    
    public boolean recupererDesintegrateur() {
        if (presenceDesintegrateur()) {  // on réutilise la fonction "presenceDesintegrateur" pour voir si un désintégrateur est présent dans la cellule ou non
            desintegrateur = false; // le "jeton" désintégrateur a été récupéré et enlevé de la cellule
            return true;
        } else {
        return false;
    }
    }
    
    public boolean activerTrouNoir() {
        if (trouNoir == true) {
            jetonCourant = null; // le jeton est avalé par le trou noir, il disparaît donc
            trouNoir = false; // le trou noir a réalisé sa mission d'avaler le jeton, il est désactivé
            System.out.println("Votre jeton a été avalé par le trou noir");
            return true;
        } else {
            return false;
        }
    }
    
    
    
}
