package linkdata;

import standings.TeamStanding;
import standings.TeamStandingFull;
import teams.Team;

// cette classe permet de lier l'objet Team à l'objet TeamsStandings representant son classement
public class TeamStandingLinker extends DataLinker<TeamStanding, Team, String, TeamStandingFull> {

    @Override
    protected String getLeftKey(TeamStanding teamStanding) {
        return teamStanding.getConstructorId();
    }

    @Override
    protected String getRightKey(Team team) {
        return team.getId();
    }

    @Override
    protected TeamStandingFull createResult(TeamStanding teamStanding, Team team) {
        return new TeamStandingFull(team, teamStanding);
    }
}
