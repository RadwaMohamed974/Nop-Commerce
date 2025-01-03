package Data;



import com.google.gson.JsonObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class JsonDataReader {
    static String jsonPath = "src/test/java/Data/UserData.json";

    public static String jsonData(String objectName , String dataFromJson) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader(jsonPath));
        JSONObject jsonObject = (JSONObject) obj;
        JSONObject ValidUser = (JSONObject) jsonObject.get(objectName);
        String data = (String) ValidUser.get(dataFromJson);


        return data;
    }
}

