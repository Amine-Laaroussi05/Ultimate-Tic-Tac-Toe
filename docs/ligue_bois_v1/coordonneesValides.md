# coordonneesValides

## Description

Permet de vérifier que les coordonnées saisies par le joueur n'ont pas été précédemment utilisées par un autre joueur lors de ce tour ou un tour précédent.

## Syntaxe

```java
public static boolean coordonneesValide(int rowCoord, int colCoord, int entierJoueur1, int entierJoueur2){
    // comparaison de la coordonnée avec les entiers affectés aux joueurs
}
```

## Données

- `rowCoord` : La composante en ligne de la coordonnée

- `colCoord` : La composante en colonne de la coordonnée

- `entierJoueur1` : L'entier affecté au joueur 1

- `entierJoueur2` : L'entier affecté au joueur 2

## Tests

1. Les paramètres des joueurs initialisés à 0

2. Le joueur 1 utilise une coordonnée qu'il a déjà utilisé dans le jeu

3. Le joueur 1 utilise une coordonnée utilisé par le joueur 2

4. Le joueur 2 utilise une coordonnée qui a été utilisé par le joueur 1

5. Saisi  de coordonnées ou d'entiers non valides


