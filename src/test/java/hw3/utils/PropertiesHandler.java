package hw3.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.regex.Pattern;

public class PropertiesHandler {

    private static final String PATH = "src/test/resources/testdata.properties";

    public static Properties getProperties()  {
        try (FileInputStream input = new FileInputStream(new File(PATH))) {
            final Properties properties = new Properties();
            properties.load(new InputStreamReader(input,StandardCharsets.UTF_8));
            return properties;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Set<String> getPropertySet(Properties properties, String name) {
        //List<String> result = new ArrayList<String>();
        Set<String> result = new HashSet<>();
        for (Map.Entry<Object, Object> entry : properties.entrySet()) {
            if (((String)entry.getKey()).matches("^" + Pattern.quote(name) + "\\.\\d+$")) {
                result.add((String) entry.getValue());
            }
        }
        return result;
    }
}
