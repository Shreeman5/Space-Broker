package sample;

public class Broker {
    private int length;

    private int width;

    private  ActiveDevices activeDevices;
    private  UserRequest userRequest;
    private AlgorithmCatalog algorithmCatalog;
    public Broker(int length, int width, ActiveDevices activeDevices, UserRequest userRequest, AlgorithmCatalog algorithmCatalog){
        this.activeDevices = activeDevices;
        this.userRequest = userRequest;
        this.length = length;
        this.width = width;
        this.algorithmCatalog = algorithmCatalog;
    }


}
