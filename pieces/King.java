package game.pieces;

import game.PieceColor;
import game.Move;

import java.util.List;

/**
 * Created by mq on 2017-08-18.
 */
public class King extends Piece{

    public King(PieceColor pieceColor) {
        super(pieceColor, "King");
    }

    @Override
    public List<Move> getAvailableMoves() {
        return null;
    }
}
