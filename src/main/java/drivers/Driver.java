package drivers;

public final class Driver {
    private String id;
    private String lastName;
    private String firstName;
    private int totalPoints;
    private int totalRaceWins;
    private int totalPodiums;
    private int totalRaceStarts;
    private double averagePoints;
    private double winRate;
    private double podiumRate;

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

    public int getTotalRaceWins() { return totalRaceWins; }

    public int getTotalPodiums() { return totalPodiums; }

    public int getTotalRaceStarts() { return totalRaceStarts; }

    public double getAveragePoints() { return averagePoints; }

    public double getWinRate() { return winRate; }

    public double getPodiumRate() { return podiumRate; }

    public void calculateAveragePoints() {
        this.averagePoints = (double)totalPoints / totalRaceStarts;
    }

    public void calculateWinRate() {
        if (this.totalRaceWins > 0) {
            this.winRate = (double)totalRaceWins / totalRaceStarts;
        } else  {
            this.winRate = 0.0;
        }
    }

    public void calculatePodiumRate() {
        if (this.totalPodiums > 0) {
            this.podiumRate = (double)totalPodiums / totalRaceStarts;
        } else   {
            this.podiumRate = 0.0;
        }
    }

    public void calculateStats() {
        this.calculateAveragePoints();
        this.calculateWinRate();
        this.calculatePodiumRate();
    }
}
