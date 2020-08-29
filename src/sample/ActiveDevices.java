package sample;

public class ActiveDevices {

    public ActiveDevices(DeviceCatalog device){
        switch (device){
            case LightBulb:
                LightBulb lightbulb = new LightBulb();
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
}
