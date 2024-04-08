package test.score.qa.utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import test.score.qa.setup.Hooks;

import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Logger;

public class JsonParserUtil {

    private static final Logger logger = Logger.getLogger(JsonParserUtil.class.getName());

    public static JSONArray getAsJsonArr(String jsonLocation) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        return (JSONArray) parser.parse(new FileReader(jsonLocation));
    }


    public static JSONObject getLeagues(String key){
        JSONParser jsonParser = new JSONParser();
        try{
            return (JSONObject)((JSONObject) jsonParser.parse(new FileReader(System.getProperty("user.dir") + "/" + ConfigPropUtils.get("leagues_loc")))).get(key);

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
