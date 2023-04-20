package com.example.labapp_atejada_rgutierrez_msanchez;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class Parte extends DialogFragment {
    String titulo, mensaje,boton;
    public Parte(String t, String m, String b ){
        this.titulo = t;
        this.mensaje = m;
        this.boton = b;
    }
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState){


        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(mensaje)
                .setTitle(titulo)
                .setPositiveButton(boton, new DialogInterface.OnClickListener(){
            @Override
                    public void onClick(DialogInterface dialog,int which){
                dialog.cancel();
            }
        });
return builder.create();
    }
}
