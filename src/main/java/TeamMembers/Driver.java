package TeamMembers;

public final class Driver extends TeamMembers {
    private int totalPoints;
    private int totalRaceWins;
    private int totalPodiums;
    private int totalRaceStarts;

    // constructors
    public Driver() {
        super();
    }

    public Driver(String id, String lastName, String firstName, int totalPoints, int totalRaceWins, int totalPodiums, int totalRaceStarts) {
        super(id, lastName, firstName);
        this.totalPoints = totalPoints;
        this.totalRaceWins = totalRaceWins;
        this.totalPodiums = totalPodiums;
        this.totalRaceStarts = totalRaceStarts;
    }

    // getters
    public int getTotalPoints() {
        return totalPoints;
    }
}
