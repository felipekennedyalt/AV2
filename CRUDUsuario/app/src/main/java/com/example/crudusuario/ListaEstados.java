package com.example.crudusuario;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.crudusuario.webservice.CasosPorEstado;
import com.example.crudusuario.webservice.Dados;
import com.example.crudusuario.webservice.Util;
import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static android.media.CamcorderProfile.get;

public class ListaEstados extends AppCompatActivity {

    private ListView listaEstados;
    private Button btnVoltarDeListEstados;

    private AlertDialog.Builder dialog;
    ArrayAdapter estadosAdaptador;
    Dados dados;






    Util webservice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_estados);

        listaEstados = findViewById(R.id.listaEstados);
        btnVoltarDeListEstados = findViewById(R.id.btnVoltarDeListEstados);

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

            btnVoltarDeListEstados.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(ListaEstados.this, MenuPrincipal.class));
                    finish();
                }
            });

            listaEstados.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    CasosPorEstado estados = dados.data.get(position);
                    dialogEstados(estados);
                }


            });

        }



    }
    private void dialogEstados(CasosPorEstado casoEstado) {

        dialog = new AlertDialog.Builder(ListaEstados.this);
        String mensagem = "";
        mensagem += "Confirmados: "+casoEstado.getCases();
        mensagem += "Óbitos: "+casoEstado.getDeaths();
        mensagem += "Suspeitos: "+casoEstado.getSuspects();
        mensagem += "Descartados: "+casoEstado.getRefuses();



        dialog.setTitle("Detalhes: \n"+casoEstado.getState());
        dialog.setMessage(mensagem);

        dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        dialog.setCancelable(false);

        dialog.create();
        dialog.show();
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

