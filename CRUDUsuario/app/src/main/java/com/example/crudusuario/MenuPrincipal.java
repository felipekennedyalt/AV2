package com.example.crudusuario;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

public class MenuPrincipal extends AppCompatActivity {

    private Button btUsuarioMenu;
    private Button btPrevencaoCovid;
    private Button btnCasosCovid;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        btUsuarioMenu = findViewById(R.id.btUsuarioMenu);
        btPrevencaoCovid = findViewById(R.id.btPrevencaoCovid);
        btnCasosCovid = findViewById(R.id.btnCasosCovid);


        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setTitle("Menu Principal");
        }



        btnCasosCovid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuPrincipal.this, ListaEstados.class));
                finish();

            }
        });


        btUsuarioMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuPrincipal.this, MainActivity.class));

            }
        });

        btPrevencaoCovid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuPrincipal.this, PrevencaoCorona.class);
                startActivity(intent);
                finish();

            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_sobre:
                startActivity(new Intent(this, Sobre.class));
                finish();
                break;
            case R.id.btn_Denunciar:
                call();
                break;
            case R.id.item_sair:
                startActivity(new Intent(MenuPrincipal.this, TelaAutenticacao.class));
                finish();
                break;
        }
        return true;
    }

        private void call(){
        Intent intentcall = new Intent(Intent.ACTION_CALL);
        intentcall.setData(Uri.parse("tel:190"));
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
            Toast.makeText(this, "Permissão Necessaria", Toast.LENGTH_SHORT).show();
            request();
        }else{
            startActivity(intentcall);
        }
    }

    private void request(){
        String[] array = {"android.Manifest.permission.CALL_PHONE"};
        ActivityCompat.requestPermissions(this, array, 1);
    }

}
