package jsonloader;

import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.util.List;

public class JsonLoader {
    private static final ObjectMapper mapper = new ObjectMapper();

    public static <T> List<T> loadList(String path, TypeReference<List<T>> typeReference) {
        try (InputStream is = JsonLoader.class.getResourceAsStream(path)) {
            if (is == null) {
                throw new IllegalArgumentException("Resource not available : " + path);
            }
            return mapper.readValue(is, typeReference);
        } catch (Exception e) {
            throw new RuntimeException("Error while reading file : " + path, e);
        }
    }
}
