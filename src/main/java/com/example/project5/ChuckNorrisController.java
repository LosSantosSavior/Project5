package com.example.project5;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ChuckNorrisController implements Initializable {
    @FXML
    private ListView<ChuckNorrisDataHandler.ChuckNorrisDataType> CatList;
    @FXML
    private TextField JokeDisplay;
    @FXML
    private TextField CatDisplay;
    private ChuckNorrisDataHandler Model;

    public void loadData(){
        var site = "https://api.chucknorris.io/jokes/categories=";
        var param = CatDisplay.getText();
        var wholeSite = site+param;
        Model = new ChuckNorrisDataHandler(wholeSite);
        var Norris = Model.getData();
       ObservableList<ChuckNorrisDataHandler.ChuckNorrisDataType> JokeList = FXCollections.observableArrayList(Norris);
        CatList.setItems(JokeList);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
