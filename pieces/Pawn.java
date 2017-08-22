package game.pieces;

import game.PieceColor;
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
    public List<Position> getAvailableMoves(int x, int y, Tile[][] board, boolean[][] colorBoard) {
        List<Position> moveList = new ArrayList<>();

        if(getPieceColor().equals(PieceColor.BLACK)){
            if(y+1<8){
                if(board[y+1][x].isFieldFree()){
                    moveList.add(new Position(x, y+1));
                }
                if(x-1>=0 && !board[y+1][x-1].isFieldFree()){
                    moveList.add(new Position(x-1, y+1));
                }
                if(x+1<8 && !board[y+1][x+1].isFieldFree()){
                    moveList.add(new Position(x+1, y+1));
                }
            }
            if(y+2<8){
                if(getMoveCounter() == 0 && board[y+2][x].isFieldFree()){
                    moveList.add(new Position(x, y+2));
                }
            }
        }else{
            if(y-1>=0){
                if(board[y-1][x].isFieldFree()){
                    moveList.add(new Position(x, y-1));
                }
                if(x-1>=0 && !board[y-1][x-1].isFieldFree()){
                    moveList.add(new Position(x-1, y-1));
                }
                if(x+1<8 && !board[y-1][x+1].isFieldFree()){
                    moveList.add(new Position(x+1, y-1));
                }
            }
            if(y-2>=0){
                if(getMoveCounter() == 0 && board[y-2][x].isFieldFree()){
                    moveList.add(new Position(x, y-2));
                }
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
