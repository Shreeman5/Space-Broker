package sample;

public class Broker {

    public Broker(){

    }

    public int calculateLumen(int userX, int userY, int bulbX, int bulbY, int bulbLumen){
        int distanceBetweenUserAndBulbX = Math.abs(userX - bulbX) * Math.abs(userX - bulbX);
        System.out.println("X: "+distanceBetweenUserAndBulbX);
        int distanceBetweenUserAndBulbY = Math.abs(userY - bulbY) * Math.abs(userY - bulbY);
        System.out.println("Y: "+distanceBetweenUserAndBulbY);
        int lumenAtThisPoint = bulbLumen/(distanceBetweenUserAndBulbX + distanceBetweenUserAndBulbY);
        System.out.println("lP: "+lumenAtThisPoint);
        return lumenAtThisPoint;
    }
}
