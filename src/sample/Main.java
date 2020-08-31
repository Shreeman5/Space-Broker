package sample;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final int length = 500;
    private static final int width = 500;

    private static ActiveDevices activeDevices;
    private static UserRequest userRequest;

    public static void main(String[] args) {
        activeDevices = new ActiveDevices();
        userRequest = new UserRequest();
        //UserInterface userInterface = new UserInterface();
        mainMenu();

    }

    public static void mainMenu() {
        Scanner scan = new Scanner(System.in);
        System.out.println("-------------Welcome to the Space Broker--------------");
        System.out.println("Please select 1 to add a device");
        System.out.println("Please select 2 to see the list of active devices");
        System.out.println("Please select 3 to see list of algorithms");
        System.out.println("Please select 4 to make a active device request");
        System.out.println("Please select 5 exit");
        System.out.println("------------------------------------------------------");
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
                System.exit(0);
            default:
                mainMenu();
        }
        scan.close();

    }

    public static void selectDevice() {
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

    public  static  void getListOfActiveDevices() {
        System.out.println("Get list of active devices");
    }

    public static  void getListOfAlgorithms() {
        System.out.println("List of Algorithms");
    }

    public static void makeActiveDeviceRequest() {
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

    public static void addDeviceRequest(DeviceCatalog device) {
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

    public static void addLightBulbRequest() {
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

    }


    public static void addActiveDevice(DeviceCatalog device) {
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

    public static void addLightBulbMenu() {
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

    public static void initializeLightBulb(int length, int width, int lumen) {
        LightBulb lightbulb = new LightBulb(lumen, new Coordinate(length, width));
        activeDevices.addDevice(DeviceCatalog.LightBulb,  lightbulb);

        /*for(int i = 0; i < activeDevices.getLightBulbs().size(); i++) {
            LightBulb lightBulb = activeDevices.getLightBulbs().get(i);
            System.out.println("Light Bulb's x cor " + lightBulb.getCoordinate().getX());
            System.out.println("Light Bulb's y cor " + lightBulb.getCoordinate().getY());
            System.out.println("Light Bulb's lumen value " + lightBulb.getLumenValue());
        } */
    }

    public static void postDeviceSelectionMenu() {
        Scanner scan = new Scanner(System.in);
        System.out.println("-----------------------------------------------------");
        System.out.println("Please select 1 to add another device");
        System.out.println("Please select 2 to go to main menu");
        System.out.println("Please select 3 to exit program");
        System.out.println("------------------------------------------------------");
        System.out.println("");
        int num = scan.nextInt();

        switch (num) {
            case 1:
                selectDevice();
                break;
            case 2:
                mainMenu();
                break;
            case 3:
                System.exit(0);
                break;
            default:
                postDeviceSelectionMenu();
                break;
        }
    }


}
