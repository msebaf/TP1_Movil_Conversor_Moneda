package com.miempresa.tp1_movil_conversor_moneda;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private MainActivityViewModel mv;
    EditText dolar, euro;
    RadioButton RBeToD, RBdToE;
    Button convertir;
    TextView result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mv= ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModel.class);
        dolar = findViewById(R.id.etDolar);
        euro = findViewById(R.id.etEuro);
        RBdToE = findViewById(R.id.rbDollToE);
        RBeToD = findViewById(R.id.rbEurToDoll);
        convertir = findViewById(R.id.btConvertir);
        result = findViewById(R.id.tvResultado);

      
        mv.getvalorF().observe(this, new Observer<Double>() {
            @Override
            public void onChanged(Double res) {
                result.setText(res+"");
            }
        });



        RBeToD.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mv.cambiarMoneda(RBeToD.isChecked(), euro, dolar);
            }
        });



        convertir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               mv.convertir(dolar.getText().toString(), euro.getText().toString(), RBdToE.isChecked());
            }
        });
    }
}