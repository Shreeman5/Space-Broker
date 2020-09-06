package sample;

import java.util.ArrayList;

public class AlgorithmCatalog {

    private  int length;
    private int width;
    private  ActiveDevices activeDevices;
    private  UserRequest userRequest;

    private ArrayList<String> lightBulbAlgorithms;
    private ArrayList<String> selectedLightBulbAlgorithms;

    public AlgorithmCatalog(int length, int width, ActiveDevices activeDevices, UserRequest userRequest) {
        this.length = length;
        this.width = width;
        this.activeDevices = activeDevices;
        this.userRequest = userRequest;
        lightBulbAlgorithms = new ArrayList<>();
        selectedLightBulbAlgorithms = new ArrayList<>();
        setLightBulbAlgorithms("Algo 1");
        setLightBulbAlgorithms("Algo 2");
        setLightBulbAlgorithms("Algo 3");
    }

    public void setLightBulbAlgorithms(String name) {
        lightBulbAlgorithms.add(name);
    }

    public ArrayList<String> getLightBulbAlgorithms() {
        return lightBulbAlgorithms;
    }

    public void setSelectedLightBulbAlgorithms(int num) {
        selectedLightBulbAlgorithms.add(lightBulbAlgorithms.get(num));
    }

    public ArrayList<String> getSelectedLightBulbAlgorithms() {
        return selectedLightBulbAlgorithms;
    }
}
