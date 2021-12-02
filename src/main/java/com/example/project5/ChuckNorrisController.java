package com.example.project5;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ChuckNorrisController implements Initializable {
    @FXML
    private ListView<String[]> CatList;//turn into arraylist
    @FXML
    private TextField JokeDisplay;
    @FXML
    private TextField CatDisplay;
    private ChuckNorrisDataHandler Model;
    private ArrayList<String[]> Categories;
    private ObservableList<String[]>OList;

    public void loadData(){
        var site = "https://api.chucknorris.io/jokes/categories=";
        var param = CatDisplay.getText();
        var wholeSite = site+param;
        Model = new ChuckNorrisDataHandler(wholeSite);
        var Norris = Model.getData();


    }
    public void LoadList(){
        Categories = new ArrayList<String[]>();
        var filename = "ChuckNorrisCategory";
        var filePath = Paths.get(filename);
        List<String> allLines = null;
        try {
            allLines = Files.readAllLines(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (var line : allLines) {
            var lineSplit = line.split(",");
            Categories.add(lineSplit);
        }
        //Categories=new ArrayList<>(OList);
        OList= FXCollections.observableArrayList(Categories);
        CatList.setItems(OList);
    }
    public void NewJokePushed(){
        loadData();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        LoadList();
        CatList.getSelectionModel().selectedItemProperty().addListener
                (new ChangeListener<String[]>() {
                    @Override
                    public void changed(ObservableValue<? extends String[]> observableValue, String[] strings, String[] t1) {
                        CatDisplay.setText(String.valueOf(t1.toString()));
                    }
                });
    }
}
