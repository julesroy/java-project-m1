package standings;

public class TeamStanding extends Standing {
    private String constructorId;

    public TeamStanding() { super(); }

    public TeamStanding(String constructorId, int positionNumber, int points) {
        super(positionNumber, points);
        this.constructorId = constructorId;
    }

    //getters
    public String getConstructorId() {
        return constructorId;
    }
}
