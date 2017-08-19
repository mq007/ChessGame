package game.pieces;

import game.PieceColor;
import game.Move;

import java.util.List;

/**
 * Created by mq on 2017-08-18.
 */

public class Knight extends Piece {

    public Knight(PieceColor pieceColor) {
        super(pieceColor, "Knight");
    }

    @Override
    public List<Move> getAvailableMoves() {
        return null;
    }
}