package appdisplay;

import static appdisplay.ConsoleColors.*;
import appdisplay.exception.MainMenuChoiceException;
import drivers.Driver;
import standings.DriverStandingFull;
import standings.TeamStandingFull;
import teams.TeamCar;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MainMenu implements DisplayData {
    private final List<DriverStandingFull> driverStandingFulls;
    private final List<TeamStandingFull> teamStandingFulls;
    private final List<Driver> drivers;
    private final List<TeamCar> teamCars;

    // constructeur
    public MainMenu(List<DriverStandingFull> driverStandingFulls, List<TeamStandingFull> teamStandingFulls, List<Driver>drivers, List<TeamCar>teamCars) {
        this.driverStandingFulls = driverStandingFulls;
        this.teamStandingFulls = teamStandingFulls;
        this.drivers = drivers;
        this.teamCars = teamCars;
    }

    @Override
    public void display() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true; // indique si le programme est en train de tourner

        while (running) {
            System.out.println("====== Menu F1 Projet Java ======");
            System.out.println("1. Voir le classement des pilotes");
            System.out.println("2. Voir le classement des teams");
            System.out.println("3. Voir les pilotes en detail");
            System.out.println("4. Voir les teams en detail");
            System.out.println("0. Quitter");
            System.out.print("Entrez votre choix : ");

            int choice = -1; // stocke le choix de fonctionnalité
            try {
                if (!scanner.hasNextInt()) {
                    // si la valeur entrée n'est pas un entier
                    throw new InputMismatchException();
                }
                choice = scanner.nextInt();

                if (choice < 0 || choice > 4) {
                    // si la valeur n'est pas entre 0 et 4
                    throw new MainMenuChoiceException();
                }
            } catch (InputMismatchException e) {
                System.out.println("\n" + RED + "Erreur : Le nombre choisi doit être un entier entre 0 et 4" + RESET + "\n");
                scanner.nextLine();
                continue;
            } catch (MainMenuChoiceException e) {
                System.out.println("\n" + RED + "Erreur : " + e.getMessage() + RESET + "\n");
                scanner.nextLine();
                continue;
            }

            if (choice == 0) {
                System.out.println(GREEN + "Arret du programme..." + RESET);
                running = false; // on sort de la boucle while
            } else if (choice == 1) {
                new DriversStandingsDisplay(driverStandingFulls).display();
            } else if (choice == 2) {
                new TeamsStandingsDisplay(teamStandingFulls).display();
            } else if (choice == 3) {
                new DriversDisplay(drivers).display();
            } else if (choice == 4) {
                new TeamsDisplay(teamCars).display();
            }
        }
    }
}