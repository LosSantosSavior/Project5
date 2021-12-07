package com.example.project5;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

public class ChuckNorrisDataHandler {
    private HttpClient dataGrabber;
    private String webLocation;

    public ChuckNorrisDataHandler(String siteToSearch){
        dataGrabber = HttpClient.newHttpClient();
        webLocation = siteToSearch;
    }

    public ChuckNorrisDataType getData(){
        var requestBuilder = HttpRequest.newBuilder();
        var ourURI = URI.create(webLocation);
        var dataRequest = requestBuilder.uri(ourURI).build();
        HttpResponse<String> response = null;
        try {
            response = dataGrabber.send(dataRequest, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            System.out.println("error connecting to server");;
        } catch (InterruptedException exception) {
            System.out.println("lost connection to server");
        }
        if(response == null){
            System.out.println("unable to get data from network... giving up");
            System.exit(-1);
        }
        var responseBody = response.body();
        var jsonParser = new Gson();
        System.out.println(responseBody);
        var ChuckData = jsonParser.fromJson(responseBody, ChuckNorrisDataType.class);
        return ChuckData;
    }

    class ChuckNorrisDataType{
        ArrayList<String>categories;
        String created_at;
        String icon_url;
        String id;
        String updated_at;
        String url;
        String value;

        @Override
        public String toString(){
            return value;
        }
    }
}
