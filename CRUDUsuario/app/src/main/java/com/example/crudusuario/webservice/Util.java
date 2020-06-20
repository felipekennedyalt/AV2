package com.example.crudusuario.webservice;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Util {

    public Dados getCasosPorEstados(){
        OkHttpClient client = new OkHttpClient();
        Request request;
        String url = "https://covid19-brazil-api.now.sh/api/report/v1";
        Gson gson = new Gson();

        request = new Request.Builder()
                .url(url)
                .get()
                .build();
        try {
            Response response = client.newCall(request).execute();

            Dados dados = gson.fromJson(response.body().string(), Dados.class);
            return dados;

        }catch(Exception e){
            e.printStackTrace();
        }

        return null;
    }




}
