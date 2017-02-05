/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minefield.logical;

import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author William
 */
public class Field {

    private int[][] field;
    private int bombs;
    private int width;
    private int height;

    public int[][] getField() {
        return field;
    }

    public void setField(int[][] field) {
        this.field = field;
    }

    public int getBombs() {
        return bombs;
    }

    public void setBombs(int bombs) {
        this.bombs = bombs;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Field(int height, int width, int bombs) {
        this.field = new int[height][width];
        this.height = height;
        this.width = width;
        this.bombs = bombs;
        createField();
    }

    public int getSpot(int col, int row) {
        return field[row][col];
    }

    private void createField() {
        plantTheBombs();
        configField();
    }

    private void plantTheBombs() {
        while (bombs != 0) {
            int col = ThreadLocalRandom.current().nextInt(0, width - 1);
            int row = ThreadLocalRandom.current().nextInt(0, height - 1);
            if (field[row][col] != -1) {
                field[row][col] = -1;
                bombs--;
            }
        }
    }

    private void configField() {
        for (int col = 0; col < width; col++) {
            for (int row = 0; row < height; row++) {
                int checkBomb = field[row][col];
                if (checkBomb != -1) {
                    int alert = countBombsAround(row, col);
                    field[row][col] = alert;
                }

            }
        }
    }

    private int countBombsAround(int row, int col) {
        int bombs = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (row + i < 0 || row + i >= height || col + j < 0 || col + j >= width) {
                    continue;
                } else {
                    int check = field[row + i][col + j];
                    if (check == -1) {
                        bombs++;
                    }
                }
            }
        }
        return bombs;
    }

    public boolean isAround(int targetX, int targetY, int posX, int posY) {
        if (targetX == posX && targetY == posY) {
            return false;
        } else if (targetX >= posX - 1 && targetX <= posX + 1
                && targetY >= posY - 1 && targetY <= posY + 1) {
            return true;
        }
        return false;
    }
    
        void printMatrix() {
        for (int row = 0; row < width; row++) {
            System.out.print("[");
            for (int col = 0; col < height; col++) {
                System.out.print(field[row][col] + "\t");
            }
            System.out.println("]");

        }

    }
}
