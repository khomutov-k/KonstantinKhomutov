package hw5.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.regex.Pattern;

public class PropertiesHandler {

    private static final String PATH = "src/test/resources/testdataHomePage.properties";
    private static Properties propertiesInstance;

    public static Properties getProperties() {
        if (propertiesInstance != null) {
            return propertiesInstance;
        }
        try (FileInputStream input = new FileInputStream(new File(PATH))) {
            propertiesInstance = new Properties();
            propertiesInstance.load(new InputStreamReader(input,StandardCharsets.UTF_8));
            return propertiesInstance;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Set<String> getPropertySet(Properties properties, String name) {
        Set<String> result = new HashSet<>();
        for (Map.Entry<Object, Object> entry : properties.entrySet()) {
            if (((String)entry.getKey()).matches("^" + Pattern.quote(name) + "\\.\\d+$")) {
                result.add((String) entry.getValue());
            }
        }
        return result;
    }

    public static List<String> getPropertyList(Properties properties, String name) {
        List<String> result = new ArrayList<>();
        for (Map.Entry<Object, Object> entry : properties.entrySet()) {
            if (((String)entry.getKey()).matches("^" + Pattern.quote(name) + "\\.\\d+$")) {
                result.add((String) entry.getValue());
            }
        }
        return result;
    }
}
