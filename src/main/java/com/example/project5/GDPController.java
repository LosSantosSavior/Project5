package com.example.project5;

import javafx.fxml.FXML;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.Initializable;

import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class GDPController implements Initializable {

    @FXML
    private TextField YearDisp;
    @FXML
    private TextField CountryDisp;
    @FXML
    private TextField GDPValDisp;
    @FXML
    private ChoiceBox yearChoice;

    private ArrayList<String> years;





    public void loadData()  {
        var endpoint1 = "http://api.worldbank.org/v2/countries/USA/indicators/NY.GDP.MKTP.CD?per_page=5000&format=json";
        var endpoint2 = "http://api.worldbank.org/v2/countries/CHN/indicators/NY.GDP.MKTP.CD?per_page=5000&format=json";
        var endpoint3 = "http://api.worldbank.org/v2/countries/IND/indicators/NY.GDP.MKTP.CD?per_page=5000&format=json";
    }

    public void loadList()  {

    }

    public void yearChanged()   {
        loadData();

    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadList();

    }
}
