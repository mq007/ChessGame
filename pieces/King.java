package game.pieces;

import game.PieceColor;
import game.Position;
import game.Tile;

import java.util.List;

/**
 * Created by mq on 2017-08-18.
 */
public class King extends Piece{

    public King(PieceColor pieceColor) {
        super(pieceColor, "King");
    }

    @Override
    public List<Position> getAvailableMoves(int x, int y, Tile[][] board) {
        return null;
    }
}
