package appdisplay;

import standings.DriverStandingFull;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static appdisplay.ConsoleColors.RED;
import static appdisplay.ConsoleColors.RESET;

public class DriverComparisonChoice implements DisplayData {
    private final List<DriverStandingFull> driverStandingFulls;

    public DriverComparisonChoice(List<DriverStandingFull> driverStandingFulls) {
        this.driverStandingFulls = driverStandingFulls;
    }

    public void exitComparisonMode() {
        System.out.println("Sortie du mode comparaison, retour au menu\n");
    }

    @Override
    public void display() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true; // indique si le programme est en train de tourner

        while (running) {
            String firstDriverName = "";
            String secondDriverName = "";
            DriverStandingFull firstDriver = null;
            DriverStandingFull secondDriver = null;

            System.out.println("\nEntrez les noms uniquement sans tenir compte de la casse, entrez 0 pour annuler");

            try {
                System.out.print("Entrez le nom du premier pilote : ");
                firstDriverName = scanner.nextLine();

                if (firstDriverName.equals("0")) {
                    this.exitComparisonMode();
                    return;
                }

                System.out.print("Entrez le nom du second pilote : ");
                secondDriverName = scanner.nextLine();

                if (secondDriverName.equals("0")) {
                    this.exitComparisonMode();
                    return;
                }

                for (DriverStandingFull driverStandingFull : driverStandingFulls) {
                    if (driverStandingFull.driver().getLastName().equalsIgnoreCase(firstDriverName)) {
                        firstDriver = driverStandingFull;
                    }
                    if (driverStandingFull.driver().getLastName().equalsIgnoreCase(secondDriverName)) {
                        secondDriver = driverStandingFull;
                    }
                }

                if (firstDriver == null || secondDriver == null) {
                    System.out.println(
                            RED + "Erreur : au moins un des pilotes n'a pas été trouvé" + RESET
                    );
                    continue;
                }

                new DriverComparisonDisplay(firstDriver, secondDriver).display();
                running = false;

            } catch (InputMismatchException e) {
                System.out.println("\n" + RED + "Erreur de saisie" + RESET + "\n");
                scanner.nextLine();
            }
        }
    }
}
