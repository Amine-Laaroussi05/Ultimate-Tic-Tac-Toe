# Calcul_joueur

## Description

Effectue des opérations sur les coordonnées pour calculer un entier qui sera ajouté plus tard à un entier affecté au joueur.

## Syntaxe

```java
public static int calculJoueur(int rowCoord, int colCoord,){
    // Opérations sur les coordonnées permettant d'en déduire un entier
}
```

## Données

- `rowCoord` : La coordonnée de ligne saisie par le joueur

- `colCoord` : La coordonnée de colonne saisie par le joueur

## Tests

1. Coordonnée non valide

2. Échantillon de tests
   
   - 1ère ligne, 1ère colonne
   
   - 1ère ligne, 2ème colonne
   
   - 2ème ligne, 1ère colonne
   
   - 3ème ligne, 3ème colonne

3. Avec un test aléatoire

---

## Description détaillée

1. Enclenchement d'une condition selon la valeur de `rowCoord` : 0, 1 ou 2

2. Somme de `rowCoord` avec `colCoord`

3. À cette somme, on ajoute 0, 2 ou 4 selon la condition

4. La méthode retourne la valeur `2^(cette somme)`
