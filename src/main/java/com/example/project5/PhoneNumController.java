package com.example.project5;

// Aliya Almeida
// Having error getting informations from the website
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;

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
    private ListView<PhoneNumDataHandler.PhoneNumDataType> CountryList;
    private PhoneNumDataHandler Model;


    public void loadData(){ //loads data from the website
        var site = "http://country.io/search?=names.json";
        var site2 = "http://country.io/search?=phone.json";
        String param = getQueryParam();
        var wholeSite = site+site2+param;
        Model = new PhoneNumDataHandler(wholeSite);
        var countries = Model.getData();
        ObservableList<PhoneNumDataHandler.PhoneNumDataType> List = FXCollections.observableArrayList(countries);
        CountryList.setItems(List);
    }

    private String getQueryParam(){ // window asking for input
        var inputDialog = new TextInputDialog("United States");
        inputDialog.setContentText("What country are you searching for");
        inputDialog.setHeaderText("Gathering Information");
        var response = inputDialog.showAndWait();
        if (response.isEmpty()){
            return "";
        }
        else{
            return response.get();
        }
    }
    public void OkButtonPushed(){ //button that allows user to reset country choice
        loadData();
        NameField.setText(CountryList.toString());
        CountryCodeField.setText(CountryList.toString());
        PhoneCodeField.setText(CountryList.toString());
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadData();
        CountryList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<PhoneNumDataHandler.PhoneNumDataType>() {
            @Override
            public void changed(ObservableValue<? extends PhoneNumDataHandler.PhoneNumDataType> observableValue, PhoneNumDataHandler.PhoneNumDataType phoneNumDataType, PhoneNumDataHandler.PhoneNumDataType t1) {
                NameField.setText(String.valueOf(t1.country_name));
                CountryCodeField.setText(String.valueOf(t1.country_code));
                PhoneCodeField.setText(t1.country_data);
            }
        });
    }

}
