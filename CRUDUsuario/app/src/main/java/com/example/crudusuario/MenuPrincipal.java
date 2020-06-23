package com.example.crudusuario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuPrincipal extends AppCompatActivity {

    private Button btUsuarioMenu;
    private Button btSairMenu;
    private Button btPrevencaoCovid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        btSairMenu = findViewById(R.id.btSairMenu);
        btUsuarioMenu = findViewById(R.id.btUsuarioMenu);
        btPrevencaoCovid = findViewById(R.id.btPrevencaoCovid);

        btUsuarioMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuPrincipal.this, MainActivity.class));
                finish();
            }
        });

        btSairMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuPrincipal.this, TelaAutenticacao.class));
                finish();
            }
        });

        btPrevencaoCovid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuPrincipal.this, PrevencaoCorona.class);
            }
        });

    }
}
