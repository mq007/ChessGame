package game.pieces;

import game.PieceColor;
import game.Position;
import game.Tile;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mq on 2017-08-18.
 */
public class King extends Piece{

    public King(PieceColor pieceColor) {
        super(pieceColor, "King");
    }

    @Override
    public List<Position> getAvailableMoves(int x, int y, Tile[][] board) {
        List<Position> moveList = new ArrayList<>();

        if (x+1<8) {
            moveList.add(new Position(x+1,y));
            if(y+1<8){
                moveList.add(new Position(x+1, y+1));
                moveList.add(new Position(x, y+1));
            }
            if(y-1<8){
                moveList.add(new Position(x+1, y-1));
                moveList.add(new Position(x, y-1));
            }
        }
        if(x-1>=0){
            moveList.add(new Position(x-1,y));
            if(y+1<8){
                moveList.add(new Position(x-1, y+1));
            }
            if(y-1>=0){
                moveList.add(new Position(x-1, y-1));
            }
        }

        return moveList;
    }
}
