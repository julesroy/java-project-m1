package appdisplay;

import standings.DriverStandingFull;
import java.util.List;

public class DriversStandingsDisplay implements DisplayData {
    private final List<DriverStandingFull> standings;

    // constructeur
    public DriversStandingsDisplay(List<DriverStandingFull> standings) {
        this.standings = standings;
    }

    @Override
    public void display() {
        System.out.println("\n================================");
        System.out.printf("%-2s | %-17s | %-3s\n",
                "P",
                "Pilotes",
                "Pts"
        );
        System.out.println("--------------------------------");
        for (DriverStandingFull item : standings) {
            System.out.printf("%02d | %-17s | %3d pts\n",
                    item.driverStanding().getPositionNumber(),
                    item.driver().getFirstName() + " " + item.driver().getLastName().toUpperCase(),
                    item.driverStanding().getPoints());
        }
        System.out.println("================================\n");
    }
}