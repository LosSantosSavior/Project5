package com.example.project5;

import com.google.gson.Gson;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLParameters;
import java.io.IOException;
import java.net.Authenticator;
import java.net.CookieHandler;
import java.net.ProxySelector;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

public class GDPDataHandler {
    private HttpClient dataGrabber;
    private String webLoc;

    public GDPDataHandler(String siteToSearch) {    //Locates the access point on the web to grab API data
        dataGrabber = HttpClient.newHttpClient();
        webLoc = siteToSearch;
    }



}