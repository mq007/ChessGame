package game.controller;

import game.Game;
import game.Tile;
import game.pieces.Piece;
import javafx.fxml.FXML;
import javafx.geometry.Bounds;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Pane;


/**
 * Created by mq on 2017-08-18.
 */
public class ChessboardController {

    @FXML private Pane chessboard;
    @FXML private Pane mainpane;
    @FXML private Label topLabel;


    @FXML
    void initialize() {
        Game game = new Game();
        game.setChessboard(chessboard);
        game.newGame();

        Tile[][] board = game.getBoard();

        for(int i=0; i<Game.WIDTH_BOARD; ++i){
            for (int j=0; j<Game.HEIGHT_BOARD; ++j){
                Tile tile = board[j][i];

                if(tile.getPiece() != null){
                    ImageView image = board[j][i].getImage();

                    image.setOnDragDetected(e -> {
                        Bounds size = image.localToParent(image.getBoundsInLocal());
                        System.out.println("detected x: " + size.getMinX() + " y: " + size.getMinY());
                        Dragboard db = image.startDragAndDrop(TransferMode.ANY);
                        ClipboardContent content = new ClipboardContent();

                        content.putImage(image.getImage());
                        db.setContent(content);

                        e.consume();
                    });

                    image.setOnMouseEntered(e -> {
                        image.setCursor(Cursor.HAND);
                    });
                }

                tile.setOnDragOver(e -> {
                    Dragboard db = e.getDragboard();
                    System.out.println("siejejejej");
                });
            }
        }
    }
}
