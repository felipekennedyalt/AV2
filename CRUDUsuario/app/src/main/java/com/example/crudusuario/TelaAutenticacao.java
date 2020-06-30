package com.example.crudusuario;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ResourceCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.crudusuario.webservice.CasosPorEstado;
import com.example.crudusuario.webservice.Dados;
import com.example.crudusuario.webservice.Util;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class TelaAutenticacao extends AppCompatActivity {

    EditText txtUsuarioAut;
    EditText txtSenhaAut;
    Button btEntrarAut;
    TextView tvRegistrar;
 


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_autenticacao);

        txtUsuarioAut = findViewById(R.id.txtUsuarioAut);
        txtSenhaAut = findViewById(R.id.txtSenhaAut);
        btEntrarAut = findViewById(R.id.btEntrarAut);
        tvRegistrar = findViewById(R.id.tvRegistrar);


        final Util util = new Util();

        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setTitle("Login");
        }

        tvRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TelaAutenticacao.this, MainActivity.class));
            }
        });




        btEntrarAut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                autenticarUsuario(txtUsuarioAut.getText().toString(), txtSenhaAut.getText().toString());
            }
        });

    }

    public void autenticarUsuario(String login, String senha){
        OkHttpClient client = new OkHttpClient();
        Request request;
        String url = "http://192.168.1.6/webservice/usuario/autenticar.php?"+
                "login="+login+
                "&senha="+senha;
        request = new Request.Builder()
                .url(url)
                .get()
                .build();

            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    e.printStackTrace();
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    final String resposta = response.body().string();
                    TelaAutenticacao.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if(resposta.equals("true")){
                                startActivity(new Intent(TelaAutenticacao.this, MenuPrincipal.class));
                                finish();
                            }else{
                                Toast.makeText(getApplicationContext(), "Dados Inválidos!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            });
    }


}
