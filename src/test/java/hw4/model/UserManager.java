package hw4.model;

import java.util.Properties;

public class UserManager {

    public static User createDefaultUserFromProperties(Properties props) {
        String username = props.getProperty("user.username");
        String password = props.getProperty("user.password");
        return new User(username,password);
    }

    public static User createBlankUser() {
        return new User("","");
    }
}
