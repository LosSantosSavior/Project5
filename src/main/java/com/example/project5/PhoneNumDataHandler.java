package com.example.project5;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

public class PhoneNumDataHandler {
    private HttpClient dataGrabber;
    private String webLocation;

    public PhoneNumDataHandler (String siteToSearch){
        dataGrabber = HttpClient.newHttpClient();
        webLocation = siteToSearch;
    }

    public PhoneNumDataType getData(){
        var requestBuilder = HttpRequest.newBuilder();
        var ourURI = URI.create(webLocation);
        var dataRequest = requestBuilder.uri(ourURI).build();
        HttpResponse<String> response = null;
        try{
            response = dataGrabber.send(dataRequest, HttpResponse.BodyHandlers.ofString());
        }
        catch (IOException e){
            System.out.println("Error with connection to server");
        }
        catch (InterruptedException exception){
            System.out.println("Lost connection to server");
        }
        if (response == null){
            System.out.println("Unable to get data from network ... giving up");
            System.exit(-1);
        }
        var responseBody = response.body();
        var jsonParser = new Gson();
        var PhoneData = jsonParser.fromJson(responseBody, PhoneNumDataType.class);
        return PhoneData;
    }

    class PhoneNumDataType{
        ArrayList<String> country_name;
        ArrayList<String> country_code;
    }
}
