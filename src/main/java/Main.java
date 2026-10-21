import teammembers.*;
import teams.*;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.*;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();

        List<Driver> drivers = mapper.readValue(
            Main.class.getResourceAsStream("/f1db-drivers.json"),
            new TypeReference<List<Driver>>(){}
        );

        List<Car> cars = mapper.readValue(
                Main.class.getResourceAsStream("/f1db-cars.json"),
                new TypeReference<List<Car>>(){}
        );

        List<Team> teams = mapper.readValue(
                Main.class.getResourceAsStream("/f1db-teams.json"),
                new TypeReference<List<Team>>(){}
        );

        Map<String, Car> carsByConstructor = cars.stream()
                .collect(Collectors.toMap(Car::getConstructorId, car -> car, (car1, car2) -> car1)); // permet de supprimer les doublons

        for (Team team : teams) {
            Car car = carsByConstructor.get(team.getId());
            if (car != null) {
                team.setCar(car);
                System.out.println(team.getFullName() + ", " + car.getName());
            } else {
                System.out.println(team.getFullName() + ", aucune voiture pour cette ecurie");
            }
        }
    }
}
