package standings;

public class Standing {
    private int positionNumber;
    private int points;

    public Standing() { }

    public Standing(int positionNumber, int points) {
        this.positionNumber = positionNumber;
        this.points = points;
    }

    // getters
    public int getPositionNumber() {
        return positionNumber;
    }

    public int getPoints() {
        return points;
    }
}
