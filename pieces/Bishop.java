package game.pieces;

import game.PieceColor;
import game.Position;
import game.Tile;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mq on 2017-08-18.
 */
public class Bishop extends Piece {

    public Bishop(PieceColor pieceColor) {
        super(pieceColor, "Bishop");
    }

    @Override
    public List<Position> getAvailableMoves(int x, int y, Tile[][] board) {
        List<Position> bishopMoveList = new ArrayList<>();
        int tmpX = x;
        int tmpY = y;
        boolean end = false;

        while(tmpX+1<8 && tmpY+1<8 && !end){
            tmpX++;
            tmpY++;
            bishopMoveList.add(new Position(tmpX, tmpY));
            if(!board[tmpY][tmpX].isFieldFree()){
                end = true;
            }
        }

        tmpX = x;
        tmpY = y;
        end = false;
        while(tmpX+1<8 && tmpY-1>=0 && !end){
            tmpX++;
            tmpY--;
            bishopMoveList.add(new Position(tmpX, tmpY));
            if(!board[tmpY][tmpX].isFieldFree()){
                end = true;
            }
        }

        tmpX = x;
        tmpY = y;
        end = false;
        while(tmpX-1>=0 && tmpY-1>=0 && !end){
            tmpX--;
            tmpY--;
            bishopMoveList.add(new Position(tmpX, tmpY));
            if(!board[tmpY][tmpX].isFieldFree()){
                end = true;
            }
        }

        tmpX = x;
        tmpY = y;
        end = false;
        while(tmpX-1>=0 && tmpY+1<8 && !end){
            tmpX--;
            tmpY++;
            bishopMoveList.add(new Position(tmpX, tmpY));
            if(!board[tmpY][tmpX].isFieldFree()){
                end = true;
            }
        }

        //check if on this position is your own color piece

        return bishopMoveList;
    }
}
