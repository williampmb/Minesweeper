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
import javafx.stage.Stage;

/**
 *
 * @author William
 */
public class Minesweeper extends Application {
    
    public static Stage primaryStage;
    
    //public static String mainScreenId = "main";
    //public static String mainScreenFile = "Main.fxml";
    public static String gameScreenId = "game";
    public static String gameScreenFile = "GameScreen.fxml";
    //TODO - how i will deal with gameover message.
    
    @Override
    public void start(Stage stage) throws Exception {
        try{
            this.primaryStage = stage;
        
        
        ScreensController mainContainer = new ScreensController();
        
       // mainContainer.loadScreen(mainScreenId, mainScreenFile);
        mainContainer.loadScreen(Minesweeper.gameScreenId, Minesweeper.gameScreenFile);
        
        //mainContainer.setScreen(mainScreenId);
        mainContainer.setScreen(gameScreenId);
        
        
        Group root = new Group();
        root.getChildren().addAll(mainContainer);
        //Parent root = FXMLLoader.load(getClass().getResource("GameScreen.fxml"));
    
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        }catch (Exception e){
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
