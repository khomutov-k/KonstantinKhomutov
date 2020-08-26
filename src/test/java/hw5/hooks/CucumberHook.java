package hw5.hooks;

import hw5.driver.DriverSingleton;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class CucumberHook {

    @Before
    public void setUp() {

    }

    @After
    public void dropDown() {
        DriverSingleton.closeDriver();
    }
}
