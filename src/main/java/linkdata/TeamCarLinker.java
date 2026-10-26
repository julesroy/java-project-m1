package linkdata;

import teams.Car;
import teams.Team;
import teams.TeamCar;

// cette classe permet de lier l'objet Team à l'objet Car, ainsi chaque ecurie à sa voiture
public class TeamCarLinker extends DataLinker<Team, Car, String, TeamCar> {

    @Override
    protected String getLeftKey(Team team) {
        return team.getId();
    }

    @Override
    protected String getRightKey(Car car) {
        return car.getConstructorId();
    }

    @Override
    protected TeamCar createResult(Team team, Car car) {
        return new TeamCar(team, car);
    }
}
