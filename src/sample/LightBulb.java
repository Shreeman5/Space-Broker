package sample;

public class LightBulb {

    int lumenValue;
    int x;
    int y;

    public LightBulb(int lumenValue, int x, int y){
        this.lumenValue = lumenValue;
        this.x = x;
        this.y = y;
    }

    public int getLumenValue(){
        return lumenValue;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }
}
