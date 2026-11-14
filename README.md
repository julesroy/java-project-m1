# Java Project M1

---

Ce projet permet de consulter les classements et certaines statistiques de la saison 2026 de Formule 1 (jusqu'au GP de Singapour). Un comparateur de pilotes est aussi disponible.

Mon projet repose sur les éléments suivants :
- JAVA 25
- Maven
- JUnit (pour les tests unitaires)
- Jackson Tools (pour la lecture des fichiers JSON)
- [f1db](https://github.com/f1db/f1db) (base de données gratuite et open source)

NB :
- certains fichiers sont plus courts dans mon projets que dans le repo f1db car je les ai raccourci pour ne traiter que la saison 2026
- les variables / classes / méthodes etc... sont en anglais, mais les commentaires et ce readme sont entièrement rédigés en français

---

### Démarrer le projet :

Avec IntelliJ :
- ouvrir le projet dans IntelliJ
- charger les dépendances dans pom.xml
- puis ouvrir le fichier src/main/java/Main.java et cliquer sur la flèche verte pour lancer le programme.

En ligne de commande (il faut avoir mvn installé sur sa machine) :
```bash
mvn clean compile
mvn exec:java -Dexec.mainClass="Main"
```

### Structure du projet (packages) :

J'ai choisi de regrouper les différentes classes selon différents package pour avoir une architecture logique et simple :

```
src/
|----main/
   |----java/
      |----appdisplay/
      |----drivers/
      |----jsonloader/
      |----linkdata/
      |----standings
      |----stats/
      |----teams/
      |----Main.java
|----resources/
|----tests/
   |----java/
      |----jsonloader/
      |----stats/
```

---

### Détail des rôles des fichiers :

#### src/main/java :

appdisplay :
- appdisplay/MainMenu.java : classe qui gere le menu principal
- appdisplay/DisplayData.java : interface pour les classe qui affichent les données
- appdisplay/DriversDisplay.java : classe qui affiche les données des pilotes
- appdisplay/TeamsDisplay.java : classe qui affiche les données des teams
- appdisplay/DriversStandingsDisplay.java : classe qui affiche les données du classement des pilotes
- appdisplay/TeamsStandingsDisplay.java : classe qui affiche les données du classement des teams
- appdisplay/ConsoleColors.java : classe qui gere les couleurs du texte de la console
- appdisplay/exception/MainMenuChoiceException.java : exception qui gere les erreurs de choix du menu principal

drivers : 
- drivers/Driver.java : classe qui represente un pilote

jsonloader :
- jsonloader/JsonLoader.java : classe qui charge les données des fichiers JSON

linkdata : 
- linkdata/DataLinker.java : classe abstraite pour les classes qui lient les données
- linkdata/DriverStandingLinker.java : classe qui lie les données des pilotes avec les données du classement des pilotes
- linkdata/TeamCarLinker.java : classe qui lie les données des teams avec les données des voitures
- linkdata/TeamStandingLinker.java : classe qui lie les données des teams avec les données du classement des teams

standings :
- standings/Standing.java : classe mère pour les classes de classement
- standings/DriverStanding.java : classe qui represente le classement des pilotes
- standings/DriverStandingFull.java : record qui represente le classement des pilotes avec les données liées des pilotes
- standings/TeamStanding.java : classe qui represente le classement des teams
- standings/TeamStandingFull.java : record qui represente le classement des teams avec les données liées des teams

stats :
- stats/HasStats.java : interface pour les méthodes des classes qui ont des statistiques à calculer

teams :
- teams/Team.java : classe qui represente une team
- teams/Car.java : classe qui represente une voiture
- teams/TeamCar.java : record qui représente les données team et voitures liées

Main.java :  
Entrée du programme et orchestre les différentes opérations :
- charge les données
- lie les données
- lance le menu principal

#### Tests (src/test/java) :

jsonloader :
- JsonLoaderTest.java : classe qui teste le chargement des données des fichiers JSON

stats :
- HasStatsTest.java : teste les calculs effectués par l'interface HasStats

### Choix techniques :

- Classe abstraite générique (DataLinker), pour éviter d'avoir à dupliquer l'implémentation de la logique d'indexation par clé.
- Utilisation de records pour les données immuables, cela m'a permis d'éviter d'avoir à développer tout le code boilerplate (getters, setters...) pour ces données.
- Méthodes par défaut dans HasStats, comme les calculs sont identiques pour un pilote et une team, j'ai mis directement la logique de calcul dans l'interface pour ne pas dupliquer le code.

### Héritage :

- Les classes DriverStanding et TeamStanding héritent de la classe mère Standing, ce qui permet de mutualiser certains attributs comme la position au classement etc...

### Classes abstraites / interfaces :

- La classe DataLinker est abstraite, et laisse ses classes filles redéfinir ses méthodes pour récupérer les bonnes clés (polymorphisme).
- L'interface HasStats permet le calcul des stats des pilotes / teams.

### Exceptions :

- MainMenuChoiceException, permet de lever une exception si l'entier choisi par l'utilisateur est en dehors de 0 et 5.

### Chargement des données :

Au démarrage du programme, la classe JsonLoader charge les 5 fichiers suivants :
- f1db-cars.json
- f1db-drivers.json
- f1db-drivers-standings.json
- f1db-teams.json
- f1db-teams-standings.json

Ces différents fichiers sont ensuite traités pour être utilisés comme des objets Java.

### SOLID :

- S : chaque classe a une seule responsabilité (les classes de appdisplay ne gèrent que l'affichage, celles de jsonloader que le chargement des fichiers .json...)
- L : DriverStanding et TeamStanding peuvent être substituées à Standing sans problème.
- I : les interfaces HasStats et DisplayData sont courtes et précises.

### Execution des tests :

Avec IntelliJ :
- ouvrir l'un des fichiers .Java dans les dossiers de test/java/
- l'exécuter avec la flèche verte

En ligne de commande (il faut avoir mvn installé sur sa machine) :
```bash
mvn test
```