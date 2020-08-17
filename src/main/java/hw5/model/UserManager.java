package hw5.model;

import hw5.utils.PropertiesHandler;

import java.util.Properties;

public class UserManager {

    private static Properties props = PropertiesHandler.getProperties();

    public static User getDefaultUserFromProperties() {
        String username = props.getProperty("user.username");
        String password = props.getProperty("user.password");
        return new User(username,password);
    }

    public static User getBlankUser() {
        return new User("","");
    }
}
