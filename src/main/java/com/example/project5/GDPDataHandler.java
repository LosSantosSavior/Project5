package com.example.project5;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

public class GDPDataHandler {
    private HttpClient dataGrabber;
    private String webLoc;

    public GDPDataHandler.GDPDataType getData(){
        var requestBuilder = HttpRequest.newBuilder();
        var ourURI = URI.create(webLoc);
        var dataRequest = requestBuilder.uri(ourURI).build();
        HttpResponse<String> response = null;
        try {
            response = dataGrabber.send(dataRequest, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            System.out.println("Error connecting to server");;
        } catch (InterruptedException exception) {
            System.out.println("Lost connection to server");
        }
        if(response == null){
            System.out.println("unable to get data from network... losing all hope for the progress of humankind...");
            System.exit(-1);
        }
        var responseBody = response.body();
        var jsonInterpreter = new Gson();
        var stringResponse = responseBody.toString();
        var GDPData = jsonInterpreter.fromJson(responseBody, GDPDataHandler.GDPDataType.class);
        return GDPData;
    }

    public GDPDataHandler(String siteToSearch) {    //Locates the access point on the web to grab API data
        dataGrabber = HttpClient.newHttpClient();
        webLoc = siteToSearch;
    }

    class GDPDataType   {
        ArrayList<String> yearData;
        String CountryNameData;
        ArrayList<String> GDPdata;


    }

    @Override
    public String toString() {
        return getData().CountryNameData;
    }
}