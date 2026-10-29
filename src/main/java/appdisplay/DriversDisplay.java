package appdisplay;

import java.util.List;
import drivers.Driver;

public class DriversDisplay implements DisplayData {
    private final List<Driver> drivers;

    // constructeur
    public DriversDisplay(List<Driver> drivers) {
        this.drivers = drivers;
    }

    @Override
    public void display() {
        System.out.println("\n========================================================================");
        System.out.printf("%-17s | %-3s | %-8s | %-3s | %-3s | %-9s | %-4s | %-4s\n",
                "Pilotes",
                "C",
                "Pts",
                "P",
                "V",
                "Moy. pts",
                "%P",
                "%V"
                );
        System.out.println("------------------------------------------------------------------------");
        for (Driver item : drivers) {
            System.out.printf("%-17s | %3d | %4d pts | %3d | %3d | %5.2f pts | %2.2f | %2.2f\n",
                    item.getLastName().toUpperCase() + " " + item.getFirstName(),
                    item.getTotalRaceStarts(),
                    item.getTotalPoints(),
                    item.getTotalPodiums(),
                    item.getTotalRaceWins(),
                    item.getAveragePoints(),
                    item.getPodiumRate(),
                    item.getWinRate()
            );
        }
        System.out.println("========================================================================\n");
    }
}
