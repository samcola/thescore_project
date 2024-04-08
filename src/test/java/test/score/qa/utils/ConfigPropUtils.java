package test.score.qa.utils;

import test.score.qa.managers.AppiumServerManager;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConfigPropUtils {

    private static final Logger logger = Logger.getLogger(ConfigPropUtils.class.getName());
    public static Properties configProps = null;

//    Retrieving all the properties from config.properties and storing it in Properties object
    static {
        FileInputStream inputStream = null;
        String fileName = "config.properties";
        String filePath = System.getProperty("user.dir") + "/config/" + fileName;
        try {
            inputStream = new FileInputStream(filePath);
            configProps = new Properties();
            configProps.load(inputStream);
            configProps.putAll(System.getProperties());
        } catch (IOException exception) {
            exception.printStackTrace();
        } finally {
            try {
                assert inputStream != null;
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static Integer getPort() {
        String[] allPorts = get("ports").split(",");
        Boolean flag = false;
        for (String eachPort : allPorts) {
            int port = Integer.parseInt(eachPort);
//          Try and establish a connection to the given port. If conn is established, port is already in use.
            try(Socket used = new Socket("localhost", port)) {
                logger.log(Level.INFO, "Port " + port + "already in use. Checking next port");
            } catch (IOException e) {
                flag = true;
            }
            if (flag)
            {
                return port;
            }
        }
        return 0;
    }

    public static String get(String key) { return configProps.getProperty(key); }
}
