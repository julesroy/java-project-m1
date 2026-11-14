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
            double averagePoints = (double)getTotalPoints() / getTotalRaceStarts();
            averagePoints = Math.round(averagePoints * 100.0) / 100.0;
            return averagePoints;
        }
    }

    default int getWinRate() {
        if (getTotalRaceWins() == 0 || getTotalRaceStarts() == 0) {
            return 0;
        } else {
            double winRate = (double)getTotalRaceWins() / getTotalRaceStarts();
            winRate = Math.round(winRate * 100.0);
            return (int)winRate;
        }
    }

    default int getPodiumRate() {
        if (getTotalPodiums() == 0 || getTotalRaceStarts() == 0)   {
            return 0;
        } else {
            double podiumRate = (double)getTotalPodiums() / getTotalRaceStarts();
            podiumRate = Math.round(podiumRate * 100.0);
            return (int)podiumRate;
        }
    }
}
