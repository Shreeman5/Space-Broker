package sample;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserInterface {

    public UserInterface(){
        List<DeviceCatalog> deviceCatalogs = Arrays.asList(DeviceCatalog.values());
        System.out.println(Arrays.toString(deviceCatalogs.toArray()));



        ActiveDevices activeDevices = new ActiveDevices(deviceCatalogs.get(0));
        ArrayList<LightBulb> activeLightBulbs = activeDevices.getLightBulbs();
        //System.out.println(activeLightBulbs.toString());
        //System.out.println(activeDevices.getLightBulb());
        Broker broker = new Broker();
        UserRequest userRequest = new UserRequest(15, 25);
        int userX = userRequest.getX();
        System.out.println("uX: "+userX);
        int userY = userRequest.getY();
        System.out.println("uY: "+userY);
        for(int i = 0; i < activeLightBulbs.size(); i++){
            int bulbLumen = activeLightBulbs.get(i).getLumenValue();
            System.out.println("bL: "+bulbLumen);
            int bulbX = activeLightBulbs.get(i).getX();
            System.out.println("bX: "+bulbX);
            int bulbY = activeLightBulbs.get(i).getY();
            System.out.println("bY: "+bulbY);
            int lumen = broker.calculateLumen(userX, userY, bulbX, bulbY, bulbLumen);
            System.out.println("LA: "+lumen);
        }




    }
}
