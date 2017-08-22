package game.controller;

import game.*;
import game.pieces.Piece;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.util.List;


/**
 * Created by mq on 2017-08-18.
 */
public class ChessboardController {

    @FXML private Pane chessboard;
    @FXML private Pane mainpane;
    @FXML private Label topLabel;

    private PieceImage[] pieces;
    private Tile[][] board;
    private boolean [][] whiteBoard;
    private boolean [][] blackBoard;

    PieceImage droppingPiece;

    @FXML
    void initialize() {
        Game game = new Game();
        game.setChessboard(chessboard);
        game.newGame();
        board = game.getBoard();
        pieces = game.getPieces();
        whiteBoard = new boolean[8][8];
        blackBoard = new boolean[8][8];

        for(int i=0; i<32; ++i){
            PieceImage piece = pieces[i];

            piece.setOnDragDetected(e ->{
                droppingPiece = piece;
                Dragboard db = piece.startDragAndDrop(TransferMode.ANY);
                ClipboardContent content = new ClipboardContent();
                content.putImage(piece.getImage());
                db.setContent(content);
                e.consume();
            });

            piece.setOnMouseEntered(e ->{
                List<Position> positionList = piece.getPiece().getAvailableMoves(piece.getCoordX(), piece.getCoordY(), board, getColorBoard(piece.getPiece()));
                for(Position position : positionList){
                    board[position.getY()][position.getX()].setFill(Color.LIMEGREEN);
                }

                piece.setCursor(Cursor.HAND);
            });

            piece.setOnMouseExited(e ->{
                List<Position> positionList = piece.getPiece().getAvailableMoves(piece.getCoordX(), piece.getCoordY(), board, getColorBoard(piece.getPiece()));
                for(Position position : positionList){
                    board[position.getY()][position.getX()].resetColorOfTile();
                }
            });

            piece.setOnDragOver(e ->{
                e.acceptTransferModes(TransferMode.MOVE);
            });

            piece.setOnDragDropped(e ->{
                if(!piece.equals(droppingPiece) && !piece.getPiece().getPieceColor().equals(droppingPiece.getPiece().getPieceColor())){
                    droppingPiece.getPiece().incrementMoveCounter();

                    board[droppingPiece.getCoordY()][droppingPiece.getCoordX()].setPieceOnFieldColor(null);
                    board[piece.getCoordY()][piece.getCoordX()].setPieceOnFieldColor(droppingPiece.getPiece().getPieceColor());

                    board[droppingPiece.getCoordY()][droppingPiece.getCoordX()].setFieldFree(true);

                    droppingPiece.relocateByCoords(piece.getCoordX(), piece.getCoordY());
                    chessboard.getChildren().remove(piece);
                }
            });
        }

        for(int i=0; i<Game.WIDTH_BOARD; ++i){
            for (int j=0; j<Game.HEIGHT_BOARD; ++j){
                Tile tile = board[i][j];

                tile.setOnDragOver(e ->{
                    e.acceptTransferModes(TransferMode.ANY);
                });

                int finalI = i;
                int finalJ = j;
                tile.setOnDragDropped(e -> {
                    if(tile.isFieldFree()) {
                        droppingPiece.getPiece().incrementMoveCounter();

                        board[droppingPiece.getCoordY()][droppingPiece.getCoordX()].setFieldFree(true);
                        board[finalI][finalJ].setFieldFree(false);

                        board[droppingPiece.getCoordY()][droppingPiece.getCoordX()].setPieceOnFieldColor(null);
                        tile.setPieceOnFieldColor(droppingPiece.getPiece().getPieceColor());

                        droppingPiece.relocateByCoords(finalJ, finalI);
                    }

                    /*
                    for(int ii=0; ii<Game.WIDTH_BOARD; ++ii) {
                        for (int jj = 0; jj < Game.HEIGHT_BOARD; ++jj) {
                            Tile xx = board[ii][jj];
                            xx.resetColorOfTile();
                        }
                    }

                    for(int ii=0; ii<Game.WIDTH_BOARD; ++ii) {
                        for (int jj=0; jj<Game.HEIGHT_BOARD; ++jj) {
                            Tile tilex = board[ii][jj];
                            if(tilex.getPieceOnFieldColor() != null){
                                if(tilex.getPieceOnFieldColor().equals(PieceColor.BLACK)){
                                    tilex.setFill(Color.RED);
                                }
                                if(tilex.getPieceOnFieldColor().equals(PieceColor.WHITE)){
                                    tilex.setFill(Color.WHITE);
                                }
                            }
                        }
                    }
                    */
                });
            }
        }
    }

    public boolean[][] getColorBoard(Piece piece){
        if(piece.getPieceColor().equals(PieceColor.BLACK)){
            return blackBoard;
        }else{
            return whiteBoard;
        }
    }
}
