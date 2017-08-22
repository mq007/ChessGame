package game.pieces;

import game.PieceColor;
import game.Position;
import game.Tile;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mq on 2017-08-18.
 */

public class Queen extends Piece {

    public Queen(PieceColor pieceColor) {
        super(pieceColor, "Queen");
    }

    @Override
    public List<Position> getAvailableMoves(int x, int y, Tile[][] board) {
        List<Position> moveList = new ArrayList<>();

        Rook pieceRook = new Rook(getPieceColor());
        List<Position> rookMoves = pieceRook.getAvailableMoves(x,y,board);

        Bishop pieceBishop = new Bishop(getPieceColor());
        List<Position> bishopMoves = pieceBishop.getAvailableMoves(x,y,board);

        moveList.addAll(rookMoves);
        moveList.addAll(bishopMoves);

        return moveList;
    }
}
