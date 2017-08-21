package game;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


/**
 * Created by mq on 2017-08-18.
 */
public class Tile extends Rectangle{

    private double coordX;
    private double coordY;
    private boolean isFieldFree;
    private PieceColor fieldColor;

    public Tile(boolean isBlack, int vertical, int horizontal) {
        setWidth(Game.TILE_SIZE);
        setHeight(Game.TILE_SIZE);

        isFieldFree = true;

        coordX = horizontal * Game.TILE_SIZE;
        coordY = vertical * Game.TILE_SIZE;
        relocate(coordX, coordY);

        setFill(isBlack ? Color.valueOf("FFCE9E") : Color.valueOf("D18B47"));
    }

    public double getCoordX() {
        return coordX;
    }

    public void setCoordX(double coordX) {
        this.coordX = coordX;
    }

    public double getCoordY() {
        return coordY;
    }

    public void setCoordY(double coordY) {
        this.coordY = coordY;
    }

    public boolean isFieldFree() {
        return isFieldFree;
    }

    public void setFieldFree(boolean placeFree) {
        isFieldFree = placeFree;
    }

    public PieceColor getFieldColor() {
        return fieldColor;
    }

    public void setFieldColor(PieceColor fieldColor) {
        this.fieldColor = fieldColor;
    }
}
