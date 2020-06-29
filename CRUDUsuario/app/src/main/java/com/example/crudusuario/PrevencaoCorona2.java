package com.example.crudusuario;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PrevencaoCorona2 extends AppCompatActivity {

    private Button btVoltarPrevencao;
    private Button btVoltarPrevencaoMenu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prevencao_corona2);

        btVoltarPrevencao = findViewById(R.id.btVoltarPrevencao);
        btVoltarPrevencaoMenu = findViewById(R.id.btVoltarPrevencaoMenu);

        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setTitle("Prevenção COVID-19");
        }




        btVoltarPrevencao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PrevencaoCorona2.this, PrevencaoCorona.class);
                startActivity(intent);
                finish();
            }
        });

        btVoltarPrevencaoMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PrevencaoCorona2.this, MenuPrincipal.class);
                startActivity(intent);
                finish();
            }
        });


    }


}
