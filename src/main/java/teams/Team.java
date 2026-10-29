package teams;

import stats.HasStats;

public class Team implements HasStats {
    private String id;
    private String fullName;
    private String name;
    private int totalPoints;
    private int totalRaceWins;
    private int totalPodiums;
    private int totalRaceStarts;

    // constructeurs
    public Team() {}

    public Team(String id, String fullName, String name, int totalPoints, int totalRaceWins, int totalPodiums, int totalRaceStarts) {
        this.id = id;
        this.fullName = fullName;
        this.name = name;
        this.totalPoints = totalPoints;
        this.totalRaceWins = totalRaceWins;
        this.totalPodiums = totalPodiums;
        this.totalRaceStarts = totalRaceStarts;
    }

    // getters
    public String getId() {
        return this.id;
    }

    public String getFullName() {
        return this.fullName;
    }

    public String getName() { return this.name; }

    @Override
    public int getTotalPoints() { return this.totalPoints; }

    @Override
    public int getTotalRaceWins() { return this.totalRaceWins; }

    @Override
    public int getTotalPodiums() { return this.totalPodiums; }

    @Override
    public int getTotalRaceStarts() { return this.totalRaceStarts; }
}
