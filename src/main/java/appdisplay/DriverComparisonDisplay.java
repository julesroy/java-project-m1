package appdisplay;

import standings.DriverStandingFull;

public class DriverComparisonDisplay implements DisplayData {
    private DriverStandingFull firstDriver;
    private DriverStandingFull secondDriver;

    public DriverComparisonDisplay(DriverStandingFull firstDriver, DriverStandingFull secondDriver) {
        this.firstDriver = firstDriver;
        this.secondDriver = secondDriver;
    }

    @Override
    public void display() {
        System.out.println("\n=========================================================");
        System.out.printf("%-15s | %-17s | %-17s \n",
                "Categorie",
                "Pilote 1",
                "Pilote 2"

        );
        System.out.println("---------------------------------------------------------");
        System.out.printf("%-15s | %-17s | %-17s \n",
                "Nom / prénom",
                firstDriver.driver().getLastName().toUpperCase() + " " + firstDriver.driver().getFirstName(),
                secondDriver.driver().getLastName().toUpperCase() + " " + secondDriver.driver().getFirstName()
                );
        System.out.printf("%-15s | %-17s | %-17s \n",
                "Rang (2026)",
                firstDriver.driverStanding().getPositionNumber(),
                secondDriver.driverStanding().getPositionNumber()
        );
        System.out.printf("%-15s | %-17s | %-17s \n",
                "Points (2026)",
                firstDriver.driverStanding().getPoints(),
                secondDriver.driverStanding().getPoints()
        );

        System.out.printf("%-15s | %-17s | %-17s \n",
                "Total courses",
                firstDriver.driver().getTotalRaceStarts(),
                secondDriver.driver().getTotalRaceStarts()
        );

        System.out.printf("%-15s | %-17s | %-17s \n",
                "Total podiums",
                firstDriver.driver().getTotalPodiums(),
                secondDriver.driver().getTotalPodiums()
        );

        System.out.printf("%-15s | %-17s | %-17s \n",
                "Total victoires",
                firstDriver.driver().getTotalRaceWins(),
                secondDriver.driver().getTotalRaceWins()
        );

        System.out.printf("%-15s | %-17s | %-17s \n",
                "Moyenne points",
                firstDriver.driver().getAveragePoints(),
                secondDriver.driver().getAveragePoints()
        );

        System.out.printf("%-15s | %-17s | %-17s \n",
                "% de podiums",
                firstDriver.driver().getPodiumRate(),
                secondDriver.driver().getPodiumRate()
        );

        System.out.printf("%-15s | %-17s | %-17s \n",
                "% de victoires",
                firstDriver.driver().getWinRate(),
                secondDriver.driver().getWinRate()
        );
        System.out.println("=========================================================\n");
    }
}
