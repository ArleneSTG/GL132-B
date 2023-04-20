package com.example.labapp_atejada_rgutierrez_msanchez;

import androidx.appcompat.app.AppCompatActivity;

import android.net.wifi.aware.PublishConfig;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.StringJoiner;

public class MainActivity extends AppCompatActivity {
    EditText txtnum1, txtnum2;
    TextView Resultado;
    CheckBox cheMultiplicar ,cheRestar, cheDividir, cheSuma, cheResultado;
    Spinner listaOperaciones;

    String operacionSumar = "";
    String operacionRestar = "";
    String operacionMultiplicar = "";
    String operacionDividir = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


       Inicializar();

    }

    private void Inicializar()
    {
        txtnum1 = (EditText) findViewById(R.id.txtnum1);
        txtnum2 = (EditText) findViewById(R.id.txtnum2);
        Resultado = (TextView) findViewById(R.id.Res);
        cheResultado = (CheckBox) findViewById(R.id.cheResultado);


        listaOperaciones = (Spinner) findViewById(R.id.listaOperaciones);

        String[] lista = {"Escoger la Operacion", "Suma", "Resta", "Multiplicaion", "Divicion"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, lista);
        listaOperaciones.setAdapter(adapter);
    }

    public void OpsChespinner (View v){
        try {
            double Valor1 = Double.parseDouble(txtnum1.getText().toString());
            double Valor2 = Double.parseDouble(txtnum2.getText().toString());
            String Escoger = listaOperaciones.getSelectedItem().toString();
            String Result = " ";

            if (Escoger.equals("Suma")) {
                double suma = Valor1 + Valor2;
                Result = "Resultado: "+ suma;
            }
            else if (Escoger.equals("Resta")){
                double resta = Valor1-Valor2;
                Result = "Resultado: "+ resta;
            }
            else if (Escoger.equals("Multiplicaion")){
                double multiplicion = Valor1 * Valor2;
                Result = "Resultado: "+ multiplicion;
            }
            else if (Escoger.equals("Divicion")){
                Double divicion = Valor1 / Valor2;
                Result = "Resultado: "+ divicion;
            }
            if(cheResultado.isChecked()==true){
                new Parte("Operaciones", " "+Result, "Okis").show(getSupportFragmentManager(),"EQUIDE");
            }

        }catch (Exception e){
            Resultado.setText("Error al Escribir");
        }
    }
}
