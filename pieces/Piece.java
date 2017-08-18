package game.pieces;

import game.Color;
import game.Move;
import game.Position;
import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.List;

/**
 * Created by mq on 2017-08-18.
 */

public abstract class Piece {
    private Position position;
    private Color color;
    private String name;
    private Image image;

    protected Piece(){};

    public Piece(Color color, String name) {
        this.color = color;
        this.name = name;
        setImage();
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    private void setImage(){
        String nameOfImage = name + "_" + color + ".png";
        image = new Image("/game/resources/"+nameOfImage);
    }

    public abstract List<Move> getAvailableMoves();
}