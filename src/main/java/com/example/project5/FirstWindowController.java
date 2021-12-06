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
        secondWindow.setTitle("Chuck Norris API");
        secondWindow.show();
    }

    @FXML
    public void handleOpenGDP(ActionEvent event)    {
        var thirdLoc = new FXMLLoader(FirstWindowApplication.class.getResource("GDPWindow.fxml"));
        Scene thirdScene = null;
        try {
            thirdScene = new Scene(thirdLoc.load(), 400, 600);
        } catch (IOException e) {
            System.out.println("Couldn't load third window...");
            e.printStackTrace();
        }
        Stage thirdWindow = new Stage();
        thirdWindow.setScene(thirdScene);
        thirdWindow.setTitle("GDP API");
        thirdWindow.show();
    }

    @FXML
    public void handleClose(ActionEvent event){
        System.exit(0);
    }

}