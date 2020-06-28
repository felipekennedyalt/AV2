package com.example.crudusuario;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PrevencaoCorona extends AppCompatActivity {

    private Button btComoSePrevenir;
    private Button btVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prevencao_corona);

        btComoSePrevenir = findViewById(R.id.btComoSePrevenir);
        btVoltar = findViewById(R.id.btVoltar);

        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setTitle("Prevenção COVID-19");
        }

        btVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PrevencaoCorona.this, MenuPrincipal.class);
                startActivity(intent);
                finish();
            }
        });

        btComoSePrevenir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PrevencaoCorona.this, PrevencaoCorona2.class);
                startActivity(intent);
                finish();
            }
        });


    }
}
