package Scheduler;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class CreateJSONFile {

    public CreateJSONFile(){
        JSONObject obj = new JSONObject();
        obj.put("name", "Shreeman Gautam");
        obj.put("location", "USA");

        JSONArray list = new JSONArray();
        list.put("Java");
        list.put("JSP");
        list.put("Servlets");

        obj.put("courses", list);

        try(FileWriter file = new FileWriter("myJson.json")){
            file.write(obj.toString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(obj);
    }
}
