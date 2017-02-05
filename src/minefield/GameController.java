/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minefield;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

/**
 *
 * @author William
 */
public class GameController implements Initializable {

    @FXML
    AnchorPane apMain;

    Field f;
    GridPane gpField;
    static List gridElements;
    private static int numbBombs = 10;
    private static int cols = 20;
    private static int rows = 5;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        GridPane gpField = new GridPane();
        f = new Field(rows, cols, numbBombs);
        int col = f.getWidth();
        int row = f.getHeight();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int cell = f.getSpot( j,i);
                Tile create = new Tile(cell, i, j);
                gpField.add(create, j, i);
                create.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        hit(create);
                    }

                });

            }
        }
        gridElements = gpField.getChildren();
        gpField.setAlignment(Pos.CENTER_RIGHT);
        gpField.setGridLinesVisible(true);
        apMain.getChildren().add(gpField);

        gpField.translateXProperty().bind(apMain.widthProperty().subtract(gpField.widthProperty()).divide(2));
        gpField.translateYProperty().bind(apMain.heightProperty().subtract(gpField.heightProperty()).divide(2));
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
            System.out.println("Game Over");
        }

    }

}
