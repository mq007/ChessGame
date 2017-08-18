package game.pieces;

import game.Color;
import game.Move;

import java.util.List;

/**
 * Created by mq on 2017-08-18.
 */
public class Bishop extends Piece {

    public Bishop(Color color) {
        super(color, "Bishop");
    }

    @Override
    public List<Move> getAvailableMoves() {
        return null;
    }
}
