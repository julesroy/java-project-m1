package stats;

import org.junit.jupiter.api.Test;
import drivers.Driver;

import static org.junit.jupiter.api.Assertions.*;

class HasStatsTest {

    @Test
    void testStatsResult() {
        Driver driver = new Driver("fernando-alonso", "Alonso", "Fernando", 2400, 32, 106, 443);

        assertEquals(5.42, driver.getAveragePoints());
        assertEquals(0.07, driver.getWinRate());
        assertEquals(0.24, driver.getPodiumRate());
    }

    @Test
    void testZeroStats() {
        Driver rookie = new Driver("rafael-camara", "Camara", "Rafael", 0, 0, 0, 0);

        assertEquals(0.0, rookie.getAveragePoints());
        assertEquals(0.0, rookie.getWinRate());
        assertEquals(0.0, rookie.getPodiumRate());
    }
}