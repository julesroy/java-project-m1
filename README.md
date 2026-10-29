# Java Project M1

---

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

### Structure du projet (packages) :

J'ai choisi de regroupé les différentes classes selon différents package pour avoir une architecture logique et simple :

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
- appdisplay/ConsoleColors.java : classe qui gere les couleurs de la console
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
- stats/StatsCalculator.java : classe qui calcule les statistiques des pilotes et des teams
- stats/DriversStatsCalculator.java : classe qui calcule les statistiques des pilotes
- stats/TeamsStatsCalculator.java : classe qui calcule les statistiques des teams

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