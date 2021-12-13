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
    private ListView<String> CatList;
    @FXML
    private TextField JokeDisplay;
    @FXML
    private TextField CatDisplay;
    @FXML
    private TextField URLDisplay;
    private ChuckNorrisDataHandler Model;
    private ArrayList<String> Categories;
    private ObservableList<String>OList;
    private ChuckNorrisDataHandler.ChuckNorrisDataType Norris;

    public void loadData(){//Sets up the joke to be searched
        var site = "https://api.chucknorris.io/jokes/random?category=";
        var param = CatDisplay.getText();
        var wholeSite = site+param;
        Model = new ChuckNorrisDataHandler(wholeSite);
        Norris = Model.getData();


    }
    public void LoadList(){//loads all of the joke categories from a text file
        Categories = new ArrayList<String>();
        var filename = "ChuckNorrisCategory";
        var filePath = Paths.get(filename);
        String allLines = null;
        try {
            allLines = Files.readString(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (var line : allLines.split(",")) {
            Categories.add(line);
        }
        OList= FXCollections.observableArrayList(Categories);
        CatList.setItems(OList);
    }
    public void NewJokePushed(){//loads the joke when the new joke button is pushed
        loadData();
        JokeDisplay.setText(Norris.value);
        URLDisplay.setText(Norris.url);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {//sets up the observable list to be loaded into a text feild
        LoadList();
        CatList.getSelectionModel().selectedItemProperty().addListener
                (new ChangeListener<String>() {
                    @Override
                    public void changed(ObservableValue<? extends String> observableValue, String strings, String t1) {
                        CatDisplay.setText(String.valueOf(t1.toString()));
                    }
                });
    }
}
