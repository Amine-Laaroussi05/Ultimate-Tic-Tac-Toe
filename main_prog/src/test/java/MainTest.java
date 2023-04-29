import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;


class MainTest {

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











    /**
     * Test pour la méthode Condition_de_Victoire
     */
    @ParameterizedTest
    @CsvFileSource(resources = "/condition_de_Victoire/Echantillon_Test.csv", numLinesToSkip = 1)
    public void conditionDeVictoireTest(int entierJoueur, boolean conditionAttendu){
        if(conditionAttendu) assertTrue(Main.conditionDeVictoire(entierJoueur));
        else assertFalse(Main.conditionDeVictoire(entierJoueur));
    }















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
        String texte = tapSystemOut(() -> {
            String ligne1 = "**********";
            ArrayList<StringBuilder> lignes = new ArrayList<>();
            for(int numeroLigne = 0; numeroLigne<3; numeroLigne++){
                StringBuilder ligne = new StringBuilder("|");
                for(int indice=0; indice<3; indice++){
                    if(listeJoueur1.contains(indice+2*numeroLigne)) ligne.append("x");
                    else if(listeJoueur2.contains(indice+2*numeroLigne)) ligne.append("o");
                    else ligne.append(" ");
                    ligne.append("|");
                }
                lignes.add(ligne);
            }
            String ligne5 = "**********";
        });
    }


    @Test
    void main() {
    }
}