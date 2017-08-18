package game.scene;

import game.controller.ChessboardController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

import java.io.IOException;

/**
 * Created by mq on 2017-08-18.
 */
public class ChessboardScene {

    private Scene scene;
    private FXMLLoader loader;
    private ChessboardController chessboardController;

    public ChessboardScene(Scene scene) {
        this.scene = scene;
        setScene();
        setController();
    }

    private void setScene(){
        loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/game/fxml/chessboard.fxml"));

        try{
            Pane pane = loader.load();
            setController();
            scene.setRoot(pane);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private void setController(){
        chessboardController = loader.getController();
    }
}
