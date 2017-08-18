package game;

/**
 * Created by mq on 2017-08-18.
 */
public class Move {
    private Position origin;
    private Position destination;

    public Move(Position origin, Position destination) {
        this.origin = origin;
        this.destination = destination;
    }

    public Position getOrigin() {
        return origin;
    }

    public void setOrigin(Position origin) {
        this.origin = origin;
    }

    public Position getDestination() {
        return destination;
    }

    public void setDestination(Position destination) {
        this.destination = destination;
    }
}
