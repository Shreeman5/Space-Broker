package sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private AlgorithmCatalog algorithmCatalog;
    private int length;

    private int width;

    private  ActiveDevices activeDevices;
    private  UserRequest userRequest;

    public UserInterface(int length, int width, ActiveDevices activeDevices, UserRequest userRequest, AlgorithmCatalog algorithmCatalog){
        this.length = length;
        this.width = width;
        this.activeDevices = activeDevices;
        this.userRequest = userRequest;
        this.algorithmCatalog = algorithmCatalog;
    }

    public void startProgram() {
        mainMenu();
    }

    private void mainMenu(){
        Scanner scan = new Scanner(System.in);
        System.out.println("-------------Welcome to the Space Broker--------------");
        System.out.println("Please select 1 to go to terminal view");
        System.out.println("Please select 2 to add file configuration");
        System.out.println("Please select 3 to view the simulation");
        System.out.println("Please select 4 to go to scheduler");
        System.out.println("------------------------------------------------------");
        System.out.println("");
        int num = scan.nextInt();
        switch (num) {
            case 1:
                terminalView();
                break;
            case 2:
                //File Configuration Method
                break;
            case 3:
                //GUI Init
                break;
            case 4:
                scan.close();
                return;
            default:
                mainMenu();
        }
        scan.close();
    }

    private void terminalView() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please select 1 to add a device");
        System.out.println("Please select 2 to see the list of active devices");
        System.out.println("Please select 3 to see list of algorithms");
        System.out.println("Please select 4 to make a active device request");
        System.out.println("Please select 5 exit");
        System.out.println("");
        int num = scan.nextInt();
        switch (num) {
            case 1:
                selectDevice();
                break;
            case 2:
                getListOfActiveDevices();
                break;
            case 3:
                getListOfAlgorithms();
                break;
            case 4:
                makeActiveDeviceRequest();
                break;
            case 5:
                return;
            default:
                terminalView();
        }
        scan.close();
    }

    private void getListOfActiveDevices() {
        System.out.println("Get list of active devices");
    }

    private void getListOfAlgorithms() {
        if(activeDevices.isEmpty()) {
            System.out.println("No active devices registered. Returning to main menu");
            mainMenu();
        }
        else {
            Scanner scan = new Scanner(System.in);
            System.out.println("Select algorithm from the following devices");
            ArrayList<DeviceCatalog> deviceCatalogs = activeDevices.getAvailableDevices();
            int size = deviceCatalogs.size();
            for(int i = 1; i <= size; i++) {
                System.out.println(i + ") " + deviceCatalogs.get(i - 1));
            }

            int num = scan.nextInt();

            if(num > size  || num <= 0) {
                System.out.println("Device Not available");
                makeActiveDeviceRequest();
            }

            else {
                getDeviceAlgorithm(deviceCatalogs.get(num - 1));
            }
        }
    }

    private void getDeviceAlgorithm(DeviceCatalog device) {
        switch (device){
            case LightBulb:
                getLightBulbAlgorithms();
                break;
            case AlarmClock:
                System.out.println("AlarmClock unavailable at the moment");
                System.exit(0);
                break;
            case Thermometer:
                System.out.println("Thermometer unavailable at the moment");
                System.exit(0);
                break;
            default:
                System.out.println("This device is unavailable at the moment");
                System.exit(0);
                break;

        }
    }

    private void getLightBulbAlgorithms() {
        ArrayList<String> algorithms = algorithmCatalog.getLightBulbAlgorithms();
        System.out.println("Please select from list of algorithms");
        int size = algorithms.size();
        for(int i = 0; i < size; i++) {
            System.out.println(i + 1 + ") " + algorithms.get(i));
        }
        Scanner scan = new Scanner(System.in);
        System.out.println("Please select algorithm's number");
        int num = scan.nextInt();

        if(num > size  || num <= 0) {
            System.out.println("Algorithm not available");
            getLightBulbAlgorithms();
        }

        else {
            algorithmCatalog.setSelectedLightBulbAlgorithms(num - 1);
            postAlgorithmSelectionMenu();
        }
    }

    private void postAlgorithmSelectionMenu() {
        Scanner scan = new Scanner(System.in);
        System.out.println("-----------------------------------------------------");
        System.out.println("Please select 1 to add another algorithm");
        System.out.println("Please select 2 to go to terminal view");
        System.out.println("Please select 3 to go to main menu");
        System.out.println("Please select 4 to exit program");
        System.out.println("------------------------------------------------------");
        System.out.println("");
        int num = scan.nextInt();

        switch (num) {
            case 1:
                getListOfAlgorithms();
                break;
            case 2:
                terminalView();
                break;
            case 3:
                mainMenu();
                break;
            case 4:
                System.exit(0);
                break;
            default:
                postAlgorithmSelectionMenu();
                break;
        }
    }

    private void makeActiveDeviceRequest() {
        if(activeDevices.isEmpty()) {
            System.out.println("No active devices registered. Returning to main menu");
            mainMenu();
        }
        else {
            Scanner scan = new Scanner(System.in);
            System.out.println("Select device from here");
            ArrayList<DeviceCatalog> deviceCatalogs = activeDevices.getAvailableDevices();
            int size = deviceCatalogs.size();
            for(int i = 1; i <= size; i++) {
                System.out.println(i + ") " + deviceCatalogs.get(i - 1));
            }

            int num = scan.nextInt();

            if(num > size  || num <= 0) {
                System.out.println("Device Not available");
                makeActiveDeviceRequest();
            }

            else {
                addDeviceRequest(deviceCatalogs.get(num - 1));
            }
        }
    }


    private void addDeviceRequest(DeviceCatalog device) {
        switch (device){
            case LightBulb:
                addLightBulbRequest();
                break;
            case AlarmClock:
                System.out.println("AlarmClock unavailable at the moment");
                System.exit(0);
                break;
            case Thermometer:
                System.out.println("Thermometer unavailable at the moment");
                System.exit(0);
                break;
            default:
                System.out.println("This device is unavailable at the moment");
                System.exit(0);
                break;

        }
    }

    private void addLightBulbRequest() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter request's x coordinate");
        int xcor = scan.nextInt();

        System.out.println("Please enter request's y coordinate");
        int ycor = scan.nextInt();

        System.out.println("Please enter light's intensity (lumen) request");
        int lumen = scan.nextInt();

        if(xcor > 500 || ycor > 500 || xcor < 0 || ycor < 0) {
            System.out.println("Invalid coordinate value");
            addLightBulbRequest();
        }
        LightBulbRequest lightBulbRequest = new LightBulbRequest(lumen, new Coordinate(xcor, ycor));
        userRequest.addDeviceRequest(DeviceCatalog.LightBulb, lightBulbRequest);
        postRequestSelectionMenu();

    }


    private void selectDevice() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Select device from here");
        List<DeviceCatalog> deviceCatalogs = Arrays.asList(DeviceCatalog.values());
        int size = deviceCatalogs.size();
        for(int i = 1; i <= size; i++) {
            System.out.println(i + ") " + deviceCatalogs.get(i - 1));
        }

        int num = scan.nextInt();

        if(num > size  || num <= 0) {
            System.out.println("Device Not available");
            selectDevice();
        }

        else {
            addActiveDevice(deviceCatalogs.get(num - 1));
        }

    }

    private  void addActiveDevice(DeviceCatalog device) {
        switch (device){
            case LightBulb:
                addLightBulbMenu();
                break;
            case AlarmClock:
                System.out.println("AlarmClock unavailable at the moment");
                System.exit(0);
                break;
            case Thermometer:
                System.out.println("Thermometer unavailable at the moment");
                System.exit(0);
                break;
            default:
                System.out.println("This device is unavailable at the moment");
                System.exit(0);
                break;

        }
    }

    private  void addLightBulbMenu() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter light's x coordinate");
        int length = scan.nextInt();

        System.out.println("Please enter light's y coordinate");
        int width = scan.nextInt();

        System.out.println("Please enter light's intensity (lumen)");
        int lumen = scan.nextInt();

        if(length > 500 || width > 500 || length < 0 || width < 0) {
            System.out.println("Invalid coordinate value");
            addLightBulbMenu();
        }
        else {
            initializeLightBulb(length, width, lumen);
            postDeviceSelectionMenu();
        }
    }

    private  void initializeLightBulb(int length, int width, int lumen) {
        LightBulb lightbulb = new LightBulb(lumen, new Coordinate(length, width));
        activeDevices.addDevice(DeviceCatalog.LightBulb,  lightbulb);

        /*for(int i = 0; i < activeDevices.getLightBulbs().size(); i++) {
            LightBulb lightBulb = activeDevices.getLightBulbs().get(i);
            System.out.println("Light Bulb's x cor " + lightBulb.getCoordinate().getX());
            System.out.println("Light Bulb's y cor " + lightBulb.getCoordinate().getY());
            System.out.println("Light Bulb's lumen value " + lightBulb.getLumenValue());
        } */
    }

    private void postDeviceSelectionMenu() {
        Scanner scan = new Scanner(System.in);
        System.out.println("-----------------------------------------------------");
        System.out.println("Please select 1 to add another device");
        System.out.println("Please select 2 to go to terminal view");
        System.out.println("Please select 3 to go to main menu");
        System.out.println("Please select 4 to exit program");
        System.out.println("------------------------------------------------------");
        System.out.println("");
        int num = scan.nextInt();

        switch (num) {
            case 1:
                selectDevice();
                break;
            case 2:
                terminalView();
                break;
            case 3:
                mainMenu();
                break;
            case 4:
                System.exit(0);
                break;
            default:
                postDeviceSelectionMenu();
                break;
        }
    }

    private void postRequestSelectionMenu() {
        Scanner scan = new Scanner(System.in);
        System.out.println("-----------------------------------------------------");
        System.out.println("Please select 1 to make another request");
        System.out.println("Please select 2 to go to terminal view");
        System.out.println("Please select 3 to go to main menu");
        System.out.println("Please select 4 to exit program");
        System.out.println("------------------------------------------------------");
        System.out.println("");
        int num = scan.nextInt();

        switch (num) {
            case 1:
                makeActiveDeviceRequest();
                break;
            case 2:
                terminalView();
                break;
            case 3:
                mainMenu();
                break;
            case 4:
                System.exit(0);
                break;
            default:
                postRequestSelectionMenu();
                break;
        }
    }

}
