# Calculus

Générateur de questions :

la classe Calculation possède plusieurs attributs dont une difficulté.
la classe Game possède en attribut une liste de Calculation.
Lorsque que l'on crée un instance de Game, on spécifie la difficulté (1:facile, 2:moyen, 3:difficile) et le nombre de calculs.
Une boucle va créer X caculs et les insérer dans la liste de Game.

les questions sont générées dans les fct createEasy, createMedium et createHard.
ces fonctions retourne une liste contenant : 1: String de l'équation, par exemple "3 + 6 = ?"
                                             2: Resultat de l'équation.

Facile: addition et soustraction seulement. Pas de résultat négatif aux soustractions. nombres  compris entre 1 et 20

Moyen: addition, soustraction, multiplication. Résultats négatifs et positifs aux soustractions. nombres compris entre 1 et 35 pour addition/soustraction et entre 2 et 12 pour multiplication.

Difficile: addition,soustraction multiplication, division. Résultats négatifs et positifs aux soustractions. nombres compris entre 1 et 49 pour addition/soustraction/division et entre 3 et 14 pour multiplication. Divisions entières uniquement.

Générateur de réponses :
on crée les choix avec les fct easyChoice, mediumChoice, hardChoice.
Elles prennent la réponse à un calcul en parametre. 

Facile: les choix sont éloignés de 4 à 9 unités par rapport à la bonne réponse.
Moyen: les choix sont éloignés de 2 à 8 unités par rapport à la bonne réponse.
Difficile: les choix sont éloignés de 1 à 4 unités par rapport à la bonne réponse.

pas de doublons dans les choix.


