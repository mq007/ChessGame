package game;

import game.pieces.Piece;
import javafx.scene.image.ImageView;
import javafx.scene.input.DataFormat;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.io.Serializable;


/**
 * Created by mq on 2017-08-18.
 */
public class Tile extends Rectangle{

    private Piece piece;
    private Pane chessboard;
    private ImageView image;
    double coordX;
    double coordY;

    public Tile(boolean isBlack, double width, double height) {
        setWidth(Game.TILE_SIZE);
        setHeight(Game.TILE_SIZE);

        coordX = width * Game.TILE_SIZE;
        coordY = height * Game.TILE_SIZE;
        relocate(coordX, coordY);

        setFill(isBlack ? Color.valueOf("FFCE9E") : Color.valueOf("D18B47"));
    }

    public boolean isPiecePlaced(){
        return piece != null;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
        image = new ImageView(piece.getImage());
        image.relocate(coordX, coordY);
        chessboard.getChildren().add(image);
    }

    public Pane getChessboard() {
        return chessboard;
    }

    public void setChessboard(Pane chessboard) {
        this.chessboard = chessboard;
    }

    public ImageView getImage() {
        return image;
    }

    public void setImage(ImageView image) {
        this.image = image;
    }
}
