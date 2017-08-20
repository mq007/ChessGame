package game;

import game.pieces.Piece;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 * Created by mq on 2017-08-20.
 */
public class PieceImage extends ImageView {
    private Piece piece;
    private Pane chessboard;
    private int x;
    private int y;

    public PieceImage(Piece piece, Pane chessboard, int y, int x) {
        this.piece = piece;
        this.chessboard = chessboard;
        this.x = x;
        this.y = y;

        setImage(piece.getImage());
        this.relocate(x * Game.TILE_SIZE, y * Game.TILE_SIZE);
        chessboard.getChildren().add(this);
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public Pane getChessboard() {
        return chessboard;
    }

    public void setChessboard(Pane chessboard) {
        this.chessboard = chessboard;
    }
}
