package game.pieces;

import game.PieceColor;
import game.Move;

import java.util.List;

/**
 * Created by mq on 2017-08-18.
 */
public class Bishop extends Piece {

    public Bishop(PieceColor pieceColor) {
        super(pieceColor, "Bishop");
    }

    @Override
    public List<Move> getAvailableMoves() {
        return null;
    }
}
