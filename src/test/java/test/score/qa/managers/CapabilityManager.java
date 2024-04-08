package test.score.qa.managers;

import org.openqa.selenium.Capabilities;

public class CapabilityManager {

    public String deviceName;

    public Capabilities caps;

    public CapabilityManager(String deviceName, Capabilities caps) {
        this.deviceName = deviceName;
        this.caps = caps;
    }

    public String getDeviceName() {
        return this.deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public Capabilities getCapabilities() {
        return this.caps;
    }

    public void setCapabilities(Capabilities capabilities) {
        this.caps = capabilities;
    }
}
