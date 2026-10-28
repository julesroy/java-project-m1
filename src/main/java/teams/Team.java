package teams;

public class Team {
    private String id;
    private String fullName;
    private String name;
    private int totalPoints;
    private int totalRaceWins;
    private int totalPodiums;
    private int totalRaceStarts;

    // constructors
    public Team() {}

    public Team(String id, String fullName, String name) {
        this.id = id;
        this.fullName = fullName;
        this.name = name;
    }

    // getters
    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getName() { return name; }

    public int getTotalPoints() { return totalPoints; }

    public int getTotalRaceWins() { return totalRaceWins; }

    public int getTotalPodiums() { return totalPodiums; }

    public int getTotalRaceStarts() { return totalRaceStarts; }
}
