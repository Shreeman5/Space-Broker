package Scheduler;

import Device.ActiveDevices;
import Request.UserRequest;
import Algorithm.AlgorithmCatalog;
import Solution.Solutions;

import java.util.Scanner;

public class Main {

    private static final int length = 500;
    private static final int width = 500;

    private static ActiveDevices activeDevices;
    private static UserRequest userRequest;
    private static AlgorithmCatalog algorithmCatalog;
    private static boolean programRunningStatus;
    private static Scanner scan;
    private static Solutions solutions;

    public static void main(String[] args) {
        solutions = new Solutions();
        programRunningStatus = true;
        activeDevices = new ActiveDevices();
        userRequest = new UserRequest();
        algorithmCatalog = new AlgorithmCatalog(length, width, activeDevices, userRequest, solutions);
        scan = new Scanner(System.in);
        UserInterface userInterface = new UserInterface(length, width, activeDevices,
                userRequest, algorithmCatalog, scan, programRunningStatus, solutions);
        Broker broker = new Broker(length, width, activeDevices, userRequest,
                algorithmCatalog, solutions);
        FileConfig file = new FileConfig("config.txt", length, width, activeDevices, userRequest, algorithmCatalog);
        file.readFile();


        while(programRunningStatus) {
            userInterface.startProgram();
            if(programRunningStatus) {
                broker.respondToRequests();
            }
        }
        scan.close();
    }

}