package sample;

public class UserRequest {

    public int x;
    public int y;
    public int lumen;

    public UserRequest(int x, int y){
        this.x = x;
        this.y = y;
        this.lumen = 60;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }


}
