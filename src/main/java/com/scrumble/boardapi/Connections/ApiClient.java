package com.scrumble.boardapi.Connections;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class ApiClient {
    private ApiClient() {
        //default constructor
    }

    public static boolean validateToken(String token) {
        // :^)
        AtomicBoolean response = new AtomicBoolean(false);
        JsonObject jsonObject1 = new JsonObject();
        jsonObject1.addProperty("token", token);

        String sendData = jsonObject1.toString();
        try {
            URL url = new URL("http://localhost:8888/validatetoken");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("Content-Type", "application/json");
            try (OutputStream outputStream = httpURLConnection.getOutputStream()) {
                outputStream.write(sendData.getBytes());
                outputStream.flush();
            }
            if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()))) {
                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        Gson gson = new Gson();
                        response.set(gson.fromJson(line, boolean.class));
                    }
                }
            } else {
                System.out.println("Something went wrong while connecting to API");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return response.get();
    }

    public static String getUsernameFromToken(String token) {
        AtomicReference response = new AtomicReference("");
        JsonObject jsonObject1 = new JsonObject();
        jsonObject1.addProperty("token", token);

        String sendData = jsonObject1.toString();
        try {
            URL url = new URL("http://localhost:8888/getusernamefromtoken");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("Content-Type", "application/json");
            try (OutputStream outputStream = httpURLConnection.getOutputStream()) {
                outputStream.write(sendData.getBytes());
                outputStream.flush();
            }
            if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()))) {
                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        Gson gson = new Gson();
                        response.set(gson.fromJson(line, String.class));
                    }
                }
            } else {
                System.out.println("Something went wrong while connecting to API");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return response.get().toString();
    }
}
