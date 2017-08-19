package game.pieces;

import game.PieceColor;
import game.Move;

import java.util.List;

/**
 * Created by mq on 2017-08-18.
 */

public class Queen extends Piece {

    public Queen(PieceColor pieceColor) {
        super(pieceColor, "Queen");
    }

    @Override
    public List<Move> getAvailableMoves() {
        return null;
    }
}
