# ConditionDeVictoire

## Description

Permet de déterminer si un joueur a gagné la partie. Pour cela, la méthode compare un entier avec d'autres entiers prédéfinies.

## Syntaxe

```java
public static boolean conditionDeVictoire(int entier){
    // détermine si l'entier appartient à un ensemble prédéfini
}
```

## Données

- `listePredefinie` : l'ensemble des entiers qu'on a prédéfinis

- `entier` : l'entier qui sera comparé aux entiers prédéfinis

## Tests

1. Entier compris entre 1 et 512

2. Condition non vérifiée
   
   > entier = 1, 2, 3, 10, 25, 400

3. Condition vérifiée
   
   > entier = 73, 146, 292, 7, 56, 448, 273, 84

4. Avec un test aléatoire

---

## Formalisme de la méthode

1. Si l'ensemble contient cet entier, la condition est vérifiée

2. Si l'ensemble ne contient pas cet entier, la condition n'est pas vérifiée
