package appdisplay;

import standings.DriverStandingFull;
import teams.TeamCar;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MainMenu implements DisplayData {
    private final List<DriverStandingFull> driverStandingFulls;
    private final List<TeamCar> teamCars;

    public MainMenu(List<DriverStandingFull> driverStandingFulls, List<TeamCar>teamCars) {
        this.driverStandingFulls = driverStandingFulls;
        this.teamCars = teamCars;
    }

    @Override
    public void display() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("=== MENU PRINCIPAL F1 ===");
            System.out.println("1. Voir le classement des pilotes");
            System.out.println("2. Voir les écuries et leurs voitures");
            System.out.println("0. Quitter");
            System.out.print("Entrez votre choix : ");

            int choice = -1;
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.err.println("Erreur : vous devez entrer un nombre entier.");
                scanner.nextLine(); // vide le buffer
                continue;
            }

            switch (choice) {
                case 1 -> new DriversStandingsDisplay(driverStandingFulls).display();
                case 0 -> {
                    System.out.println("Au revoir !");
                    running = false;
                }
                default -> System.out.println("Option inconnue, veuillez réessayer.");
            }
        }
    }
}