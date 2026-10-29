package jsonloader;

import drivers.Driver;
import org.junit.jupiter.api.Test;
import tools.jackson.core.type.TypeReference;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JsonLoaderTest {

    @Test
    void testLoadFileSuccess() {
        List<Driver> drivers = JsonLoader.loadList("/f1db-drivers.json", new TypeReference<List<Driver>>() {});

        assertNotNull(drivers);
        assertFalse(drivers.isEmpty());
        assertNotNull(drivers.getFirst().getId());
    }

    @Test
    void testLoadFileErrorThrowsException() {
        assertThrows(RuntimeException.class, () -> {
            JsonLoader.loadList("/je-n-existe-pas.json", new TypeReference<List<Driver>>() {});
        });
    }
}