package game.pieces;

import game.PieceColor;
import game.Position;
import game.Tile;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mq on 2017-08-18.
 */
public class Rook extends Piece {

    public Rook(PieceColor pieceColor) {
        super(pieceColor, "Rook");
    }

    @Override
    public List<Position> getAvailableMoves(int x, int y, Tile[][] board, boolean[][] colorBoard) {
        List<Position> moveList = new ArrayList<>();

        int tmpX = x;
        int tmpY = y;
        boolean end = false;

        while(tmpX+1<8 && !end){
            tmpX++;
            moveList.add(new Position(tmpX, tmpY));
            if(!board[tmpY][tmpX].isFieldFree()){
                end = true;
            }
        }

        tmpX = x;
        tmpY = y;
        end = false;
        while(tmpY+1<8 && !end){
            tmpY++;
            moveList.add(new Position(tmpX, tmpY));
            if(!board[tmpY][tmpX].isFieldFree()){
                end = true;
            }
        }

        tmpX = x;
        tmpY = y;
        end = false;
        while(tmpX-1>=0 && !end){
            tmpX--;
            moveList.add(new Position(tmpX, tmpY));
            if(!board[tmpY][tmpX].isFieldFree()){
                end = true;
            }
        }

        tmpX = x;
        tmpY = y;
        end = false;
        while(tmpY-1>=0 && !end){
            tmpY--;
            moveList.add(new Position(tmpX, tmpY));
            if(!board[tmpY][tmpX].isFieldFree()){
                end = true;
            }
        }

        List<Position> tmpList = new ArrayList<>();
        for(Position position : moveList){
            PieceColor color = board[position.getY()][position.getX()].getPieceOnFieldColor();
            if(color == null){
                tmpList.add(position);
            }else{
                if(!color.equals(this.getPieceColor())){
                    tmpList.add(position);
                }
            }
        }
        moveList = tmpList;

        return moveList;
    }
}
