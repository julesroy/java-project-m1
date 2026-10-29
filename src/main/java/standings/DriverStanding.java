package standings;

public class DriverStanding extends Standing {
    private String driverId;

    // constructeurs
    public DriverStanding() { super(); }

    public DriverStanding(String driverId, int positionNumber, int points) {
        super(positionNumber, points);
        this.driverId = driverId;
    }

    // getters
    public String getDriverId() {
        return driverId;
    }
}
