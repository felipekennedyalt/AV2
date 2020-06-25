package com.example.crudusuario;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.health.PackageHealthStats;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Denunciar extends AppCompatActivity {

    private Button btnDenunciar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_denunciar);

        btnDenunciar = findViewById(R.id.btnDenunciar);

        btnDenunciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call();

            }
        });

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
