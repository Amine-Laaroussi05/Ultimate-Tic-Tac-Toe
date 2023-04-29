# Illustration_Jeu

## Description

Permet de suivre visuellement les actions des joueurs.

## Syntaxe

```java
public static void illustrationJeu(int entierJoueur1, int entierJoueur2){
    // positionnement des symboles dans une grille 3x3
}
```

## Donnée

- `entierJoueur` : l'entier affecté au joueur et codant l'emplacement des symboles du joueur

## Tests

1. Grille avec un symbole
   
   - case n°1
   
   - case n°2
   
   - case n°6
   
   - case n°8

2. Grille avec deux symboles
   
   - case n°1 : n°2
   
   - case n°1 : n°5
   
   - case n°6 : case n°3

3. Grille avec quatre symboles
   
   - cases n°1 et n°9 : n°5 et n°6
   
   - cases n°1 et n°3 : n°7 et n°9

4. Victoire au 5ème tour
   
   - cases n°1 et n°7 : cases n°4, n°5 et n°6

5. Grille remplie avec un vainqueur 
   
   - cases n°2, n°4, n°5, n°6 et n°7 : cases n°1, n°3, n°8 et n°9

6. Grille remplie sans vainqueur
   
   - cases n°1, n°3, n°5, n°6 et n°8 : cases n°2, n°4, n°7 et n°9
