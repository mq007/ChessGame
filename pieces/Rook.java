package game.pieces;

import game.PieceColor;
import game.Move;

import java.util.List;

/**
 * Created by mq on 2017-08-18.
 */
public class Rook extends Piece {

    public Rook(PieceColor pieceColor) {
        super(pieceColor, "Rook");
    }

    @Override
    public List<Move> getAvailableMoves() {
        return null;
    }
}
