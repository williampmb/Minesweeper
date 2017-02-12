/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minefield;

import minesweeper.view.Tile;
import minesweeper.logical.Field;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author William
 */
public class GameScreenController implements Initializable, ControlledScreen {

    @FXML
    AnchorPane apMain;

    ScreensController myController;
    Field f;
    GridPane gpField;
    static List gridElements;
    private static int numbBombs = 100;
    public static int COLS = 50;
    public static int ROWS = 50;
    public static boolean inGame;

    double posIniX;
    double posIniY;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            GridPane gpField = new GridPane();
            f = new Field(ROWS, COLS, numbBombs);
            int col = f.getWidth();
            int row = f.getHeight();
            inGame = true;

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    int cell = f.getSpot(j, i);
                    Tile create = new Tile(cell, i, j);
                    gpField.add(create, j, i);
                    create.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            if (inGame) {
                                hit(create);
                            }
                        }

                    });
                    create.setOnKeyPressed(new EventHandler<KeyEvent>() {
                        @Override
                        public void handle(KeyEvent event) {
                            System.out.println(event.getCode() + " a");
                        }
                    });
                    create.setOnKeyPressed(new EventHandler<KeyEvent>() {
                        @Override
                        public void handle(KeyEvent event) {
                            System.out.println(event.getCode() + " a");
                        }
                    });

                }
            }
            gridElements = gpField.getChildren();

            gpField.setGridLinesVisible(true);
            apMain.getChildren().add(gpField);


            apMain.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent event) {
                    if (event.getCode().equals(KeyCode.ESCAPE)) {
                        returnMainScreen();
                    } else if (event.getCode().equals(KeyCode.SPACE)) {
                        restartGame();
                    }
                }

            });

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void hit(Tile target) {
        if (target.isHit()) {
            return;
        }
        target.showCellValue();
        target.setHit(true);
        if (target.getCellValue() == 0) {
            int x = target.getPosX();
            int y = target.getPosY();
            Tile around;
            for (Object cell : gridElements) {
                if (cell instanceof Tile) {
                    around = (Tile) cell;
                    boolean isAround = f.isAround(x, y, around.getPosX(), around.getPosY());
                    if (isAround) {
                        hit(around);
                    }
                }
            }
        } else if (target.getCellValue() > 0) {

        } else if (target.getCellValue() == -1) {

            gameOver();
        }

        win();
        apMain.requestFocus();

    }

    @Override
    public void setScreenController(ScreensController page) {
        myController = page;
    }

    private void gameOver() {
        inGame = false;
        apMain.getChildren().add(new Label("GAME OVER"));
    }

    private void win() {
        f.setHiddenTitles(f.getHiddenTitles() - 1);
        if (f.getBombs() == f.getHiddenTitles()) {
            inGame = false;
            apMain.getChildren().add(new Label("WIN!!"));
        }
    }

    private void returnMainScreen() {
        System.out.println("Return main Screen");
    }

    private void restartGame() {
        System.out.println("Restart Game");
    }

}
