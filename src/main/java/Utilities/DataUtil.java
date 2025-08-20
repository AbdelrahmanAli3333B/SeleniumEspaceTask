package Utilities;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class DataUtil {

    private static final String TEST_DATA_PATH = "src/test/resources/TestData/";

    public static String getJsonData(String fileName, String field) throws FileNotFoundException {
        FileReader reader = new FileReader(TEST_DATA_PATH+fileName+".json");
        JsonElement jsonElement = JsonParser.parseReader(reader);
        return jsonElement.getAsJsonObject().get(field).getAsString();
    }
}
