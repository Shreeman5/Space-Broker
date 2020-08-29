package sample;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserInterface {

    public UserInterface(){
        List<DeviceCatalog> deviceCatalogs = Arrays.asList(DeviceCatalog.values());
        System.out.println("Devices Available: "+Arrays.toString(deviceCatalogs.toArray()));
        System.out.println("This is the part where the user chooses what device he wants.");
        System.out.println("As of right now, we are going to assume the user wants light bulb.");

        ActiveDevices activeDevices = new ActiveDevices(deviceCatalogs.get(0));
        System.out.println("Code TBD here as the user needs to know from ActiveDevices that the device chosen is a light bulb.");
        ArrayList<LightBulb> activeLightBulbs = activeDevices.getLightBulbs();
        //System.out.println(activeLightBulbs.toString());
        //System.out.println(activeDevices.getLightBulb());
        Broker broker = new Broker();
        UserRequest userRequest = new UserRequest(15, 25);
        System.out.println("Broker needs coordinate information of light bulbs and user request.");
        int userX = userRequest.getX();
        //System.out.println("uX: "+userX);
        int userY = userRequest.getY();
        //System.out.println("uY: "+userY);
        int userLumen = userRequest.getLumen();
        int lumenFulfillment = 0;
        int remainingLumen = userLumen;
        ArrayList<Integer> bulbsAndLumen = new ArrayList<>();
        for(int i = 0; i < activeLightBulbs.size(); i++){
            int bulbLumen = activeLightBulbs.get(i).getLumenValue();
            //System.out.println("bL: "+bulbLumen);
            int bulbX = activeLightBulbs.get(i).getX();
            //System.out.println("bX: "+bulbX);
            int bulbY = activeLightBulbs.get(i).getY();
            //System.out.println("bY: "+bulbY);
            int lumen = broker.calculateLumen(userX, userY, bulbX, bulbY, bulbLumen);
            System.out.println("LA: "+lumen);
            lumenFulfillment += lumen;
            System.out.println("lumenfulfill: "+lumenFulfillment);
            if (lumenFulfillment > userLumen){
                bulbsAndLumen.add(remainingLumen);
                System.out.println("Lumen requirement fulfilled at the user's coordinate");
                break;
            }
            else{
                bulbsAndLumen.add(lumen);
                remainingLumen = remainingLumen - lumen;
                System.out.println("Need more lumens");
            }
        }

        for (int i = 0; i < bulbsAndLumen.size(); i++){
            System.out.println("Bulb"+i+" provides "+bulbsAndLumen.get(i)+ " lumen");
        }




    }
}
