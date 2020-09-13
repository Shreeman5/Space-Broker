package Scheduler;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;
import jdk.nashorn.internal.parser.JSONParser;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class ReadJSONFile {

    public ReadJSONFile(){
        String first = "/Users/shree/IdeaProjects/SpaceBroker/myJson.json";
        try{
            String contents = new String((Files.readAllBytes(Paths.get(first))));

            JSONObject jsonObject = new JSONObject(contents);

            JSONArray courses = jsonObject.getJSONArray("courses");
            for (int i = 0; i < courses.length(); i++){
                System.out.println(courses.get(i));
            }

            String name = jsonObject.getString("name");
            System.out.println(name);

            String location = jsonObject.getString("location");
            System.out.println(location);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

}
