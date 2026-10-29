package appdisplay;

import java.util.List;
import teams.TeamCar;

public class TeamsDisplay implements DisplayData {
    private final List<TeamCar> teamCars;

    public TeamsDisplay(List<TeamCar> teamCars) {
        this.teamCars = teamCars;
    }

    @Override
    public void display() {
        System.out.println("\n=====================================================================");
        System.out.printf("%-31s | %-8s | %-4s | %-3s | %-3s | %-5s%n",
                "Teams",
                "Car",
                "C",
                "V",
                "P",
                "Pts"
        );
        System.out.println("---------------------------------------------------------------------");
        for (TeamCar item : teamCars) {
            System.out.printf("%-31s | %-8s | %4d | %3d | %3d | %5d%n",
                    item.team().getFullName(),
                    item.car().getName(),
                    item.team().getTotalRaceStarts(),
                    item.team().getTotalRaceWins(),
                    item.team().getTotalPodiums(),
                    item.team().getTotalPoints()
            );
        }
        System.out.println("=====================================================================\n");
    }
}