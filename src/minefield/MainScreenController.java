/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minefield;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import minefield.view.Tile;

/**
 *
 * @author William
 */
public class MainScreenController implements Initializable, ControlledScreen {

    ScreensController myController;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    @Override
    public void setScreenController(ScreensController page) {
        myController = page;
    }

    @FXML
    public void startGame(ActionEvent e) {
        myController.setScreen(Minesweeper.gameScreenId);
        //TODO - change the stage size and reorganize nodes
        Minesweeper.primaryStage.setWidth(600);
        Minesweeper.primaryStage.setHeight(600);

    }

}
