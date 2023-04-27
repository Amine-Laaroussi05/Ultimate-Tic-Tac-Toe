import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

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
    public void positionSymbolesTest(int entierJoueur,int tailleListe, int entier1, int entier2, int entier3, int entier4){
        

    }

    @RepeatedTest(10)
    public void positionSymbolesRandom(){
        Random random = new Random();
        int entierJoueur = random.ints(1,0,513).iterator().nextInt();
    }


    @Test
    void main() {
    }
}