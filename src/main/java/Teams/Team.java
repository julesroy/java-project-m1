package Teams;

public class Team {
    private String id;
    private String fullName;
    private Car car;

    // constructors
    public Team() {}

    public Team(String id, String fullName, Car car) {
        this.id = id;
        this.fullName = fullName;
        this.car = car;
    }

    // getters
    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }
}
