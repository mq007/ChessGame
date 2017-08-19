package game.pieces;

import game.PieceColor;
import game.Move;
import game.Position;
import javafx.scene.image.Image;

import java.util.List;

/**
 * Created by mq on 2017-08-18.
 */

public abstract class Piece {
    private Position position;
    private PieceColor pieceColor;
    private String name;
    private Image image;

    protected Piece(){};

    public Piece(PieceColor pieceColor, String name) {
        this.pieceColor = pieceColor;
        this.name = name;
        setImage();
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public PieceColor getPieceColor() {
        return pieceColor;
    }

    public void setPieceColor(PieceColor pieceColor) {
        this.pieceColor = pieceColor;
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
        String nameOfImage = name + "_" + pieceColor + ".png";
        image = new Image("/game/resources/"+nameOfImage);
    }

    public abstract List<Move> getAvailableMoves();
}