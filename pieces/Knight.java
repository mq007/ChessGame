package game.pieces;

import game.PieceColor;
import game.Position;
import game.Tile;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mq on 2017-08-18.
 */

public class Knight extends Piece {

    public Knight(PieceColor pieceColor) {
        super(pieceColor, "Knight");
    }

    @Override
    public List<Position> getAvailableMoves(int x, int y, Tile[][] board) {
        List<Position> moveList = new ArrayList<>();

        if(y+2<8){
            if(x+1<8){
                moveList.add(new Position(x+1, y+2));
            }
            if(x-1>=0){
                moveList.add(new Position(x-1, y+2));
            }
        }

        if(y-2>=0){
            if(x+1<8){
                moveList.add(new Position(x+1, y-2));
            }
            if(x-1>=0){
                moveList.add(new Position(x-1, y-2));
            }
        }

        if(x+2<8){
            if(y+1<8){
                moveList.add(new Position(x+2, y+1));
            }
            if(y-1>=0){
                moveList.add(new Position(x+2, y-1));
            }
        }

        if(x-2>=0){
            if(y+1<8){
                moveList.add(new Position(x-2, y+1));
            }
            if(y-1>=0){
                moveList.add(new Position(x-2, y-1));
            }
        }

        return moveList;
    }
}