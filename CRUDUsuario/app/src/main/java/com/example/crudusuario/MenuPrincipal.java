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

        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setTitle("Menu Principal");
        }





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
                startActivity(intent);
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
            if(id == R.id.btn_Denunciar){
                call();
            }else if (id == R.id.btn_sobre){
                Intent intent = new Intent(MenuPrincipal.this, Sobre.class);
                startActivity(intent);
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
