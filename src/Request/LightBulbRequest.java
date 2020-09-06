package Request;

import Extras.Coordinate;

public class LightBulbRequest extends DeviceRequest {
    private int lumen;

    private Coordinate coordinate;

    public LightBulbRequest(int lumen, Coordinate coordinate) {
        this.lumen = lumen;
        this.coordinate = coordinate;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public int getLumen() {
        return lumen;
    }
}
