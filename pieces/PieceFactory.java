package game.pieces;

import game.PieceColor;

/**
 * Created by mq on 2017-08-18.
 */
public class PieceFactory {
    public Piece createPiece(String typeOfPiece, PieceColor pieceColor){
        Piece piece = null;
        if(typeOfPiece.equals("Bishop")){
            piece = new Bishop(pieceColor);
        }else if(typeOfPiece.equals("King")){
            piece = new King(pieceColor);
        }else if(typeOfPiece.equals("Knight")){
            piece = new Knight(pieceColor);
        }else if(typeOfPiece.equals("Pawn")){
            piece = new Pawn(pieceColor);
        }else if(typeOfPiece.equals("Queen")){
            piece = new Queen(pieceColor);
        }else if(typeOfPiece.equals("Rook")){
            piece = new Rook(pieceColor);
        }
        return piece;
    }
}