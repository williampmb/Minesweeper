/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minefield;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author William
 */
public class Minesweeper extends Application {

    public static Stage primaryStage;

    public static String mainScreenId = "main";
    public static String mainScreenFile = "MainScreen.fxml";
    public static String gameScreenId = "game";
    public static String gameScreenFile = "GameScreen.fxml";

    @Override
    public void start(Stage stage) {
        try {
            this.primaryStage = stage;
            primaryStage.initStyle(StageStyle.TRANSPARENT);

            ScreensController mainContainer = new ScreensController();

            mainContainer.loadScreen(mainScreenId, mainScreenFile);
            mainContainer.loadScreen(gameScreenId, gameScreenFile);

            mainContainer.setScreen(mainScreenId);

            Group root = new Group();
            root.getChildren().addAll(mainContainer);

            Scene scene = new Scene(root);
            scene.setFill(Color.TRANSPARENT);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
