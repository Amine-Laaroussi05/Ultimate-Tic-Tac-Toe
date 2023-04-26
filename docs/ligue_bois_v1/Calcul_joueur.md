# Calcul_joueur

## Description

Permet d'assigner à un joueur un entier qui encode la position des symboles joués du joueur.

## Syntaxe

```java
public static void calculJoueur(int rowCoord, int colCoord,){
    // Opérations sur les coordonnées permettant d'en déduire un entier
}
```

## Données

- `rowCoord` : La coordonnée de ligne saisie par le joueur

- `colCoord` : La coordonnée de colonne saisie par le joueur

- `entierJoueur` : l'entier affecté au joueur encodant les précédents calculs et qui sera mis à jour dans la méthode

## Tests

1. Coordonnée non valide

2. Position symbole déjà prise

3. Échantillon de tests

4. Avec un test aléatoire

---

## Description détaillée

1. Enclenchement d'une condition selon la valeur de `colCoord` : 0, 1 ou 2

2. Somme de `rowCoord` avec `colCoord`

3. À cette somme, on ajoute 0, 2 ou 4 selon la condition

4. On met finalement à jour le paramètre `entierJoueur` en lui ajoutant la valeur `2^(cette somme)`
