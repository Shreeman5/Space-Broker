package Algorithm;

import Device.ActiveDevices;
import Request.UserRequest;
import Solution.LightBulbSolution;
import Solution.Solutions;
import Device.LightBulb;
import Device.DeviceCatalog;

import java.util.ArrayList;

public class AlgorithmCatalog {

    private  int length;
    private int width;
    private ActiveDevices activeDevices;
    private UserRequest userRequest;

    private ArrayList<String> lightBulbAlgorithms;
    private ArrayList<String> selectedLightBulbAlgorithms;
    private Solutions solutions;

    public AlgorithmCatalog(int length, int width,
                            ActiveDevices activeDevices, UserRequest userRequest,
                            Solutions solutions) {
        this.length = length;
        this.width = width;
        this.activeDevices = activeDevices;
        this.userRequest = userRequest;
        this.solutions = solutions;
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

    public void solveSelectedAlgorithm() {
        int size = selectedLightBulbAlgorithms.size();
        for(int i = 0; i < size; i++) {
            if(selectedLightBulbAlgorithms.get(i).equals("Algo 1")) {
                algorithm1("Algo 1");
            }
            else if(selectedLightBulbAlgorithms.get(i).equals("Algo 2")) {
                algorithm2();
            }
            else if(selectedLightBulbAlgorithms.get(i).equals("Algo 3")) {
                algorithm3();
            }
        }
    }

    private void algorithm1(String algoName) {
        ArrayList<LightBulb> lightBulbs = activeDevices.getLightBulbs();
        int solLumenValue = 200;
        int lightBulbSize = lightBulbs.size();
        //ArrayList<LightBulbRequest> lightBulbRequests = userRequest.getLightBulbRequests();
        for(int i = 0; i < lightBulbSize; i++) {
            LightBulb lightBulb= lightBulbs.get(i);
            int increment = solLumenValue - lightBulb.getLumenValue();
            lightBulb.setLumenValue(solLumenValue);
            LightBulbSolution solution = new LightBulbSolution(algoName, DeviceCatalog.LightBulb,lightBulb, increment );
            solutions.setLightBulbSolutions(solution);
        }

        ArrayList<LightBulbSolution> sol = solutions.getLightBulbSolution();
        for(int i = 0; i < sol.size(); i ++) {
            System.out.println("Sol " + i  + " Lumen Increment = " + sol.get(i).getLumenIncrement());
            System.out.println("Algorithm Name = " + sol.get(i).getAlgoName());
        }
    }

    private void algorithm2() {
        System.out.println("Solving using algorithm 2");
    }

    private void algorithm3() {
        System.out.println("Solving using algorithm 3");
    }

}
