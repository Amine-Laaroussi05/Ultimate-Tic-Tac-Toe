import java.util.*;

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


    /**
     * Détermine l'emplacement des symboles du joueur
     * @param entierJoueur : l'entier affecté au joueur (durant toute la partie) selon les coordonnées qu'il a saisies
     * @return : L'ensemble des emplacements des symboles du joueur
     */
    public static Set<Integer> positionSymboles(int entierJoueur){
        Set<Integer> listeEmplacement = new HashSet<>(); // L'ensemble des emplacements des symboles du joueur
        if(entierJoueur > 512 | entierJoueur < 0) throw new IllegalArgumentException(); // l'entier doit être compris entre 1 et 512 inclus
        for(int indice = 8; indice > -1; indice--){ // on parcourt les 9 cases de la grille 3x3 numérotées de 1 à 9
            if(entierJoueur >= Math.pow(2,indice)){ // si l'entier est supérieur à 2^(n° de la case), on ajoute ce n° à l'ensemble
                listeEmplacement.add(indice+1);
                entierJoueur -= Math.pow(2,indice); // et on enlève cet entier du paramètre entierJoueur
            }
        }
        return listeEmplacement;
    }


    /**
     * Évalue si la condition de victoire (à savoir l'alignement des symboles du joueur en vertical, horizontal ou diagonale) est vérifiée
     * @param entierJoueur : l'entier affecté au joueur selon les coordonnées qu'il a saisies le long de la partie
     * @return : true ou false selon si les symboles sont alignés ou pas
     */
    public static boolean conditionDeVictoire(int entierJoueur){
        List<Integer> entiersPredefinis = Arrays.asList(7,56,73,84,146,273,292,448); // La liste des entiers prédéfinis permettant la victoire
        Set<Integer> listeEntiersPredefinis = new HashSet<>(entiersPredefinis); // Utilisation de la liste comme un ensemble
        return listeEntiersPredefinis.contains(entierJoueur); // on vérifie si l'ensemble contient le paramètre entierJoueur, si tel est le cas, on retourne true, sinon false
    }


    /**
     * Méthode qui permet d'illustrer l'emplacement des symboles de chaque joueur
     * @param entierJoueur1 : l'entier affecté au joueur1
     * @param entierJoueur2 : l'entier affecté au joueur2
     */
    public static void illustrationJeu(int entierJoueur1, int entierJoueur2){
        StringBuilder lignesJeu = new StringBuilder("_______\n|");
        for(int numeroLigne = 1; numeroLigne < 4; numeroLigne++){
            for(int numeroCase = 1; numeroCase < 4; numeroCase++){
                if(positionSymboles(entierJoueur1).contains(numeroCase+3*(numeroLigne-1))) lignesJeu.append("x");
                else if(positionSymboles(entierJoueur2).contains(numeroCase+3*(numeroLigne-1))) lignesJeu.append("o");
                else lignesJeu.append(" ");
                lignesJeu.append("|");
            }
            if(numeroLigne != 3) lignesJeu.append("\n|");
            else lignesJeu.append("\n");
        }
        System.out.print(lignesJeu);
    }



    /**
     * Permet de vérifier que les coordonnées saisies par le joueur n'ont pas été précédemment utilisées par ce joueur ou un autre joueur lors de ce tour ou un tour précédent.
     * @param rowCoord : La composante en ligne de la coordonnée
     * @param colCoord : La composante en colonne de la coordonnée
     * @param entierJoueur1 : L'entier affecté au joueur 1 encodant l'emplacement de ces symboles
     * @param entierJoueur2 : L'entier affecté au joueur 2 encodant l'emplacement de ces symboles
     * @return : True si la coordonnée n'est pas encodée dans un des entiers, False sinon
     */
    public static boolean coordonneeValide(int rowCoord, int colCoord, int entierJoueur1, int entierJoueur2){
        if(rowCoord > 2 | rowCoord < 0 | colCoord > 2 | colCoord < 0 | entierJoueur1 > 512 | entierJoueur1 < 0 | entierJoueur2 > 512 | entierJoueur2 < 0)
            throw new IllegalArgumentException();
        Iterator<Integer> iterator = positionSymboles(calculJoueur(rowCoord, colCoord)).iterator(); // Pour parcourir l'ensemble (qui est constitué d'un seul nombre)
        int nombre = iterator.next(); // Pour utiliser ce nombre
        return !(positionSymboles(entierJoueur1).contains(nombre) | positionSymboles(entierJoueur2).contains(nombre));
        // False si ce nombre est encodé dans un des entiers entierJoueur1 ou entierJoueur2
        // True sinon
    }



    public static void main(String[] args) throws Exception {
        int rowCoord;
        int colCoord;
        int entierJoueur1 = 0;
        int entierJoueur2 = 0;
        Scanner scanner = new Scanner(System.in);
        for(int numeroTour = 1; numeroTour < 6; numeroTour++){
                // Tour du joueur 1
                System.out.println("\nSaisir une coordonnée pour le joueur 1");
                rowCoord = scanner.nextInt();
                colCoord = scanner.nextInt();
                entierJoueur1 += calculJoueur(rowCoord,colCoord);
                illustrationJeu(entierJoueur1,entierJoueur2);
                if(conditionDeVictoire(entierJoueur1)){
                    System.out.println("\nBravo, le joueur 1 a gagné la partie !");
                    break;
                }
                // Tour du joueur 2
                System.out.println("\nSaisir une coordonnée pour le joueur 2");
                rowCoord = scanner.nextInt();
                colCoord = scanner.nextInt();
                entierJoueur2 += calculJoueur(rowCoord,colCoord);
                illustrationJeu(entierJoueur1,entierJoueur2);
                if(conditionDeVictoire(entierJoueur2)){
                    System.out.println("\nBravo, le joueur 2 a gagné la partie !");
                    break;
                }
                if(numeroTour == 5) System.out.println("\nPartie terminée. Aucun vainqueur.");
        }

    }


}
