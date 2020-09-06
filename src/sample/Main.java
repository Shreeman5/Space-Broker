package sample;

import java.util.Scanner;

public class Main {

    private static final int length = 500;
    private static final int width = 500;

    private static ActiveDevices activeDevices;
    private static UserRequest userRequest;
    private static AlgorithmCatalog algorithmCatalog;
    private static boolean programRunningStatus;
    private static Scanner scan;

    public static void main(String[] args) {
        programRunningStatus = true;
        activeDevices = new ActiveDevices();
        userRequest = new UserRequest();
        algorithmCatalog = new AlgorithmCatalog(length, width, activeDevices, userRequest);
        scan = new Scanner(System.in);
        UserInterface userInterface = new UserInterface(length, width, activeDevices,
                userRequest, algorithmCatalog, scan, programRunningStatus);
        Broker broker = new Broker(length, width, activeDevices, userRequest, algorithmCatalog);


        while(programRunningStatus) {
            userInterface.startProgram();
            System.out.println("Hello World");
        }
        scan.close();
    }

}