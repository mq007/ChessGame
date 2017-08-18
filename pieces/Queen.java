package game.pieces;

import game.Color;
import game.Move;

import java.util.List;

/**
 * Created by mq on 2017-08-18.
 */

public class Queen extends Piece {

    public Queen(Color color) {
        super(color, "Queen");
    }

    @Override
    public List<Move> getAvailableMoves() {
        return null;
    }
}
