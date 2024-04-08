package test.score.qa.managers;

import org.openqa.selenium.remote.DesiredCapabilities;
import test.score.qa.utils.CapsReaderUtil;
import test.score.qa.utils.ConfigPropUtils;

import java.util.logging.Level;
import java.util.logging.Logger;

public class DeviceManager {

    private static final Logger logger = Logger.getLogger(DeviceManager.class.getName());

    public static CapabilityManager getDevice() {
        String deviceName = ConfigPropUtils.get("device_name");
        logger.log(Level.INFO, "Getting capabilities for device Name: " + deviceName);
        try {
            DesiredCapabilities caps = CapsReaderUtil.getDesiredCaps(deviceName, ConfigPropUtils.get("caps_loc"));
            return new CapabilityManager(deviceName, caps);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
