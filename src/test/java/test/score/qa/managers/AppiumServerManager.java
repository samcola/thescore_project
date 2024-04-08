package test.score.qa.managers;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import test.score.qa.utils.ConfigPropUtils;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

import static io.appium.java_client.service.local.flags.GeneralServerFlag.*;

public class AppiumServerManager {

    public static int port = 4723;
    public static String host = "localhost";

    private static final Logger logger = Logger.getLogger(AppiumServerManager.class.getName());

    static AppiumDriverLocalService service;

    public static void startAppiumServer() throws IOException {
//        Get host and port from config.props using ConfigPropUtils class
        host = ConfigPropUtils.get("appium_host");
        port = ConfigPropUtils.getPort();
        logger.log(Level.INFO, "Starting Appium server at " + host + ":" + port);
//        Using host and port to start the appium server
        service = new AppiumServiceBuilder()
                .usingPort(port)
                .withArgument(LOG_LEVEL, "info")
                .withArgument(SESSION_OVERRIDE)
                .withArgument(BASEPATH, ConfigPropUtils.get("appium_path"))
                .build();
        service.start();
    }

    public static void stopAppiumServer() throws IOException {
//        Stops appium server
        logger.log(Level.INFO, "Stopping Appium server at " + host + ":" + port);
        if(!Objects.isNull(service)) {
            service.stop();
        }
    }

    public static URL getAppiumServerUrl() {
        return service.getUrl();
    }

}
