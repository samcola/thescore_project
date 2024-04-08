package test.score.qa.utils;

import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.remote.DesiredCapabilities;
import test.score.qa.managers.DeviceManager;

import java.util.HashMap;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CapsReaderUtil {

    private static final Logger logger = Logger.getLogger(CapsReaderUtil.class.getName());

    public static DesiredCapabilities getDesiredCaps(String deviceName, String capsDirectory) throws Exception{
//        Get the JSON from the given location and parsing it into JSONArray
        String jsonLocation = System.getProperty("user.dir") + "/" + capsDirectory;
        JSONArray capsArr = JsonParserUtil.getAsJsonArr(jsonLocation);
        logger.log(Level.INFO, "Retrieved caps.json: " + capsArr);
//        Loop through each capability set in the JSON
        for (Object eachObj: capsArr) {
            JSONObject capsObj = (JSONObject) eachObj;
//            Search for capset with given device name
            if (capsObj.get("deviceName").toString().equalsIgnoreCase(deviceName)) {
                logger.log(Level.INFO, "Retrieved matching caps object: " + capsObj);
                ObjectMapper mapper = new ObjectMapper();
                HashMap<String, Object> caps = mapper.readValue(capsObj.toString(), HashMap.class);
                return new DesiredCapabilities(caps);
            }
        }
        return null;
    }
}
