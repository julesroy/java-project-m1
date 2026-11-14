package appdisplay;

import java.util.List;
import teams.TeamCar;

public class TeamsDisplay implements DisplayData {
    private final List<TeamCar> teamCars;

    // constructeur
    public TeamsDisplay(List<TeamCar> teamCars) {
        this.teamCars = teamCars;
    }

    @Override
    public void display() {
        System.out.println("\n===========================================================================================");
        System.out.printf("%-31s | %-8s | %-4s | %-5s | %-3s | %-3s | %-9s | %-2s | %-2s\n",
                "Teams",
                "Car",
                "C",
                "Pts",
                "P",
                "V",
                "Moy. pts",
                "%P",
                "%V"
        );
        System.out.println("-------------------------------------------------------------------------------------------");
        for (TeamCar item : teamCars) {
            System.out.printf("%-31s | %-8s | %4d | %5d | %3d | %3d | %5.2f pts | %2d | %2d\n",
                    item.team().getFullName(),
                    item.car().getName(),
                    item.team().getTotalRaceStarts(),
                    item.team().getTotalPoints(),
                    item.team().getTotalPodiums(),
                    item.team().getTotalRaceWins(),
                    item.team().getAveragePoints(),
                    item.team().getPodiumRate(),
                    item.team().getWinRate()
            );
        }
        System.out.println("===========================================================================================\n");
    }
}