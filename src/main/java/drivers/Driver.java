package drivers;

public final class Driver {
    private String id;
    private String lastName;
    private String firstName;
    private int totalPoints;
    private int totalRaceWins;
    private int totalPodiums;
    private int totalRaceStarts;

    // constructors
    public Driver() {
        super();
    }

    public Driver(String id, String lastName, String firstName, int totalPoints, int totalRaceWins, int totalPodiums, int totalRaceStarts) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.totalPoints = totalPoints;
        this.totalRaceWins = totalRaceWins;
        this.totalPodiums = totalPodiums;
        this.totalRaceStarts = totalRaceStarts;
    }

    // getters
    public String getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getTotalPoints() {
        return totalPoints;
    }
}
