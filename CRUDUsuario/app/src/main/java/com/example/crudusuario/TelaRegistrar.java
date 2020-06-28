package com.example.crudusuario;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.crudusuario.usuario.Usuario;
import com.example.crudusuario.usuario.UsuarioDAO;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class TelaRegistrar extends AppCompatActivity {

    private EditText txtNomeReg;
    private EditText txtLoginReg;
    private EditText txtSenhaReg;
    private Button btSalvarReg;

    UsuarioDAO usuarioDAO;
    Usuario usuario;
    Usuario usuarioCarregado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_registrar);

        txtNomeReg = findViewById(R.id.txtNomeReg);
        txtLoginReg = findViewById(R.id.txtLoginReg);
        txtSenhaReg = findViewById(R.id.txtSenhaReg);


        usuarioDAO = new UsuarioDAO(openOrCreateDatabase(UsuarioDAO.NOME_BANCO, MODE_PRIVATE, null));

        btSalvarReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verificarUsuarioDuplicado(txtLoginReg.getText().toString());
            }
        });

    }

    public void verificarUsuarioDuplicado(String login){
        OkHttpClient client = new OkHttpClient();
        Request request;
        String url = "http://192.168.1.3/webservice/usuario/verificar_duplicado.php?"+
                "login="+login;

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

                TelaRegistrar.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if(resposta.equals("false")){
                            salvarUsuario();
                        }else{
                            Toast.makeText(getApplicationContext(), "Usuário já existe!", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
            }
        });

    }


    public void salvarUsuario(){
        usuario = new Usuario();
        if (usuarioCarregado == null) {
            usuarioCarregado = new Usuario();
        }

        if (usuarioCarregado.getId() != 0) {
            usuario.setNome(txtNomeReg.getText().toString());
            usuario.setLogin(txtLoginReg.getText().toString());
            usuario.setSenha(txtSenhaReg.getText().toString());
            usuarioDAO.salvar(usuario);
            Toast.makeText(getApplicationContext(), "Usuário Cadastrado!", Toast.LENGTH_SHORT).show();
        }

        limparCampos();
    }

    private void limparCampos() {
    }
}
