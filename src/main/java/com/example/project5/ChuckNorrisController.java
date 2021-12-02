package com.example.project5;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class ChuckNorrisController {
    @FXML
    private ListView<DataHandler.ChuckNorrisDataType> CatList;
    @FXML
    private TextField JokeDisplay;
    @FXML
    private TextField CatDisplay;
    private DataHandler Model;

    public void loadData(){
        var site = "https://api.chucknorris.io/jokes/categories=";
        var param = CatDisplay.getText();
        var wholeSite = site+param;
        Model = new DataHandler(wholeSite);
        var Norris = Model.getData();
       ObservableList<DataHandler.ChuckNorrisDataType> JokeList = FXCollections.observableArrayList(Norris);
        CatList.setItems(JokeList);
    }
}
