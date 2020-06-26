package com.example.crudusuario;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.crudusuario.R;

public class Sobre extends AppCompatActivity {

    private Button btnAlan;
    private Button btnCaio;
    private Button btnDanylo;
    private Button btnFelipe;
    private Button btnVictor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobre);

        btnAlan.findViewById(R.id.btnAlan);
        btnCaio.findViewById(R.id.btnCaio);
        btnDanylo.findViewById(R.id.btnDanylo);
        btnFelipe.findViewById(R.id.btnFelipe);
        btnVictor.findViewById(R.id.btnVictor);

        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setTitle("Sobre");
        }

        btnAlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogUtil.mostrarDialog(getApplicationContext(), "Desenvolvedor", "O cara mais bonito da equipe", R.drawable.Alan);
            }
        });

        btnCaio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogUtil.mostrarDialog(getApplicationContext(), "Desenvolvedor", "dafa", R.drawable.Caio);

            }
        });

        btnDanylo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogUtil.mostrarDialog(getApplicationContext(), "Desenvolvedor", "asgvba", R.drawable.Danylo);

            }
        });

        btnFelipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogUtil.mostrarDialog(getApplicationContext(), "Desenvolvedor", "asga", R.drawable.Felipe);

            }
        });

        btnVictor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogUtil.mostrarDialog(getApplicationContext(), "Desenvolvedor", "aefgaG", R.drawable.Victor);

            }
        });

    }
}
