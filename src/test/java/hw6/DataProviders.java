package hw6;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import hw6.domain.MetalAndColor;
import org.testng.annotations.DataProvider;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class DataProviders {

    public static final String DATA_SET_JSON = "src/test/resources/JDI_ex8_metalsColorsDataSet.json";

    @DataProvider(name = "Metal and Color Provider")
    public Iterator<Object> provideMetalAndColor() throws FileNotFoundException {
        Gson gson = new Gson();
        FileReader fileReader = new FileReader(DATA_SET_JSON);
        JsonObject jsonData = new JsonParser().parse(fileReader).getAsJsonObject();
        List<Object> dataList = new ArrayList<>(Collections.emptyList());
        for (String key : jsonData.keySet()) {
            MetalAndColor item = gson.fromJson(jsonData.get(key), MetalAndColor.class);
            dataList.add(item);
        }
        return dataList.iterator();
    }
}
