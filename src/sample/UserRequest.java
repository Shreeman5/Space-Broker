package sample;

import java.util.ArrayList;

public class UserRequest {

    private ArrayList<LightBulbRequest> lightBulbRequests;
    private boolean hasRequest;

    public UserRequest(){
        hasRequest = false;
        this.lightBulbRequests = new ArrayList<>();
    }

    public void addDeviceRequest(DeviceCatalog deviceType, DeviceRequest deviceRequest) {
        switch (deviceType){
            case LightBulb:
                lightBulbRequests.add((LightBulbRequest) deviceRequest);
                hasRequest = true;
                break;
            case AlarmClock:

                break;
            case Thermometer:

                break;
            default:

                break;

        }
    }

    public ArrayList<LightBulbRequest> getLightBulbRequests() {
        return lightBulbRequests;
    }
}
