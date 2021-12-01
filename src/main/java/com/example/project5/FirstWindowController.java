package com.example.project5;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class FirstWindowController {
    @FXML
    private Label welcomeText;


    @FXML
    public void handleOpenChuckNorris(ActionEvent event){
        var secondLoc = new FXMLLoader(FirstWindowApplication.class.getResource("ChuckNorrisWindow.fxml"));
        Scene secondScene = null;
        try{
            secondScene = new Scene(secondLoc.load(), 900, 600);
        }catch (IOException e){
            System.out.println("Couldn't load second window");
            e.printStackTrace();
        }
        Stage secondWindow = new Stage();
        secondWindow.setScene(secondScene);
        secondWindow.setTitle("See  - here is a second window");
        secondWindow.show();
    }

    @FXML
    public void handleClose(ActionEvent event){
        System.exit(0);
    }

}