package game;

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
    private PieceImage [] pieces;

    public void newGame(){
        board = new Tile[8][8];
        pieces = new PieceImage[32];
        prepareChessboard();
        preparePieces();
    }

    private void preparePieces(){

        PieceFactory pieceFactory = new PieceFactory();

        pieces[0] = new PieceImage(pieceFactory.createPiece("Rook", PieceColor.BLACK), chessboard, 0,0);
        pieces[1] = new PieceImage(pieceFactory.createPiece("Knight", PieceColor.BLACK), chessboard, 0, 1);
        pieces[2] = new PieceImage(pieceFactory.createPiece("Bishop", PieceColor.BLACK), chessboard, 0, 2);
        pieces[3] = new PieceImage(pieceFactory.createPiece("Queen", PieceColor.BLACK), chessboard, 0, 3);
        pieces[4] = new PieceImage(pieceFactory.createPiece("King", PieceColor.BLACK), chessboard, 0, 4);
        pieces[5] = new PieceImage(pieceFactory.createPiece("Bishop", PieceColor.BLACK), chessboard, 0, 5);
        pieces[6] = new PieceImage(pieceFactory.createPiece("Knight", PieceColor.BLACK), chessboard, 0, 6);
        pieces[7] = new PieceImage(pieceFactory.createPiece("Rook", PieceColor.BLACK), chessboard, 0, 7);

        pieces[8] = new PieceImage(pieceFactory.createPiece("Pawn", PieceColor.BLACK), chessboard,1, 0);
        pieces[9] = new PieceImage(pieceFactory.createPiece("Pawn", PieceColor.BLACK), chessboard, 1, 1);
        pieces[10] = new PieceImage(pieceFactory.createPiece("Pawn", PieceColor.BLACK), chessboard, 1, 2);
        pieces[11] = new PieceImage(pieceFactory.createPiece("Pawn", PieceColor.BLACK), chessboard, 1, 3);
        pieces[12] = new PieceImage(pieceFactory.createPiece("Pawn", PieceColor.BLACK), chessboard, 1, 4);
        pieces[13] = new PieceImage(pieceFactory.createPiece("Pawn", PieceColor.BLACK), chessboard,1, 5);
        pieces[14] = new PieceImage(pieceFactory.createPiece("Pawn", PieceColor.BLACK), chessboard,1, 6);
        pieces[15] = new PieceImage(pieceFactory.createPiece("Pawn", PieceColor.BLACK), chessboard,1, 7);

        pieces[16] = new PieceImage(pieceFactory.createPiece("Rook", PieceColor.WHITE), chessboard, 6, 0);
        pieces[17] = new PieceImage(pieceFactory.createPiece("Knight", PieceColor.WHITE), chessboard, 6, 1);
        pieces[18] = new PieceImage(pieceFactory.createPiece("Bishop", PieceColor.WHITE), chessboard,6, 2);
        pieces[19] = new PieceImage(pieceFactory.createPiece("Queen", PieceColor.WHITE), chessboard,6, 3);
        pieces[20] = new PieceImage(pieceFactory.createPiece("King", PieceColor.WHITE), chessboard,6, 4);
        pieces[21] = new PieceImage(pieceFactory.createPiece("Bishop", PieceColor.WHITE), chessboard,6, 5);
        pieces[22] = new PieceImage(pieceFactory.createPiece("Knight", PieceColor.WHITE), chessboard,6, 6);
        pieces[23] = new PieceImage(pieceFactory.createPiece("Rook", PieceColor.WHITE), chessboard,6, 7);

        pieces[24] = new PieceImage(pieceFactory.createPiece("Pawn", PieceColor.WHITE), chessboard,7, 0);
        pieces[25] = new PieceImage(pieceFactory.createPiece("Pawn", PieceColor.WHITE), chessboard,7, 1);
        pieces[26] = new PieceImage(pieceFactory.createPiece("Pawn", PieceColor.WHITE), chessboard,7, 2 );
        pieces[27] = new PieceImage(pieceFactory.createPiece("Pawn", PieceColor.WHITE), chessboard,7, 3);
        pieces[28] = new PieceImage(pieceFactory.createPiece("Pawn", PieceColor.WHITE), chessboard,7, 4);
        pieces[29] = new PieceImage(pieceFactory.createPiece("Pawn", PieceColor.WHITE), chessboard,7, 5);
        pieces[30] = new PieceImage(pieceFactory.createPiece("Pawn", PieceColor.WHITE), chessboard, 7, 6);
        pieces[31] = new PieceImage(pieceFactory.createPiece("Pawn", PieceColor.WHITE), chessboard,7, 7);

    }

    private void prepareChessboard(){
        boolean isBlack = true;
        for(int i=0; i<WIDTH_BOARD; ++i){
            for(int j=0; j<HEIGHT_BOARD; ++j){
                Tile tile = new Tile(isBlack, i, j);
                board[i][j] = tile;
                chessboard.getChildren().add(tile);
                isBlack = !isBlack;
            }
            isBlack = !isBlack;
        }
    }

    public Tile[][] getBoard() {
        return board;
    }

    public void setBoard(Tile[][] board) {
        this.board = board;
    }

    public Pane getChessboard() {
        return chessboard;
    }

    public void setChessboard(Pane chessboard) {
        this.chessboard = chessboard;
    }

    public PieceImage[] getPieces() {
        return pieces;
    }

    public void setPieces(PieceImage[] pieces) {
        this.pieces = pieces;
    }
}
