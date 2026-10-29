package appdisplay;

import standings.TeamStandingFull;
import java.util.List;

public class TeamsStandingsDisplay implements DisplayData {
    private final List<TeamStandingFull> standings;

    // constructeur
    public TeamsStandingsDisplay(List<TeamStandingFull> standings) {
        this.standings = standings;
    }

    @Override
    public void display() {
        System.out.println("\n===========================");
        System.out.printf("%-2s | %-12s | %-3s\n",
                "P",
                "Team",
                "Pts"
        );
        System.out.println("---------------------------");
        for (TeamStandingFull item : standings) {
            System.out.printf("%02d | %-12s | %3d pts\n",
                    item.teamStanding().getPositionNumber(),
                    item.team().getName(),
                    item.teamStanding().getPoints());
        }
        System.out.println("===========================\n");
    }
}