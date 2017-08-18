package game.pieces;

import game.Color;
import game.Move;

import java.util.List;

/**
 * Created by mq on 2017-08-18.
 */

public class Knight extends Piece {

    public Knight(Color color) {
        super(color, "Knight");
    }

    @Override
    public List<Move> getAvailableMoves() {
        return null;
    }
}