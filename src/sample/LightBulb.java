package sample;

public class LightBulb extends Device{

    int lumenValue;
    Coordinate coordinate;

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
}
