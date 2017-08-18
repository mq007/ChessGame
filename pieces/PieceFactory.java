package game.pieces;

import game.Color;

/**
 * Created by mq on 2017-08-18.
 */
public class PieceFactory {
    public Piece createPiece(String typeOfPiece, Color color){
        Piece piece = null;
        if(typeOfPiece.equals("Bishop")){
            piece = new Bishop(color);
        }else if(typeOfPiece.equals("King")){
            piece = new King(color);
        }else if(typeOfPiece.equals("Knight")){
            piece = new Knight(color);
        }else if(typeOfPiece.equals("Pawn")){
            piece = new Pawn(color);
        }else if(typeOfPiece.equals("Queen")){
            piece = new Queen(color);
        }else if(typeOfPiece.equals("Rook")){
            piece = new Rook(color);
        }
        return piece;
    }
}