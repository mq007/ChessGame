package game.controller;

import game.Game;
import game.Tile;
import javafx.fxml.FXML;
import javafx.geometry.Bounds;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Pane;


/**
 * Created by mq on 2017-08-18.
 */
public class ChessboardController {

    @FXML private Pane chessboard;
    @FXML private Pane mainpane;
    @FXML private Label topLabel;

    Tile startDragTile;
    Tile endDragTile;


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
                        startDragTile = tile;

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
                    Bounds size = tile.localToParent(tile.getBoundsInLocal());
                    startDragTile.getImage().relocate(size.getMinX(), size.getMinY());
                });
            }
        }
    }
}
