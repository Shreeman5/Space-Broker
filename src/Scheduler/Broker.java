package sample;

import java.util.ArrayList;

public class Broker {
    private int length;

    private int width;

    private  ActiveDevices activeDevices;
    private  UserRequest userRequest;
    private AlgorithmCatalog algorithmCatalog;
    private Solutions solutions;

    public Broker(int length, int width, ActiveDevices activeDevices,
                  UserRequest userRequest, AlgorithmCatalog algorithmCatalog,
                  Solutions solutions){
        this.activeDevices = activeDevices;
        this.userRequest = userRequest;
        this.length = length;
        this.width = width;
        this.algorithmCatalog = algorithmCatalog;
        this.solutions = solutions;
    }

    public void respondToRequests() {
        if(activeDevices.isEmpty()) {
            System.out.println("No devices found to respond to requests");
            return;
        }
        if(!userRequest.hasRequest()) {
            System.out.println("User has not made any request");
            return;
        }
        ArrayList<String> selectedAlgorithm = algorithmCatalog.getSelectedLightBulbAlgorithms();

        if(selectedAlgorithm.isEmpty()) {
            System.out.println("No algorithm is selected");
            return;
        }

        algorithmCatalog.solveSelectedAlgorithm();

        System.out.println("Finished Responding....");
        return;
    }

}
