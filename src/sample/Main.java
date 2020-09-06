package sample;

public class Main {

    private static final int length = 500;
    private static final int width = 500;

    private static ActiveDevices activeDevices;
    private static UserRequest userRequest;
    private static AlgorithmCatalog algorithmCatalog;

    public static void main(String[] args) {
        activeDevices = new ActiveDevices();
        userRequest = new UserRequest();
        algorithmCatalog = new AlgorithmCatalog(length, width, activeDevices, userRequest);
        UserInterface userInterface = new UserInterface(length, width, activeDevices, userRequest, algorithmCatalog);
        userInterface.startProgram();

        Broker broker = new Broker(length, width, activeDevices, userRequest, algorithmCatalog);


        System.out.println("Hello World");
    }

    //method
}