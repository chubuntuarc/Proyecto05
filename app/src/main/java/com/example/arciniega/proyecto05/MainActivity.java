package com.example.arciniega.proyecto05;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
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
    private TextView resultado;
    private EditText valor1;
    private EditText valor2;
    private Button btnCalcular;

    // Variables para el calculo
    private String dato;
    private double val1;
    private double val2;
    private double res;

    // Se crea un adaptador de datos para el control spinner
    private ArrayAdapter<String> adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Se relacionan los elementos Java con los elementos del XML
        spinner = (Spinner)findViewById(R.id.spinner);
        resultado = (TextView)findViewById(R.id.txtValorR);
        valor1 = (EditText)findViewById(R.id.editValor1);
        valor2 = (EditText)findViewById(R.id.editValor2);
        btnCalcular = (Button)findViewById(R.id.btnCalcular);


        // El adaptador recibe tres parametros: this - Contexto de la aplicacion, R.layout... - Indicando que soportada un dropdown - spinnerDatos - El arreglo de datos
        adaptador  = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,spinnerDatos);

        // Enlazar el adaptador con el spinner
        spinner.setAdapter(adaptador);

        // Establecer un listener para el evento 'Selección de item'
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            // ¿Que ocurre al seleccionar un item determinado?
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long id) {
                // Se asigna el valor seleccionado del spinner
                dato = spinnerDatos[i].toString();

            }
            // ¿Qué ocurre al no seleccionar nada?
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                resultado.setText("0");

            }
        });

        // Programación del "Receptor (Listener)" para el evento onClick del botón
        btnCalcular.setOnClickListener(new View.OnClickListener() {



            // Esto se puede generar solo con el comando Alt + Enter sobre el texto OnClickListener
            @Override
            public void onClick(View v) {
                switch (dato){
                    case "+":
                        // Se crean los valores double para la operacion
                        val1 = Double.parseDouble(valor1.getText().toString());
                        val2 = Double.parseDouble(valor2.getText().toString());
                        res = val1 + val2;
                        resultado.setText("" + res);
                        break;
                    case "-":
                        // Se crean los valores double para la operacion
                        val1 = Double.parseDouble(valor1.getText().toString());
                        val2 = Double.parseDouble(valor2.getText().toString());
                        res = val1 - val2;
                        resultado.setText("" + res);
                        break;
                    case "*":
                        // Se crean los valores double para la operacion
                        val1 = Double.parseDouble(valor1.getText().toString());
                        val2 = Double.parseDouble(valor2.getText().toString());
                        res = val1 * val2;
                        resultado.setText("" + res);
                        break;
                    case "/":
                        // Se crean los valores double para la operacion
                        val1 = Double.parseDouble(valor1.getText().toString());
                        val2 = Double.parseDouble(valor2.getText().toString());
                        res = val1 / val2;
                        resultado.setText("" + res);
                        break;
                    default:
                        res = 0;
                        resultado.setText("" + res);
                        break;
                }
            }
        });

    }
}
