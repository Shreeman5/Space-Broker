package sample;

import java.util.ArrayList;

public class Solutions {
    private ArrayList<LightBulbSolution> lightBulbSolutions;

    public Solutions() {
        lightBulbSolutions = new ArrayList<>();
    }

    public void setLightBulbSolutions(LightBulbSolution lightBulbSolution) {
        this.lightBulbSolutions.add(lightBulbSolution);
    }

    public ArrayList<LightBulbSolution> getLightBulbSolution() {
        return lightBulbSolutions;
    }
}
