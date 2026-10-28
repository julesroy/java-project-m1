package appdisplay;

import standings.TeamStandingFull;
import teams.TeamCar;

import java.util.List;

public class TeamsDisplay implements DisplayData {
    private final List<TeamCar> teamCars;

    public TeamsDisplay(List<TeamCar> teamCars) {
        this.teamCars = teamCars;
    }

    @Override
    public void display() {
        System.out.println("\n============================== Teams ================================");
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