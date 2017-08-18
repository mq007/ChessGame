package game.pieces;

import game.Color;
import game.Move;

import java.util.List;

/**
 * Created by mq on 2017-08-18.
 */

public class Pawn extends Piece {

    public Pawn(Color color) {
        super(color, "Pawn");
    }

    @Override
    public List<Move> getAvailableMoves() {
        return null;
    }
}
