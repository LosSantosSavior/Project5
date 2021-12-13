package com.example.project5;

/*
Nicholas Russell
    - GDP Window loads properly
    - Year dropdown window not functional, having issues properly
        displaying years available to user
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.collections.ObservableList;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.Initializable;

import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class GDPController implements Initializable {
    @FXML
    private ArrayList<String> GDPData;
    @FXML
    private TextField YearField;
    @FXML
    private TextField CountryField;
    @FXML
    private TextField GDPField;
    @FXML
    private ChoiceBox<String> yearChoice = new ChoiceBox<>();
    private ObservableList<String> GDPList;
    private GDPDataHandler GDPModel;
    private GDPDataHandler.GDPDataType GDP;




    public void loadData()  { //Loads API json data
        var endpoint1 = "http://api.worldbank.org/v2/countries/USA/indicators/NY.GDP.MKTP.CD?per_page=5000&format=json";
        var endpoint2 = "http://api.worldbank.org/v2/countries/CHN/indicators/NY.GDP.MKTP.CD?per_page=5000&format=json";
        var endpoint3 = "http://api.worldbank.org/v2/countries/IND/indicators/NY.GDP.MKTP.CD?per_page=5000&format=json";
        //String param = getQueryParam();
        var param1 = YearField.getText();
        var param2 = CountryField.getText();
        var param3 = GDPField.getText();
        var wholeSite = endpoint1+param1+endpoint2+param2+endpoint3+param3;
        GDPModel = new GDPDataHandler(wholeSite);
        GDP = GDPModel.getData();
    }

    public void loadList()  { //Loads info from GDPDataType
        GDPData = new ArrayList<String>();
        var filename = "GDPDataType";
        var filePath = Paths.get(filename);
        String allLines = null;
        try {
            allLines = Files.readString(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (var line : allLines.split(",")) {
            GDPData.add(line);
        }
        GDPList = FXCollections.observableArrayList(GDPData);
        yearChoice.setItems(GDPList);
    }

    @FXML
    public void yearChanged(ActionEvent event)   { //User is able to change year after input from dropdown menu
        loadData();
        YearField.setText(String.valueOf(yearChoice));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadList();
        yearChoice.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String GDPDataType, String t1) {
                YearField.setText(String.valueOf(t1.toString()));
                CountryField.setText(String.valueOf(t1.toString()));
                GDPField.setText(String.valueOf(t1.toString()));
            }
        });
    }
}
