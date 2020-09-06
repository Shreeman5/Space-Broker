package Device;

import Device.Device;

import java.util.ArrayList;

public class ActiveDevices {


    private ArrayList<LightBulb> lightBulbs = new ArrayList<>();

    private boolean isEmpty;

    public ActiveDevices() {
        isEmpty = true;
    }

    public ArrayList<LightBulb> getLightBulbs() {
        return lightBulbs;
    }

    public void addDevice(DeviceCatalog deviceType, Device device) {
        switch (deviceType){
            case LightBulb:
                lightBulbs.add((LightBulb) device);
                isEmpty = false;
                break;
            case AlarmClock:

                break;
            case Thermometer:

                break;
            default:

                break;

        }
    }

    public ArrayList<DeviceCatalog> getAvailableDevices() {
        ArrayList<DeviceCatalog> deviceCatalogs = new ArrayList<>();
        if(!lightBulbs.isEmpty()) {
            deviceCatalogs.add(DeviceCatalog.LightBulb);
        }

        return deviceCatalogs;
    }

    public boolean isEmpty() {
        return isEmpty;
    }
}
