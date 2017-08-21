package game.pieces;

import game.PieceColor;
import game.Move;
import game.Position;
import game.Tile;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mq on 2017-08-18.
 */

public class Pawn extends Piece {

    public Pawn(PieceColor pieceColor) {
        super(pieceColor, "Pawn");
    }

    @Override
    public List<Position> getAvailableMoves(int x, int y, Tile[][] board) {
        List<Position> moveList = new ArrayList<>();

        if(getPieceColor().equals(PieceColor.BLACK)){
            if(y+1 < 8 && board[y+1][x].isFieldFree()){
                moveList.add(new Position(x, y+1));
            }
            if(y+2 < 8 && getMoveCounter() == 0 && board[y+2][x].isFieldFree()){
                moveList.add(new Position(x, y+2));
            }
            if(!board[y+1][x-1].isFieldFree()){
                moveList.add(new Position(x-1, y+1));
            }
            if(!board[y+1][x+1].isFieldFree()){
                moveList.add(new Position(x+1, y+1));
            }
        }else{
            if(board[y-1][x].isFieldFree()){
                moveList.add(new Position(x, y-1));
            }
            if(getMoveCounter() == 0 && board[y-2][x].isFieldFree()){
                moveList.add(new Position(x, y-2));
            }
            if(!board[y-1][x-1].isFieldFree()){
                moveList.add(new Position(x-1, y-1));
            }
            if(!board[y-1][x+1].isFieldFree()){
                moveList.add(new Position(x+1, y-1));
            }
        }

        for(Position position : moveList){
            if(position.getY()>7 || position.getY()<0 || position.getX()>7 || position.getX()<0){
                moveList.remove(position);
            }
        }

        return moveList;
    }
}
