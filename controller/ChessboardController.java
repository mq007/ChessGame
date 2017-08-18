package game.controller;

import game.Game;
import game.pieces.Piece;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Created by mq on 2017-08-18.
 */
public class ChessboardController {

    @FXML private ImageView chessboard;
    @FXML private Label topLabel;
    @FXML private ImageView a8;


    @FXML
    void initialize() {
        Game game = new Game();
        game.newGame();

        Piece[][] board = game.getBoard();

        setUpImages(board);
    }

    private void setUpImages(Piece[][] board){
        chessboard.setImage(new Image("/game/resources/chessboard.jpg"));
        a8.setImage(board[0][0].getImage());
    }
}
