import appdisplay.MainMenu;
import jsonloader.JsonLoader;
import linkdata.*;
import standings.*;
import drivers.*;
import teams.*;
import tools.jackson.core.type.TypeReference;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Driver> drivers = JsonLoader.loadList("/f1db-drivers.json", new TypeReference<List<Driver>>() {});
        List<Car> cars = JsonLoader.loadList("/f1db-cars.json", new TypeReference<List<Car>>() {});
        List<Team> teams = JsonLoader.loadList("/f1db-teams.json", new TypeReference<List<Team>>() {});
        List<DriverStanding> driversStandings = JsonLoader.loadList("/f1db-drivers-standings.json", new TypeReference<List<DriverStanding>>() {});
        List<TeamStanding> teamsStandings = JsonLoader.loadList("/f1db-teams-standings.json", new TypeReference<List<TeamStanding>>() {});

        for (Driver driver : drivers) {
            driver.calculateStats();
        }

        DriverStandingLinker driverStandingLinker = new DriverStandingLinker();
        List<DriverStandingFull> driverStandingFulls = driverStandingLinker.link(driversStandings, drivers);

        TeamStandingLinker teamStandingLinker = new TeamStandingLinker();
        List<TeamStandingFull> teamStandingFulls = teamStandingLinker.link(teamsStandings, teams);

        TeamCarLinker teamCarLinker = new TeamCarLinker();
        List<TeamCar> teamCars = teamCarLinker.link(teams, cars);

        MainMenu mainMenu = new MainMenu(driverStandingFulls, teamStandingFulls, drivers, teamCars);
        mainMenu.display();
    }
}
