package com.example.project5;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class PhoneNumController implements Initializable {
    @FXML
    private TextField NameField;
    @FXML
    private TextField CountryCodeField;
    @FXML
    private TextField PhoneCodeField;
    @FXML
    private ListView<String[]> CountryList;
    private PhoneNumDataHandler Model;


    public void loadData(){
        var site = "http://country.io/names.json";
        String param = NameField.getText();
        var wholeSite = site+param;
        Model = new PhoneNumDataHandler(wholeSite);
        var countries = Model.getData();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

}
