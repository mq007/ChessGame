package game.pieces;

import game.PieceColor;
import game.Position;
import game.Tile;

import java.util.List;

/**
 * Created by mq on 2017-08-18.
 */

public class Knight extends Piece {

    public Knight(PieceColor pieceColor) {
        super(pieceColor, "Knight");
    }

    @Override
    public List<Position> getAvailableMoves(int x, int y, Tile[][] board) {
        return null;
    }
}