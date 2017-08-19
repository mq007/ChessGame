package game.pieces;

import game.PieceColor;
import game.Move;

import java.util.List;

/**
 * Created by mq on 2017-08-18.
 */

public class Pawn extends Piece {

    public Pawn(PieceColor pieceColor) {
        super(pieceColor, "Pawn");
    }

    @Override
    public List<Move> getAvailableMoves() {
        return null;
    }
}
