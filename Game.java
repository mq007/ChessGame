package game;

import game.pieces.Piece;
import game.pieces.PieceFactory;
import javafx.scene.layout.Pane;

/**
 * Created by mq on 2017-08-18.
 */
public class Game {

    public static final int TILE_SIZE = 80;
    public static final int HEIGHT_BOARD = 8;
    public static final int WIDTH_BOARD = 8;

    private Tile[][] board;
    private Pane chessboard;

    public void newGame(){
        board = new Tile[8][8];
        prepareChessboard();
        preparePieces();
    }

    private void preparePieces(){

        boolean isBlack = true;
        for(int i=0; i<Game.WIDTH_BOARD; ++i){
            for(int j=0; j<Game.HEIGHT_BOARD; ++j){
                board[j][i] = new Tile(isBlack, i, j);
                board[j][i].setChessboard(chessboard);
                isBlack = !isBlack;
            }
            isBlack = !isBlack;
        }

        PieceFactory pieceFactory = new PieceFactory();
        board[0][0].setPiece(pieceFactory.createPiece("Rook", PieceColor.BLACK));
        board[0][1].setPiece(pieceFactory.createPiece("Knight", PieceColor.BLACK));
        board[0][2].setPiece(pieceFactory.createPiece("Bishop", PieceColor.BLACK));
        board[0][3].setPiece(pieceFactory.createPiece("Queen", PieceColor.BLACK));
        board[0][4].setPiece(pieceFactory.createPiece("King", PieceColor.BLACK));
        board[0][5].setPiece(pieceFactory.createPiece("Bishop", PieceColor.BLACK));
        board[0][6].setPiece(pieceFactory.createPiece("Knight", PieceColor.BLACK));
        board[0][7].setPiece(pieceFactory.createPiece("Rook", PieceColor.BLACK));

        board[1][0].setPiece(pieceFactory.createPiece("Pawn", PieceColor.BLACK));
        board[1][1].setPiece(pieceFactory.createPiece("Pawn", PieceColor.BLACK));
        board[1][2].setPiece(pieceFactory.createPiece("Pawn", PieceColor.BLACK));
        board[1][3].setPiece(pieceFactory.createPiece("Pawn", PieceColor.BLACK));
        board[1][4].setPiece(pieceFactory.createPiece("Pawn", PieceColor.BLACK));
        board[1][5].setPiece(pieceFactory.createPiece("Pawn", PieceColor.BLACK));
        board[1][6].setPiece(pieceFactory.createPiece("Pawn", PieceColor.BLACK));
        board[1][7].setPiece(pieceFactory.createPiece("Pawn", PieceColor.BLACK));

        board[6][0].setPiece(pieceFactory.createPiece("Pawn", PieceColor.WHITE));
        board[6][1].setPiece(pieceFactory.createPiece("Pawn", PieceColor.WHITE));
        board[6][2].setPiece(pieceFactory.createPiece("Pawn", PieceColor.WHITE));
        board[6][3].setPiece(pieceFactory.createPiece("Pawn", PieceColor.WHITE));
        board[6][4].setPiece(pieceFactory.createPiece("Pawn", PieceColor.WHITE));
        board[6][5].setPiece(pieceFactory.createPiece("Pawn", PieceColor.WHITE));
        board[6][6].setPiece(pieceFactory.createPiece("Pawn", PieceColor.WHITE));
        board[6][7].setPiece(pieceFactory.createPiece("Pawn", PieceColor.WHITE));

        board[7][0].setPiece(pieceFactory.createPiece("Rook", PieceColor.WHITE));
        board[7][1].setPiece(pieceFactory.createPiece("Knight", PieceColor.WHITE));
        board[7][2].setPiece(pieceFactory.createPiece("Bishop", PieceColor.WHITE));
        board[7][3].setPiece(pieceFactory.createPiece("Queen", PieceColor.WHITE));
        board[7][4].setPiece(pieceFactory.createPiece("King", PieceColor.WHITE));
        board[7][5].setPiece(pieceFactory.createPiece("Bishop", PieceColor.WHITE));
        board[7][6].setPiece(pieceFactory.createPiece("Knight", PieceColor.WHITE));
        board[7][7].setPiece(pieceFactory.createPiece("Rook", PieceColor.WHITE));
    }

    private void prepareChessboard(){
        boolean isBlack = true;
        for(int i=0; i<HEIGHT_BOARD; ++i){
            for(int j=0; j<WIDTH_BOARD; ++j){
                isBlack = !isBlack;
                Tile tile = new Tile(isBlack, i, j);
                chessboard.getChildren().add(tile);
            }
            isBlack = !isBlack;
        }
    }

    public Tile[][] getBoard() {
        return board;
    }

    public Pane getChessboard() {
        return chessboard;
    }

    public void setChessboard(Pane chessboard) {
        this.chessboard = chessboard;
    }

    public void setBoard(Tile[][] board) {
        this.board = board;
    }
}
