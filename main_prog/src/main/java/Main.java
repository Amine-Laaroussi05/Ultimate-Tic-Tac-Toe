import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Main {


    /**
     * Permet d'effectuer une opération sur les coordonnées pour calculer un entier encodant l'emplacement du symbole.
     * @param rowCoord : 1ère coordonnée de ligne
     * @param colCoord : 2ème coordonnée de colonne
     * @return : 2^(n° de la case)
     */
    public static int calculJoueur(int rowCoord, int colCoord){
        ArrayList<Integer> listCoordonnesValides  = new ArrayList<>(); // La liste des coordonnées valides
        int entierCalcule = rowCoord + colCoord; // L'entier qui sera calculé par la méthode
        for(int nombre = 0; nombre < 3; nombre++) listCoordonnesValides.add(nombre); // Vérifie si les coordonnées sont valides
        if(!listCoordonnesValides.contains(rowCoord) | !listCoordonnesValides.contains(colCoord)) throw new IllegalArgumentException();
        // On ajoute un 2 ou un 4 selon la case où on se trouve. Si 2ème ligne par exemple, on ajoute à la somme des deux coordonnes rowCoord = 1
        // et colCoord = 0 la valeur 2 pour obtenir 3 ce qui représente le numéro de la case du carré 3x3.
        if(rowCoord == 1) entierCalcule += 2;
        else if(rowCoord == 2) entierCalcule += 4;
        return (int) Math.pow(2,entierCalcule);
    }



    public static Set<Integer> positionSymboles(int entierJoueur){
        Set<Integer> listeEmplacement = new HashSet<>();
        if(entierJoueur > 512 | entierJoueur < 0) throw new IllegalArgumentException();
        for(int indice = 8; indice > -1; indice--){
            if(entierJoueur >= Math.pow(2,indice)){
                listeEmplacement.add(indice);
                entierJoueur -= Math.pow(2,indice);
            }
        }
        return listeEmplacement;
    }



    public static void main(String[] args) {

    }


}
