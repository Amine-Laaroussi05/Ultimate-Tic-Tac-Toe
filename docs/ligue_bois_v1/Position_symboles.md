## Position_symboles

## Description

Détermine la position des symboles joués par le joueur à partir de l'entier affecté à ce dernier.

## Syntaxe

```java
public static Arraylist[Integer] positionSymboles(int entierJoueur){
    // Factorisation de l'entier en une somme de 2^n
}
```

## Données

- `entierJoueur` : l'entier affecté au joueur et dont sera déduit les positions des symboles joués par le joueur

- `listeEmplacement` : La liste des emplacments des symboles joués par le joueur

> La notation des emplacements est donnée comme suit : À partir d'un carré 3x3,  le numéro de la case en haut à gauche est 0 tandis que le numéro de la case en bas à droite est 8.

## Tests

- Entier valide 

> doit se situer entre 0 et 512

- Entier nul

- Un emplacement

- Deux emplacements

- Trois emplacements

- Quatre emplacements

- Test aléatoire

---

## Description détaillée

1. Lancement d'une boucle qui appliquera une série de division par 2 de l'entier

2. Arrêt de la boucle si l'entier obtenu n'est pas divisible par 2 (entier impair)

3. Calcul du nombre de fois où l'entier a été divisé par 2

4. Détermine le dernier entier (après la série de division) qui est impair et lui applique à nouveau cette boucle

5. Arrêt de la boucle une fois que l'entier obtenu est égal à 1

6. Calcul à partir de ces données de la somme en 2^n obtenue

7. Déduction des emplacements et sauvegarde du résultat dans la liste `listeEmplacement`
