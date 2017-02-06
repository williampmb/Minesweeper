/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper.view;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author William
 */
public class Tile extends Pane {

    int cellValue;
    Label label = new Label();
    Rectangle rec;
    boolean hit;
    public static int TILESIZE = 25;
    ImageView im;
    private static String BOMB_URL = "/minesweeper/image/bomb24.png";

    public int getCellValue() {
        return cellValue;
    }

    public void setCellValue(int cellValue) {
        this.cellValue = cellValue;
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public Rectangle getRec() {
        return rec;
    }

    public void setRec(Rectangle rec) {
        this.rec = rec;
    }

    public boolean isHit() {
        return hit;
    }

    public void setHit(boolean hit) {
        this.hit = hit;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }
    int posX, posY;

    public Tile(int value, int x, int y) {
        this.cellValue = value;
        this.hit = false;
        this.rec = new Rectangle(TILESIZE, TILESIZE);
        this.posX = x;
        this.posY = y;
        rec.setFill(Color.BLACK);

        getChildren().add(rec);
        label.translateXProperty().bind(widthProperty().subtract(label.widthProperty()).divide(2));
        label.translateYProperty().bind(heightProperty().subtract(label.heightProperty()).divide(2));
        getChildren().add(label);
    }

    public void showCellValue() {
        rec.setFill(Color.WHITE);
        label.setTextFill(Color.BLACK);
        if (cellValue == 0) {
            this.label.setText("");
        } else if (cellValue == -1) {
            try {
                Image a = new Image(BOMB_URL);
                im = new ImageView(a);
                getChildren().add(im);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (cellValue == 1) {
            label.setTextFill(Color.RED);
            this.label.setText("" + cellValue);
        } else if (cellValue == 2) {
            label.setTextFill(Color.BLUE);
            this.label.setText("" + cellValue);
        } else if (cellValue == 3) {
            label.setTextFill(Color.GREEN);
            this.label.setText("" + cellValue);
        } else if (cellValue == 4) {
            label.setTextFill(Color.YELLOW);
            this.label.setText("" + cellValue);
        } else if (cellValue == 5) {
            label.setTextFill(Color.CHOCOLATE);
            this.label.setText("" + cellValue);
        } else if (cellValue == 6) {
            label.setTextFill(Color.ORANGE);
            this.label.setText("" + cellValue);
        } else if (cellValue == 7) {
            label.setTextFill(Color.HOTPINK);
            this.label.setText("" + cellValue);
        } else if (cellValue == 8) {
            label.setTextFill(Color.CYAN);
            this.label.setText("" + cellValue);
        }

    }

}
