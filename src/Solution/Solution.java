package Solution;

import Device.Device;
import Device.DeviceCatalog;

public class Solution {
    private String algoName;

    private DeviceCatalog deviceType;

    private Device device;



    public Solution(String algoName, DeviceCatalog deviceType, Device device) {
        this.algoName = algoName;
        this.deviceType = deviceType;
        this.device = device;
    }

    public String getAlgoName() {
        return algoName;
    }

    public Device getDevice() {
        return device;
    }

    public DeviceCatalog getDeviceType() {
        return deviceType;
    }
}
