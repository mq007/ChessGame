package game.controller;

import game.Game;
import game.PieceImage;
import game.Tile;
import javafx.fxml.FXML;
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

    private PieceImage[] pieces;
    private Tile[][] board;

    Tile startingDragTile;

    @FXML
    void initialize() {
        Game game = new Game();
        game.setChessboard(chessboard);
        game.newGame();
        board = game.getBoard();
        pieces = game.getPieces();

        if (pieces == null){
            System.out.println("pieces null");
        }else{
            System.out.println("pieces not null");
        }

        for(int i=0; i<32; ++i){
            ImageView imageView = pieces[i];
            System.out.println("I: "+i);

            imageView.setOnDragDetected(e ->{
                Dragboard db = imageView.startDragAndDrop(TransferMode.ANY);
                ClipboardContent content = new ClipboardContent();
                content.putImage(imageView.getImage());
                db.setContent(content);
                e.consume();
            });

            imageView.setOnMouseEntered(e ->{
                imageView.setCursor(Cursor.HAND);
            });
        }

        for(int i=0; i<Game.WIDTH_BOARD; ++i){
            for (int j=0; j<Game.HEIGHT_BOARD; ++j){

            }
        }
    }
}
