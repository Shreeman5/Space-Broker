package sample;

import java.util.ArrayList;

public class ActiveDevices {

    private ArrayList<LightBulb> lightBulbs = new ArrayList<>();

    public ActiveDevices(DeviceCatalog device){
        switch (device){
            case LightBulb:
                LightBulb lightbulb1 = new LightBulb(3000, 10, 10);
                LightBulb lightBulb2 = new LightBulb(5000, 20, 20);
                lightBulbs.add(lightbulb1);
                lightBulbs.add(lightBulb2);
                System.out.println("L");
                break;
            case AlarmClock:
                System.out.println("A");
                break;
            case Thermometer:
                System.out.println("T");
                break;
            default:
                System.out.println("Dank");
                break;

        }
    }

    public ArrayList<LightBulb> getLightBulbs() {
        return lightBulbs;
    }


}
