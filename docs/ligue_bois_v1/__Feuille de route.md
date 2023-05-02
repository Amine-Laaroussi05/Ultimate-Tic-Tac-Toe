# __Feuille de route

## Fonctionnement du tour de jeu

À chaque tour de jeu, le joueur ou le joueur adverse saisissent deux entiers désignant la coordonnée de la ligne et la  coordonnée de la colonne où ils vont placer leur symbole de jeu.

## Paramètres de jeu

### Entrées pour un tour de jeu

- `oponnentRow` : la coordonnée de la ligne saisi par l'adversaire dans le tour précédent

- `oponnentCol` : la coordonnée de la colonne saisi par l'adversaire dans le tour précédent

- `validActionCount` : le nombre d'action valides pour ce tour de jeu

### Sorties pour un tour de jeu

- `row` : la coordonnée de la ligne

- `col` : la coordonnée de la colonne 

---

## Stratégie de développement

1. Boucle de jeu pour le lancement des tours

2. Arrêt de la boucle en cas d'alignement de 3 symboles identiques **ou** si le nombre d'actions a été réduit à 0

3. Début de tour : saisi du joueur des entiers **row** et **col**

4. Vérification que les entiers saisis sont valides

5. Application de la méthode `calculJoueur`  

6. Détermination de la condition de victoire (en appliquant les méthodes `conditionVictoire` et `positionSymboles`)

7. Illustration du jeu

8. Vérification du nombre d'actions restants

9. Suppression des actions jouées par le joueur ou l'adversaire durant ce tour du nombre d'actions valides

## Notes de correction

- Méthode pour vérifier que les coordonnées saisies n'ont pas été saisies précédemment par un autre joueur ou lors d'un tour ultérieur

> Nouvelle méthode `coordonneesValides`

- Prise en compte des paramètres `entierJoueur1` et `entierJoueur2` de leur valeur précédente

> `+=` au lieu d'un `=` dans la méthode main()

- Amélioration de la méthode `conditionVictoire` qui ne considérait pas la possibilité d'avoir 4 symboles dont 3 alignés.

## Étape suivante envisagée

1. Analyse du jeu de l'adversaire et saisi d'entiers convenables à la situation de jeu

2. Mise en test avec un mode de jeu aléatoire de l'adversaire

3. Adaptation au coding game
