package game.pieces;

import game.Color;
import game.Move;

import java.util.List;

/**
 * Created by mq on 2017-08-18.
 */
public class King extends Piece{

    public King(Color color) {
        super(color, "King");
    }

    @Override
    public List<Move> getAvailableMoves() {
        return null;
    }
}
