package drivers;

import stats.HasStats;

public final class Driver implements HasStats {
    private String id;
    private String lastName;
    private String firstName;
    private int totalPoints;
    private int totalRaceWins;
    private int totalPodiums;
    private int totalRaceStarts;

    // constructeurs
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
        return this.id;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    @Override
    public int getTotalPoints() { return this.totalPoints; }

    @Override
    public int getTotalRaceWins() { return this.totalRaceWins; }

    @Override
    public int getTotalPodiums() { return this.totalPodiums; }

    @Override
    public int getTotalRaceStarts() { return this.totalRaceStarts; }
}
