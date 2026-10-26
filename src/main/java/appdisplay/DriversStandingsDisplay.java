package appdisplay;

import standings.DriverStandingFull;
import java.util.List;

public class DriversStandingsDisplay implements DisplayData {
    private final List<DriverStandingFull> standings;

    public DriversStandingsDisplay(List<DriverStandingFull> standings) {
        this.standings = standings;
    }

    @Override
    public void display() {
        System.out.println("\n========== Classement des pilotes ==========");
        for (DriverStandingFull item : standings) {
            System.out.printf("%2d. %-15s : %3d pts%n",
                    item.driverStanding().getPositionNumber(),
                    item.driver().getLastName(),
                    item.driverStanding().getPoints());
        }
        System.out.println("============================================\n");
    }
}