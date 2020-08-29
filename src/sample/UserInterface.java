package sample;


import java.util.Arrays;
import java.util.List;

public class UserInterface {

    public UserInterface(){
        List<DeviceCatalog> deviceCatalogs = Arrays.asList(DeviceCatalog.values());
        //System.out.println(Arrays.toString(deviceCatalogs.toArray()));



        ActiveDevices activeDevices = new ActiveDevices(deviceCatalogs.get(0));




        Broker broker = new Broker();
    }
}
