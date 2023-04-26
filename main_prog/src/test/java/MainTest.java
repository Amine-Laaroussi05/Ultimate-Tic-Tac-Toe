import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    /**
     * Tests pour la méthode Calcul_joueur
     */
     @ParameterizedTest
     @CsvFileSource(resources = "/calcul_Joueur/coordonneesNonValides.csv", numLinesToSkip = 1)
     public void coordonneesNonValides(int rowCoord, int colCoord){
         assertThrows(IllegalArgumentException.class, () -> {
            Main.calculJoueur(rowCoord, colCoord);
         });
     }

    @Test
    void main() {
    }
}