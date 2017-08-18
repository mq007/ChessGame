package game;

/**
 * Created by mq on 2017-08-18.
 */
public class Position {

    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void changePosition(int addX, int addY){
        x += addX;
        y += addY;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}