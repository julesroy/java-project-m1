package linkdata;

import drivers.Driver;
import standings.DriverStanding;
import standings.DriverStandingFull;

// cette classe permet de lier l'objet Driver à l'objet DriversStandings representant son classement
public class DriverStandingLinker extends DataLinker<DriverStanding, Driver, String, DriverStandingFull> {

    @Override
    protected String getLeftKey(DriverStanding driverStanding) {
        return driverStanding.getDriverId();
    }

    @Override
    protected String getRightKey(Driver driver) {
        return driver.getId();
    }

    @Override
    protected DriverStandingFull createResult(DriverStanding driverStanding, Driver driver) {
        return new DriverStandingFull(driver, driverStanding);
    }
}
