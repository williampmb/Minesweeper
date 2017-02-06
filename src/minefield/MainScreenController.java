/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minefield;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import minesweeper.view.Tile;

/**
 *
 * @author William
 */
public class MainScreenController implements Initializable, ControlledScreen {

    ScreensController myController;
    @FXML
    AnchorPane apMain;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Circle dragger = new Circle(100, 100, 100);
        dragger.setFill(new RadialGradient(-0.3, 135, 0.5, 0.5, 1, true, CycleMethod.NO_CYCLE, new Stop[]{
            new Stop(0, Color.DARKGRAY),
            new Stop(1, Color.BLACK)
        }));

        Button close = new Button("Exit");
        close.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Minesweeper.primaryStage.close();
            }
        });

        Button start = new Button("Start Game");
        start.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                startGame();
            }
        });

        VBox vbButtons = new VBox();
        vbButtons.setSpacing(10);
        vbButtons.setAlignment(Pos.TOP_CENTER);
        vbButtons.setTranslateX(dragger.getCenterX());

        vbButtons.setTranslateY(dragger.getCenterY());
        vbButtons.getChildren().addAll(start, close);

        apMain.getChildren().addAll(dragger, vbButtons);

    }

    @Override
    public void setScreenController(ScreensController page) {
        myController = page;
    }

    public void startGame() {
        myController.setScreen(Minesweeper.gameScreenId);
        //TODO - change the stage size and reorganize nodes
        Minesweeper.primaryStage.setWidth(GameScreenController.COLS * Tile.TILESIZE);
        Minesweeper.primaryStage.setHeight(GameScreenController.ROWS * Tile.TILESIZE);

    }

}
