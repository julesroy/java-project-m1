package stats;

public interface HasStats {
    int getTotalPoints();
    int getTotalRaceWins();
    int getTotalPodiums();
    int getTotalRaceStarts();

    default double getAveragePoints() {
        if (getTotalPoints() == 0 || getTotalRaceStarts() == 0) {
            return 0.0;
        } else {
            return (double)getTotalPoints() / getTotalRaceStarts();
        }
    }

    default double getWinRate() {
        if (getTotalRaceWins() == 0 || getTotalRaceStarts() == 0) {
            return 0.0;
        } else {
            return (double)getTotalRaceWins() / getTotalRaceStarts();
        }
    }

    default double getPodiumRate() {
        if (getTotalPodiums() == 0 || getTotalRaceStarts() == 0)   {
            return 0.0;
        } else {
            return (double)getTotalPodiums() / getTotalRaceStarts();
        }
    }
}
