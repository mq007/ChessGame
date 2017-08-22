package game.controller;

import game.Game;
import game.PieceImage;
import game.Position;
import game.Tile;
import game.pieces.Bishop;
import game.pieces.Pawn;
import game.pieces.Rook;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Pane;

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

    PieceImage droppingPiece;

    @FXML
    void initialize() {
        Game game = new Game();
        game.setChessboard(chessboard);
        game.newGame();
        board = game.getBoard();
        pieces = game.getPieces();

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
                if(piece.getPiece() instanceof Pawn){
                    System.out.println("Pionek: ");
                    List<Position> positionList = piece.getPiece().getAvailableMoves(piece.getCoordX(), piece.getCoordY(), board);
                    for(Position position : positionList){
                        System.out.println("[" + position.getY() + "][" + position.getX() + "]");
                    }
                }
                if(piece.getPiece() instanceof Bishop){
                    System.out.println("Bishop: ");
                    List<Position> positionList = piece.getPiece().getAvailableMoves(piece.getCoordX(), piece.getCoordY(), board);
                    for(Position position : positionList){
                        System.out.println("[" + position.getY() + "][" + position.getX() + "]");
                    }
                }
                if(piece.getPiece() instanceof Rook){
                    System.out.println("Rook: ");
                    List<Position> positionList = piece.getPiece().getAvailableMoves(piece.getCoordX(), piece.getCoordY(), board);
                    for(Position position : positionList){
                        System.out.println("[" + position.getY() + "][" + position.getX() + "]");
                    }
                }
                piece.setCursor(Cursor.HAND);
            });

            piece.setOnDragOver(e ->{
                e.acceptTransferModes(TransferMode.MOVE);
            });

            piece.setOnDragDropped(e ->{
                if(!piece.equals(droppingPiece)){
                    droppingPiece.getPiece().incrementMoveCounter();
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
                        droppingPiece.relocateByCoords(finalJ, finalI);
                    }
                });
            }
        }
    }
}
