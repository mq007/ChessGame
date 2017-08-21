package game.pieces;

import game.PieceColor;
import game.Position;
import game.Tile;

import java.util.List;

/**
 * Created by mq on 2017-08-18.
 */
public class Rook extends Piece {

    public Rook(PieceColor pieceColor) {
        super(pieceColor, "Rook");
    }

    @Override
    public List<Position> getAvailableMoves(int x, int y, Tile[][] board) {
        return null;
    }
}
