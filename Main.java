package game;

import game.scene.ChessboardScene;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by mq on 2017-08-18.
 */
public class Main extends Application{
    private Stage window;

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Szachy by mq");
        Scene scene = new Scene(new VBox(), 1024, 768);
        window.setScene(scene);
        new ChessboardScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
