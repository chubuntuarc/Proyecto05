package com.example.arciniega.proyecto05;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Declaramos un arreglo con los valores que se mostaran en el Spinner
    private String[] spinnerDatos = new String[]{
            "+",
            "-",
            "*",
            "/"
    };

    // Declaramos los elementos Java que se relacionarán con los elementos del XML
    private Spinner spinner;
    private TextView mensaje;

    // Se crea un adaptador de datos para el control spinner
    private ArrayAdapter<String> adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Se relacionan los elementos Java con los elementos del XML
        spinner = (Spinner)findViewById(R.id.spinner);
        mensaje = (TextView)findViewById(R.id.txtMensaje);


        // El adaptador recibe tres parametros: this - Contexto de la aplicacion, R.layout... - Indicando que soportada un dropdown - spinnerDatos - El arreglo de datos
        adaptador  = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,spinnerDatos);

        // Enlazar el adaptador con el spinner
        spinner.setAdapter(adaptador);

        // Establecer un listener para el evento 'Selección de item'
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            // ¿Que ocurre al seleccionar un item determinado?
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long id) {
                mensaje.setText(spinnerDatos[i].toString());
            }
            // ¿Qué ocurre al no seleccionar nada?
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                mensaje.setText("");

            }
        });
    }
}
