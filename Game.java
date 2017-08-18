package game;

import game.pieces.Piece;
import game.pieces.PieceFactory;

/**
 * Created by mq on 2017-08-18.
 */
public class Game {

    private Piece[][] board;

    public void newGame(){
        board = new Piece[8][8];

        PieceFactory pieceFactory = new PieceFactory();

        board[0][0] = pieceFactory.createPiece("Rook", Color.BLACK);
        board[0][1] = pieceFactory.createPiece("Knight", Color.BLACK);
        board[0][2] = pieceFactory.createPiece("Bishop", Color.BLACK);
        board[0][3] = pieceFactory.createPiece("Queen", Color.BLACK);
        board[0][4] = pieceFactory.createPiece("King", Color.BLACK);
        board[0][5] = pieceFactory.createPiece("Bishop", Color.BLACK);
        board[0][6] = pieceFactory.createPiece("Knight", Color.BLACK);
        board[0][7] = pieceFactory.createPiece("Rook", Color.BLACK);

        board[1][0] = pieceFactory.createPiece("Pawn", Color.BLACK);
        board[1][1] = pieceFactory.createPiece("Pawn", Color.BLACK);
        board[1][2] = pieceFactory.createPiece("Pawn", Color.BLACK);
        board[1][3] = pieceFactory.createPiece("Pawn", Color.BLACK);
        board[1][4] = pieceFactory.createPiece("Pawn", Color.BLACK);
        board[1][5] = pieceFactory.createPiece("Pawn", Color.BLACK);
        board[1][6] = pieceFactory.createPiece("Pawn", Color.BLACK);
        board[1][7] = pieceFactory.createPiece("Pawn", Color.BLACK);

        board[6][0] = pieceFactory.createPiece("Pawn", Color.WHITE);
        board[6][1] = pieceFactory.createPiece("Pawn", Color.WHITE);
        board[6][2] = pieceFactory.createPiece("Pawn", Color.WHITE);
        board[6][3] = pieceFactory.createPiece("Pawn", Color.WHITE);
        board[6][4] = pieceFactory.createPiece("Pawn", Color.WHITE);
        board[6][5] = pieceFactory.createPiece("Pawn", Color.WHITE);
        board[6][6] = pieceFactory.createPiece("Pawn", Color.WHITE);
        board[6][7] = pieceFactory.createPiece("Pawn", Color.WHITE);

        board[7][0] = pieceFactory.createPiece("Rook", Color.WHITE);
        board[7][0] = pieceFactory.createPiece("Knight", Color.WHITE);
        board[7][0] = pieceFactory.createPiece("Bishop", Color.WHITE);
        board[7][0] = pieceFactory.createPiece("Queen", Color.WHITE);
        board[7][0] = pieceFactory.createPiece("King", Color.WHITE);
        board[7][0] = pieceFactory.createPiece("Bishop", Color.WHITE);
        board[7][0] = pieceFactory.createPiece("Knight", Color.WHITE);
        board[7][0] = pieceFactory.createPiece("Rook", Color.WHITE);

    }

    public Piece[][] getBoard() {
        return board;
    }

    public void setBoard(Piece[][] board) {
        this.board = board;
    }
}
