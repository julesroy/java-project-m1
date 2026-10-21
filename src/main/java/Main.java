import TeamMembers.*;
import Teams.*;
import tools.jackson.core.*;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();

        List<Driver> drivers = mapper.readValue(
            Path.of("src/resources/f1db-drivers.json").toFile(),
            new TypeReference<List<Driver>>(){}
        );

        for (Driver driver : drivers) {
            if (Objects.equals(driver.getId(), "charles-leclerc")) {
                System.out.println(driver.getId() + " " + driver.getFirstName() + " " + driver.getLastName() + " " + driver.getTotalPoints() + "pts");
            } else {
                System.out.println(driver.getId() + " " + driver.getFirstName() + " " + driver.getLastName());
            }
        }

        List<Team> teams = mapper.readValue(
            Path.of("src/resources/f1db-teams.json").toFile(),
            new TypeReference<List<Team>>(){}
        );

        for (Team team : teams) {
            System.out.println(team.getFullName());
        }

        List<Car> cars = mapper.readValue(
                Path.of("src/resources/f1db-cars.json").toFile(),
                new TypeReference<List<Car>>(){}
        );

        for (Car car : cars) {
            System.out.println(car.getName());
        }
    }
}
