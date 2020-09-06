package sample;

public class LightBulb extends Device{

    private int lumenValue;
    private Coordinate coordinate;

    public LightBulb(int lumenValue, Coordinate coordinate){
        this.lumenValue = lumenValue;
        this.coordinate = coordinate;
    }

    public int getLumenValue(){
        return lumenValue;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setLumenValue(int lumenValue) {
        this.lumenValue = lumenValue;
    }
}
