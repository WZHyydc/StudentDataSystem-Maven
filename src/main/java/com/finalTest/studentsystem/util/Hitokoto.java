package com.finalTest.studentsystem.util;

import com.finalTest.studentsystem.run.TestLogin;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Hitokoto {

    public static String getHitokoto() {
        String h;
        while (true){
            h = fetch();
            if (h.length()<20){
                break;
            }
        }
        return h;
    }

    private static String fetch() {
        var client = HttpClient.newBuilder().build();
        var request = HttpRequest.newBuilder().uri(URI.create("https://v1.hitokoto.cn")).GET().build();

        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        var body = response.body();

        JsonObject jsonObject = (JsonObject) new JsonParser().parse(body).getAsJsonObject();

        return jsonObject.get("hitokoto").toString();
    }
}


