package game.controller;

import game.Game;
import game.PieceImage;
import game.Tile;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;


/**
 * Created by mq on 2017-08-18.
 */
public class ChessboardController {

    @FXML private Pane chessboard;
    @FXML private Pane mainpane;
    @FXML private Label topLabel;

    private PieceImage[] pieces;
    private Tile[][] board;

    PieceImage droppingPiece;

    @FXML
    void initialize() {
        Game game = new Game();
        game.setChessboard(chessboard);
        game.newGame();
        board = game.getBoard();
        pieces = game.getPieces();

        for(int i=0; i<32; ++i){
            PieceImage pieceImage = pieces[i];

            pieceImage.setOnDragDetected(e ->{
                droppingPiece = pieceImage;
                Dragboard db = pieceImage.startDragAndDrop(TransferMode.ANY);
                ClipboardContent content = new ClipboardContent();
                content.putImage(pieceImage.getImage());
                db.setContent(content);
                e.consume();
            });

            pieceImage.setOnMouseEntered(e ->{
                pieceImage.setCursor(Cursor.HAND);
            });

            pieceImage.setOnDragOver(e ->{
                e.acceptTransferModes(TransferMode.MOVE);
            });

            pieceImage.setOnDragDropped(e ->{
                if(!pieceImage.equals(droppingPiece)){
                    board[droppingPiece.getCoordX()][droppingPiece.getCoordY()].setFieldFree(true);
                    droppingPiece.relocateByCoords(pieceImage.getCoordX(), pieceImage.getCoordY());
                    chessboard.getChildren().remove(pieceImage);
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
                        board[droppingPiece.getCoordY()][droppingPiece.getCoordX()].setFieldFree(true);
                        board[finalI][finalJ].setFieldFree(false);
                        droppingPiece.relocateByCoords(finalJ, finalI);
                    }
                });
            }
        }
    }
}
