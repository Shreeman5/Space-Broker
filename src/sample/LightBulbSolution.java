package sample;

public class LightBulbSolution extends Solution{
    private int lumenIncrement;

    public LightBulbSolution(String algoName, DeviceCatalog deviceType, Device device, int lumenIncrement) {
        super(algoName, deviceType, device);
        this.lumenIncrement = lumenIncrement;
    }

    public int getLumenIncrement() {
        return lumenIncrement;
    }
}
