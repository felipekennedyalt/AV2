package com.example.crudusuario;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

public class DialogUtil {
    public static void mostrarDialog(Context context, String titulo, String mensagem, int imagemdev){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setIcon(imagemdev);
        builder.setTitle(titulo);
        builder.setMessage(mensagem);
        builder.setCancelable(false);
        builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.create().show();
    }

}
