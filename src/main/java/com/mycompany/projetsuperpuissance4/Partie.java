/*
* TP3 Projet Super Puissance 4
TDC1 
Chakir EL HADDAOUI et Maeldane MAINGUY
23 Octobre 2020
 */
package com.mycompany.projetsuperpuissance4;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author maeldicomputer
 */
public class Partie {
    
    Joueur joueurCourant;
    Joueur ListeJoueurs[] = new Joueur[2];
    Grille Grille_Jeu = new Grille[]
   
    public void attribuerCouleursAuxJoueurs() {
        Grille_Jeu.viderGrille() ;
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Choix nom Joueur 1 : ");
        Joueur Joueur_1 = new Joueur(sc.nextLine());
        System.out.println("Choix nom Joueur 2 : ");
        Joueur Joueur_2 = new Joueur(sc.nextLine());
        ListeJoueurs[0] = Joueur_1;
        ListeJoueurs[1] = Joueur_2;
        
        attribuerCouleurAuxJoueurs();
        
        System.out.println(Joueur_1.Nom+ "a pour couleur le " +Joueur_1.Couleur);
        System.out.println(Joueur_2.Nom+ "a pour couleur le " +Joueur_2.Couleur);
        
        for (int i=0; i<21; i++) {
            Joueur_1.ajouterJeton(new Jeton(Joueur_1.Couleur));
            Joueur_2.ajouterJeton(new Jeton(Joueur_2.Couleur));
            
            Random aleat = new Random();
            boolean premier_joueur;
            premier_joueur = aleat.nextBoolean();
            if (premier_joueur) {
                joueurCourant = ListeJoueurs[0];
            } else {
                joueurCourant = ListeJoueurs[1];
            }

        }
        
        Random aleat = new Random();
        int compteur = 0;
        for (int i=0; i<5; i++) {
            int ligne_trouNoir = aleat.nextInt(6);
            int colonne_trouNoir = aleat.nextInt(7);
            if (compteur<2) {
                if (!Grille_Jeu.placerDesintegrateur(ligne_trouNoir , colonne_trouNoir)) {
                    compteur--;
                }
                compteur +=1;
            }
            if (!Grille_Jeu.placerTrouNoir(ligne_trouNoir, colonne_trouNoir)) {
                i--;
            }
        }
        
        for (int i=0; i<3; i++) {
            int ligne_desintegrateur = aleat.nextInt(6);
            int colonne_desintegrateur = aleat.nextInt(7);
            if (Grille_Jeu.placerDesintegrateur(ligne_desintegrateur, colonne_desintegrateur) || Grille_Jeu.Cellules[ligne_desintegrateur, colonne_desintegrateur ]));
        }
        
        Grille_Jeu.afficherGrilleSurConsole();

    }
    

    
    public void debuterPartie() {
        
    }
    
    public void initialiserPartie () { // affection aléatoire de la couleur du joueur
        Random aleat = new Random();
        boolean couleurj;
        couleurj = aleat.nextBoolean();
        if (couleurj) {
            ListeJoueurs[0].Couleur = "Jaune";
            ListeJoueurs[1].Couleur = "Rouge";
        } else {
            ListeJoueurs[0].Couleur = "Rouge";
            ListeJoueurs[1].Couleur = "Jaune";

        }
        
    }
    
    int menu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choisissez une des instructions suivantes : ");
        System.out.println(" (1) Jouer un jeton ");
        System.out.println(" (2) Récupérer un jeton ");
        System.out.println(" (3) Désintégrer un jeton ");
        int rep = sc.nextInt(); 
        
        switch (rep) { // les différents "cas", c'est-à-dire a réponse choisie par le joueur
            
            case 1:
               Jouer_un_Jeton();
               break;  // Utilisation du break pour mettre fin au programme
            case 2:
                Récup_un_Jeton();
                break;
            case 3:
                desinteg_jeton();
                break;
             default: 
                    System.out.println("Choix non valide"); //Utilisation du default pour une mauvaise réponse ou une réponse non reconnue
                    break;
                
        
    }
        return rep;


    }
    
    public void Jouer_un_Jeton() {
        Scanner sc = new Scanner(System.in);
        boolean ajout_jeton;
        System.out.println("Choix de la colonne pour placer le jeton : ");
        int Colonne = sc.nextInt() - 1;
        while (Colonne>6 || Colonne>0 ) {
            System.out.println("Choix non valide");
            Colonne = sc.nextInt() - 1;
        }
    
    ajout_jeton = Grille_Jeu.ajouterJetonDansColonne(joueurCourant, Colonne);
    while(ajout_jeton != true) {
        System.out.println("Colonne remplie, sélectionner une autre colonne pour poursuivre l'ajout de votre jeton : ");
        Colonne = sc.nextInt() - 1;
        ajout_jeton = Grille_Jeu.ajouterJetonDansColonne(joueurCourant, Colonne);
    }
        
    }
    
    public boolean Récup_un_Jeton() {
        
        int ligne;
        int colonne;
        Scanner sc = new Scanner(System.in);
        System.out.println("Quelle est la ligne du jeton à récupérer ? ");
        System.out.println("Quelle est la colonne du jeton à récupérer ? ");
        
        ligne = sc.nextInt() - 1;
        while (ligne>5 || ligne<0 ) {
            System.out.println("Choix non valide");
        }
        
        colonne = sc.nextInt() - 1;
        while (colonne>6 || ligne<0) {
            System.out.println("Choix non valide");
        }

        if (Grille_Jeu.Cellules[ligne][colonne].jetonCourant != null) {
            joueurCourant.ajouterJeton(Grille_Jeu.recupererJeton(ligne, colonne));
            Grille_Jeu.tasserGrille(ligne, colonne);
            return true;    
        } else {
            return false;
        }
            
    } 
    
    public boolean desinteg_jeton() {
        if(joueurCourant.nombreDesintegrateurs == 0) {
            return false;
        }
            int ligne;
            int colonne;
             Scanner sc = new Scanner(System.in);
        System.out.println("Quelle est la ligne du jeton à désintégrer ? ");
        System.out.println("Quelle est la colonne du jeton à désintégrer ? ");
        
        ligne = sc.nextInt() - 1;
        while (ligne>5 || ligne<0 ) {
            System.out.println("Choix non valide");
        }
        
        colonne = sc.nextInt() - 1;
        while (colonne>6 || ligne<0) {
            System.out.println("Choix non valide");
        }

        if (Grille_Jeu.Cellules[ligne][colonne].jetonCourant != null) {
            joueurCourant.supprimerJeton(ligne, colonne);
            Grille_Jeu.tasserGrille(ligne, colonne);
            joueurCourant.utiliserDesintegrateur();
            return true;    
        } else {
            return false;
        }
    }

    private void attribuerCouleurAuxJoueurs() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
