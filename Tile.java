package game;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


/**
 * Created by mq on 2017-08-18.
 */
public class Tile extends Rectangle{

    private double coordX;
    private double coordY;

    public Tile(boolean isBlack, int vertical, int horizontal) {
        setWidth(Game.TILE_SIZE);
        setHeight(Game.TILE_SIZE);

        coordX = horizontal * Game.TILE_SIZE;
        coordY = vertical * Game.TILE_SIZE;
        relocate(coordX, coordY);

        setFill(isBlack ? Color.valueOf("FFCE9E") : Color.valueOf("D18B47"));
    }

}
