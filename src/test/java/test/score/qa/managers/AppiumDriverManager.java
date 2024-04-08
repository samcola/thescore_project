package test.score.qa.managers;

import io.appium.java_client.AppiumDriver;
import test.score.qa.utils.ConfigPropUtils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AppiumDriverManager {

    private static final Logger logger = Logger.getLogger(AppiumDriverManager.class.getName());

    private static HashMap<Long, HashMap<String,Object>> drivers = new HashMap<Long, HashMap<String,Object>>();

    public static AppiumDriver getAppiumDriver() {

        Long desiredKey = Thread.currentThread().getId();
        for (Map.Entry<Long, HashMap<String,Object>> entry : drivers.entrySet()) {
            if (desiredKey == entry.getKey()) {
                AppiumDriver driver = (AppiumDriver) entry.getValue().get("driver");
                Map<String, Object> status = driver.getStatus();
                String pageSource = driver.getPageSource();
                if(!Objects.isNull(driver) && !Objects.isNull(driver.getStatus()) && !driver.getPageSource().isEmpty())
                    return (AppiumDriver) entry.getValue().get("driver");
                else{
                    drivers.remove(desiredKey);
                }
            }
        }

//        Get the capabilities from caps.json as DesiredCapabilities
        CapabilityManager caps = DeviceManager.getDevice();
        if (Objects.isNull(caps)) {
            logger.log(Level.SEVERE, "No capability set found for device name");
            return null;
        }

//        Starting Appium driver with URL and caps
        AppiumDriver driver = null;
        URL url = null;
        if(ConfigPropUtils.get("appium_auto_run").equals("true"))
            url = AppiumServerManager.getAppiumServerUrl();
        else {
            try {
                url = new URL("http://"+ ConfigPropUtils.get("appium_host") + ":" + ConfigPropUtils.get("appium_port")
                        + ConfigPropUtils.get("appium_path"));
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        }
        logger.log(Level.INFO, "Starting Appium Session on URL: " + url);
        driver = new AppiumDriver(url, caps.getCapabilities());
        logger.log(Level.INFO, "Successfully started session");

        HashMap<String,Object> driverMap = new HashMap<String,Object>();
        driverMap.put("device",caps.getDeviceName());
        driverMap.put("driver",driver);

        // using the current thread id to tie the drivers with the test scenario threads
        drivers.put(Thread.currentThread().getId(), driverMap);
        return driver;
    }

    public static void stopAppiumDriver() {
//        Quits the appium session
        logger.log(Level.INFO, "Quitting Appium Session");
        getAppiumDriver().quit();
    }
}
