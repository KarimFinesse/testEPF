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
public class Grille {
    
    Cellule Cellules[][] = new Cellule[6][7];
    
    Grille() { // on crée une grille de 47 cellules vides (6*7 = 42)
        for (int i=0; i<6; i++) {  
            for (int j=0; j<7; j++) { 
                Cellules[i][j] = new Cellule();
            }
        }
    }
   
    
    public boolean ajouterJetonDansColonne(Jeton Un_Jeton, int ind_colonne) {
        if (colonne_remplie(ind_colonne)) return false;
        int i = 0 ;
        while (Cellules[i][ind_colonne].jetonCourant != null) {
            i++;
            
        }
        Jeton Un_Jeton = joueurCourant.retirerJeton();
        Cellules[i][ind_colonne].jetonCourant = Un_Jeton;
        if (Cellules[i][ind_colonne].presenceDesintegrateur()) {
            Cellules[i][ind_colonne].recupererDesintegrateur();
            joueurCourant.nombreDesintegrateur++;
        }
          if (Cellules[i][ind_colonne].presenceTrouNoir()){
              Cellules[i][ind_colonne].activerTrouNoir();
          }
         
        
    }
    
    public boolean etreRemplie() {
        int c=0;
        for (int i=0; i<=5; i++ ) {
            for (int j=0; j<=6; j++) {
                if (Cellules[i][j].jetonCourant == null) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public void viderGrille() {
        for (int i=0; i<=5; i++) {
            for (int j=0; j<=6; j++) {
                Cellules[i][j].jetonCourant = null;
           }
        }
        
    }
    
    public void afficherGrilleSurConsole() {
        for (int i=0; i<=5; i++) {
            for (int j=0; j<=6; j++) {
                System.out.println(Cellules[i][j].jetonCourant);
            }
        }
        
    }
    
    public boolean celluleOccupee(int i , int j) {
        if (Cellules[i][j] == null) {
            return false;
        } else {
            return true;
        }
        
    }
    
    public String lireCouleurDuJeton(int i, int j) {
        return Cellules[i][j].jetonCourant.Couleur;
        
    }
    
    public boolean etreGagnantePourJoueur(Joueur JP) {
        boolean J=false;
        for (int i=0; i<=5; i++) {
            for (int j=0; j<=6; j++) {
                if (lireCouleurDuJeton(i,j).equals(JP.Couleur) && )
            }
        }
    }
    
    public void tasserGrille(int i, int j) {
        for (int v=j; i<k; i++ ) {
            Cellules[i+1][j] = Cellules [i][j];
        }
        
        
    }
    
    public boolean colonneRemplie(int ind_colonne) {
        return (Cellules[5][ind_colonne].recupererJeton() != null);
    
}
    
    public boolean placerDesintegrateur(int i, int j) {
       boolean k = false;
        if (Cellules[i][j].desintegrateur == false) {
            Cellules[i][j].desintegrateur == true;
            k = true;
        }
        return k; 
        
    }
    
    public boolean placerTrouNoir(int i , int j) {
        boolean k = false;
        if (Cellules[i][j].trouNoir == false) {
            Cellules[i][j].trouNoir == true;
            k = true;
        }
        return k;
    }
    
    public boolean supprimerJeton(int i , int j ) {
        boolean k = false;
        if (Cellules[i][j].jetonCourant != null) {
            Cellules[i][j].jetonCourant == null;
            k = true;
        }
        return k;
        
    }
    
    public Jeton recupererJeton(int i , int j) {
        
        
    }

    boolean ajouterJetonDansColonne(Joueur joueurCourant, int Colonne) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
