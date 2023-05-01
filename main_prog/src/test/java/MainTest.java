import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;


class MainTest {


    // ________________________________________________Calcul_joueur________________________________________________________


    /**
     * Tests pour la méthode Calcul_joueur
     */
     @ParameterizedTest
     @CsvFileSource(resources = "/calcul_Joueur/coordonneesNonValides.csv", numLinesToSkip = 1)
     public void calculJoueurException(int rowCoord, int colCoord){
         assertThrows(IllegalArgumentException.class, () -> {
            Main.calculJoueur(rowCoord, colCoord);
         });
     }


     @ParameterizedTest
     @CsvFileSource(resources = "/calcul_Joueur/Echantillon_Test.csv", numLinesToSkip = 1)
     public void calculJoueurTest(int rowCoord, int colCoord, int entierJoueur){
         assertEquals(entierJoueur, Main.calculJoueur(rowCoord, colCoord));
     }


     @RepeatedTest(1000)
     public void calculJoueurAleatoire(){
         Random random = new Random();
         int rowCoord = random.ints(1,0,3).iterator().nextInt();
         int colCoord = random.ints(1,0,3).iterator().nextInt();
         switch (rowCoord){
             case 0:
                 assertEquals((int) Math.pow(2,rowCoord+colCoord),Main.calculJoueur(rowCoord,colCoord));
                 break;
             case 1:
                 assertEquals((int) Math.pow(2,rowCoord+colCoord+2),Main.calculJoueur(rowCoord,colCoord));
                 break;
             case 2:
                 assertEquals((int) Math.pow(2,rowCoord+colCoord+4),Main.calculJoueur(rowCoord,colCoord));
                 break;
         }
     }





// _____________________________________________Position_Symboles_________________________________________________________





    /**
     * Tests pour la méthode Position_Symboles
     */
    @ParameterizedTest
    @CsvFileSource(resources = "/position_Symboles/Entier_Valide.csv",numLinesToSkip = 1)
    public void positionSymbolesException(int entierJoueur){
        assertThrows(IllegalArgumentException.class, () -> {
            Main.positionSymboles(entierJoueur);
        });
    }


    @ParameterizedTest
    @CsvFileSource(resources = "/position_Symboles/Echantillon_Test.csv",numLinesToSkip = 1)
    public void positionSymbolesTest(int entierJoueur, String listeEntiers){
        Set<Integer> listeEmplacementsAttendue = new HashSet<>();
        String[] listeSplit = listeEntiers.split(" ");
        for (String s : listeSplit) {
            listeEmplacementsAttendue.add(Integer.parseInt(s));
        }
        assertEquals(listeEmplacementsAttendue,Main.positionSymboles(entierJoueur));
    }





// _______________________________________________Condition_de_Victoire___________________________________________________________






    /**
     * Test pour la méthode Condition_de_Victoire
     */
    @ParameterizedTest
    @CsvFileSource(resources = "/condition_de_Victoire/Echantillon_Test.csv", numLinesToSkip = 1)
    public void conditionDeVictoireTest(int entierJoueur, boolean conditionAttendu){
        if(conditionAttendu) assertTrue(Main.conditionDeVictoire(entierJoueur));
        else assertFalse(Main.conditionDeVictoire(entierJoueur));
    }






// _______________________________________________Illustration_Jeu_________________________________________________________









    /**
     * Test pour la méthode Illustration_Jeu
     */
    @ParameterizedTest
    @CsvFileSource(resources = "/illustration_Jeu/Echantillon_Test", numLinesToSkip = 1)
    public void illustrationJeu(int entierJoueur1, int entierJoueur2,String symbolesJoueur1, String symbolesJoueur2) throws Exception {
        String[] listeStringJoueur1 = symbolesJoueur1.split(" ");
        String[] listeStringJoueur2 = symbolesJoueur2.split(" ");
        ArrayList<Integer> listeJoueur1 = new ArrayList<>();
        for (String s : listeStringJoueur1) listeJoueur1.add(Integer.parseInt(s));
        ArrayList<Integer> listeJoueur2 = new ArrayList<>();
        for (String s : listeStringJoueur2) listeJoueur2.add(Integer.parseInt(s));
        StringBuilder ligne = new StringBuilder("_______\n|");
        for(int numeroLigne = 1; numeroLigne<4; numeroLigne++){
            for(int indice=1; indice<4; indice++){
                if(listeJoueur1.contains(indice+3*(numeroLigne-1))) ligne.append("x");
                else if(listeJoueur2.contains(indice+3*(numeroLigne-1))) ligne.append("o");
                else ligne.append(" ");
                ligne.append("|");
            }
            if(numeroLigne != 3) ligne.append("\n|");
            else ligne.append("\n");
        }
        String texteActuel = tapSystemOut(() -> {
            Main.illustrationJeu(entierJoueur1,entierJoueur2);
        });
        assertEquals(ligne.toString(), texteActuel);
    }










    // _________________________________________________main____________________________________________________________











    /**
     * Test du programme sur un tour particulier
     * @param numeroTour : le n° du tour
     * @param initiative : le tour du joueur qui va saisir les coordonnées, au tour du joueur1 si true, au tour du joueur2 si false
     * @param entierJoueur1 : l'entier affecté au joueur 1 selon ce qu'il a saisi précédemment comme coordonnées
     * @param entierJoueur2 : l'entier affecté au joueur 2 selon ce qu'il a saisi précédemment comme coordonnées
     * @param rowCoord : l'entier de ligne saisi par le joueur
     * @param colCoord : l'entier de colonne saisi par le joueur
     * @param symbolesJoueur1 : ce qui est attendu comme ensemble des emplacements du symbole du joueur 1
     * @param symbolesJoueur2 : ce qui est attendu comme ensemble des emplacements du symbole du joueur 2
     */
    @ParameterizedTest
    @CsvFileSource(resources = "/", numLinesToSkip = 1)
    void main(int numeroTour,boolean initiative, int entierJoueur1, int entierJoueur2, int rowCoord, int colCoord, String symbolesJoueur1, String symbolesJoueur2, int siVictoire) throws Exception {
        String debutTour = tapSystemOut(()->{
            Main.main(null);
        });
        if(initiative){
            assertEquals("Saisir les coordonnées pour le joueur 1", debutTour);
            assertEquals(entierJoueur1, Main.calculJoueur(rowCoord, colCoord));
            String grille = tapSystemOut(()->{
                Main.main(null);
            });
        }
        else assertEquals("Saisir les coordonnées pour le joueur 2", debutTour);
    }

}