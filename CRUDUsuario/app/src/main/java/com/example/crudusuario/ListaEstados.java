package com.example.crudusuario;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.crudusuario.webservice.CasosPorEstado;
import com.example.crudusuario.webservice.Dados;
import com.example.crudusuario.webservice.Util;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ListaEstados extends AppCompatActivity {

    private ListView listaEstados;

    ArrayAdapter estadosAdaptador;
    Dados dados;

    Util webservice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_estados);

        listaEstados = findViewById(R.id.listaEstados);

        webservice = new Util();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                dados = webservice.getCasosPorEstados();
                exibirDados();
            }
        });
        thread.start();

        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setTitle("Casos por Estados");
        }



    }

    public void exibirDados(){
        ListaEstados.this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                estadosAdaptador = new ArrayAdapter<CasosPorEstado>(getApplicationContext(),
                        android.R.layout.simple_expandable_list_item_2,
                        android.R.id.text2,
                        dados.data);
                listaEstados.setAdapter(estadosAdaptador);
            }
        });
    }

}

