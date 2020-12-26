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
public class Joueur {
    
    
    
    String Nom;
    String Couleur;
    Jeton ListeJetons[] = new Jeton [21];
    int nombreDesintegrateurs;
    int nombreJetonsRestant;
    
    Joueur(String nom_joueur){
        Nom = nom_joueur;
        nombreDesintegrateurs = 0;
        nombreJetonsRestant = 0;
    } 
    
    void affecterCouleur(String coul){
        Couleur = coul;
    }
    
    void ajouterJeton(Jeton un_jeton){
        ListeJetons[nombreJetonsRestant++] = un_jeton;
    }
    
    Jeton retirerJeton(){
        nombreJetonsRestant = nombreJetonsRestant-1;
        return ListeJetons[nombreJetonsRestant];
    }
    
    void obtenirDesintegrateur(){
        nombreDesintegrateurs += 1;
    }
    
    boolean utiliserDesintegrateur(){
        if(nombreDesintegrateurs==0){
            return false;
        }
        nombreDesintegrateurs--;
        return true;
    }
    
    
}
