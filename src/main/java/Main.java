import jsonloader.JsonLoader;
import linkdata.*;
import standings.*;
import teammembers.*;
import teams.*;
import tools.jackson.core.type.TypeReference;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Driver> drivers = JsonLoader.loadList("/f1db-drivers.json", new TypeReference<List<Driver>>() {});
        List<Car> cars = JsonLoader.loadList("/f1db-cars.json", new TypeReference<List<Car>>() {});
        List<Team> teams = JsonLoader.loadList("/f1db-teams.json", new TypeReference<List<Team>>() {});
        List<DriverStanding> driversStandings = JsonLoader.loadList("/f1db-drivers-standings.json", new TypeReference<List<DriverStanding>>() {});

        DriverStandingLinker driverStandingLinker = new DriverStandingLinker();
        List<DriverStandingFull> driverStandingFulls = driverStandingLinker.link(driversStandings, drivers);

        TeamCarLinker teamCarLinker = new TeamCarLinker();
        List<TeamCar> teamCars = teamCarLinker.link(teams, cars);

        for (DriverStandingFull driverStandingFull : driverStandingFulls) {
            System.out.println(driverStandingFull.driverStanding().getPositionNumber() + ". " + driverStandingFull.driver().getLastName() + " : " + driverStandingFull.driverStanding().getPoints() + "pts");
        }

        for (TeamCar teamCar : teamCars) {
            System.out.println(teamCar.team().getFullName() + " : " + teamCar.car().getName());
        }
    }
}
