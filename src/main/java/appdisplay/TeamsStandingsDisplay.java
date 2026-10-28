package appdisplay;

import standings.TeamStandingFull;
import java.util.List;

public class TeamsStandingsDisplay implements DisplayData {
    private final List<TeamStandingFull> standings;

    public TeamsStandingsDisplay(List<TeamStandingFull> standings) {
        this.standings = standings;
    }

    @Override
    public void display() {
        System.out.println("\n========== Classement des teams ==========");
        for (TeamStandingFull item : standings) {
            System.out.printf("%2d. %-15s : %3d pts%n",
                    item.teamStanding().getPositionNumber(),
                    item.team().getName(),
                    item.teamStanding().getPoints());
        }
        System.out.println("============================================\n");
    }
}