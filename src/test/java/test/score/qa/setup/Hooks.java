package test.score.qa.setup;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import test.score.qa.managers.AppiumDriverManager;
import test.score.qa.managers.AppiumServerManager;
import test.score.qa.utils.ConfigPropUtils;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Hooks {
    private static final Logger logger = Logger.getLogger(Hooks.class.getName());

    @BeforeAll
    public static void setup() throws IOException {
        if (ConfigPropUtils.get("appium_auto_run").equals("true"))
            AppiumServerManager.startAppiumServer();
        else {
            AppiumServerManager.host = ConfigPropUtils.get("appium_host");
            AppiumServerManager.port = Integer.parseInt(ConfigPropUtils.get("appium_port"));
            logger.log(Level.INFO, "Using existing appium service at " + AppiumServerManager.host + ":" + AppiumServerManager.port);
        }
    }

//    @After
//    public static void cleanUpAfterTestScenario(Scenario scenario) {
//        AppiumDriverManager.stopAppiumDriver();
//    }

    @AfterAll
    public static void cleanUp() {
        try {
            AppiumDriverManager.stopAppiumDriver();
            if (ConfigPropUtils.get("appium_auto_run").equals("true")) {
                AppiumServerManager.stopAppiumServer();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
