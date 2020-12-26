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
public class Grille {

    Cellule Cellules[][] = new Cellule[6][7];
    // point important : la cellule d'indice [0][0] est située en bas à gauche 
    // sur le plateau réel - par convention 
    
    
    
    // initialisation de la grille : on crée 42 cellules vides
    Grille() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                Cellules[i][j] = new Cellule();
            }
        }
    }


    boolean colonne_remplie(int ind_colonne) {
    // methode ajoutée par rapport à l'énoncé
    // retourne vrai si la colonne d'indice ind_colonne estremplie
    // retourne faux sinon
        return (Cellules[5][ind_colonne].recupererJeton() != null);
    }

        
    boolean ajouterJetonDansColonne(Joueur joueurCourant, int ind_colonne) {
        // si la colonne est remplie, on s'arrete et on retourne false
        if (colonne_remplie(ind_colonne)) return false;
        
        // on recherche l'indice de la ligne où ajouter le jeton
        // forcement cet inddice existe 
        int i = 0;
        while (Cellules[i][ind_colonne].jetonCourant != null) {
            i++;
        }

        // on récupére un jeton dans la liste des jetons du joueur 
        Jeton un_jeton = joueurCourant.retirerJeton();
        // on ajoute le jeton dans la case en question
        Cellules[i][ind_colonne].jetonCourant = un_jeton;
        // on récupère un potentiel désintegrateur
        if (Cellules[i][ind_colonne].presenceDesintegrateur()) {
            Cellules[i][ind_colonne].recupererDesintegrateur();
            joueurCourant.nombreDesintegrateurs++;
        }
        // on active le potentiel trou noir
        if (Cellules[i][ind_colonne].presenceTrouNoir()) {
           Cellules[i][ind_colonne].activerTrouNoir();
        }
        return true;
    }
    
  
    
    void activer_trounoir(int column) { // ressort vrai si il y a un desing
        int i = 5;
        while (Cellules[i][column].jetonCourant == null) {
            i--;
            if (i == 0) {
                break;
            }
        }
        if (i >= 0 && i < 6) {
            Cellules[i][column].activerTrouNoir();
        }
        

    }
    
    
 
    boolean etreRemplie() {
        // renvoie vrai si la grille est remplie.
        // il nous suffit de tester si chaque colonne est remplie
        int compteur = 0;
        int i=0;
        // tant que la colonne i est remplie, on incrémente i 
        // et on passe a la colonne suivante 
        while (i!=6 && colonne_remplie(i)) { i++;}
        return (i==6); // si i=6 on a toutes les colonens de remplies 
    }
    
    
    void viderGrille() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                Cellules[i][j].jetonCourant = null;
                Cellules[i][j].trou_noir = false;
                Cellules[i][j].désintegrateur = false;
            }
        }
    }

    
    void afficherGrilleSurConsole() {
 
        // boucle inversée : on affiche d'abord la ligne du haut
        for (int i = 5; i >= 0; i--) {
            for (int j = 0; j < 7; j++) {
                if(Cellules[i][j].trou_noir){
                    System.out.print("\u001B[0m T ");
                }
                  else if (Cellules[i][j].désintegrateur) {
                    System.out.print("\u001B[0m D ");
                } else if (Cellules[i][j].jetonCourant == null) {
                    System.out.print("\u001B[0m N ");
                } else {
                    System.out.print(Cellules[i][j].jetonCourant);
                }
            }
            System.out.println(" " + (i+1));
        }
        for(int i=0; i<7;i++){
            System.out.print(" " + (i+1) + " ");
        }
        System.out.println();
    }

    
    
    boolean celluleOccupee(int ligne, int column) {
        if(Cellules[ligne][column].jetonCourant != null) {
            return true;
        }
        return false;
    }

    String lireCouleurDuJeton(int ligne, int column) {
        return Cellules[ligne][column].lireCouleurDuJeton();
    }

    boolean etreGagnantePourJoueur(Joueur un_joueur) {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                if (Cellules[i][j] != null && Cellules[i][j].lireCouleurDuJeton().equals(un_joueur.Couleur)
                        && Cellules[i][j + 1] != null && Cellules[i][j + 1].lireCouleurDuJeton().equals(un_joueur.Couleur)
                        && Cellules[i][j + 2] != null && Cellules[i][j + 2].lireCouleurDuJeton().equals(un_joueur.Couleur)
                        && Cellules[i][j + 3] != null && Cellules[i][j + 3].lireCouleurDuJeton().equals(un_joueur.Couleur)) {
                    return true;
                }

            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 7; j++) {
                if (Cellules[i][j] != null && Cellules[i][j].lireCouleurDuJeton().equals(un_joueur.Couleur)
                        && Cellules[i + 1][j] != null && Cellules[i + 1][j].lireCouleurDuJeton().equals(un_joueur.Couleur)
                        && Cellules[i + 2][j] != null && Cellules[i + 2][j].lireCouleurDuJeton().equals(un_joueur.Couleur)
                        && Cellules[i + 3][j] != null && Cellules[i + 3][j].lireCouleurDuJeton().equals(un_joueur.Couleur)) {
                    return true;
                }

            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                if (Cellules[i][j] != null && Cellules[i][j].lireCouleurDuJeton().equals(un_joueur.Couleur)
                        && Cellules[i + 1][j + 1] != null && Cellules[i + 1][j + 1].lireCouleurDuJeton().equals(un_joueur.Couleur)
                        && Cellules[i + 2][j + 2] != null && Cellules[i + 2][j + 2].lireCouleurDuJeton().equals(un_joueur.Couleur)
                        && Cellules[i + 3][j + 3] != null && Cellules[i + 3][j + 3].lireCouleurDuJeton().equals(un_joueur.Couleur)) {
                    return true;
                }

            }
        }

        for (int i = 3; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                if (Cellules[i][j] != null && Cellules[i][j].lireCouleurDuJeton().equals(un_joueur.Couleur)
                        && Cellules[i - 1][j + 1] != null && Cellules[i - 1][j + 1].lireCouleurDuJeton().equals(un_joueur.Couleur)
                        && Cellules[i - 2][j + 2] != null && Cellules[i - 2][j + 2].lireCouleurDuJeton().equals(un_joueur.Couleur)
                        && Cellules[i - 3][j + 3] != null && Cellules[i - 3][j + 3].lireCouleurDuJeton().equals(un_joueur.Couleur)) {
                    return true;
                }

            }
        }

        return false;

    }

    Boolean placerTrouNoir(int ligne, int colonne) {
        if (!Cellules[ligne][colonne].trou_noir) {
            Cellules[ligne][colonne].trou_noir = true;
            return true;
        }
        return false;
    }

    Boolean supprimerJeton(int ligne, int colonne) {
        if (Cellules[ligne][colonne].jetonCourant == null) {
            return false;
        }
        Cellules[ligne][colonne].jetonCourant = null;
        return true;
    }

    void tasserGrille() {
        for (int i = 0; i < 7; i++) {
           tasserColonne(i);
        }
    }
    
    
       void tasserColonne(int colonne) {
        for (int i = 0; i < 6; i++) {
            if (i == 5) {
                Cellules[i][colonne].jetonCourant = null;
            } else {
                if (Cellules[i][colonne].jetonCourant  == null) {
                  Cellules[i][colonne].jetonCourant = Cellules[i + 1][colonne].jetonCourant;
                  Cellules[i + 1][colonne].jetonCourant=null;
                }
            }

        }
    }

    Jeton recupererJeton(int ligne, int colonne) {
        Jeton t = Cellules[ligne][colonne].recupererJeton();
        Cellules[ligne][colonne].supprimerJeton();
        return t;
    }

    Boolean placerDesintegrateur(int ligne, int colonne) {
        if (!Cellules[ligne][colonne].désintegrateur) {
            Cellules[ligne][colonne].désintegrateur = true;
            return true;
        }
        return false;
    }

}
