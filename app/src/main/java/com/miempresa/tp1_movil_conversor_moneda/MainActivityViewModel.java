package com.miempresa.tp1_movil_conversor_moneda;

import android.app.Application;
import android.content.Context;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class MainActivityViewModel extends AndroidViewModel {
    private double eurToDoll= 1.08;
    private Context context;
    private MutableLiveData<Double>valorF = null;






    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        this.context = application.getApplicationContext();

    }

    public LiveData<Double> getvalorF(){
        if (valorF==null){
            valorF= new MutableLiveData<>();

        }

        return valorF;

    }
    public void cambiarMoneda(boolean euToDoll, EditText euro, EditText dollar){
        if(euToDoll == true){
            dollar.setEnabled(false);
            euro.setEnabled(true);
        }
        else {
            dollar.setEnabled(true);
            euro.setEnabled(false);
        }
    }




    public void convertir(String dollar, String euro, boolean dolToEu){
        if(dolToEu == true){
            try {
                double doll = Double.parseDouble(dollar);
                valorF.setValue(doll / 1.08);
            }catch (Exception ex){
                Toast.makeText(context,"El campo dolares no puede estar vacio",Toast.LENGTH_LONG).show();
            }
        }else{
            try {
                double eur = Double.parseDouble(euro);
                valorF.setValue(eur * 1.08);
            }catch (Exception ex){
                Toast.makeText(context,"El campo euros no puede estar vacio",Toast.LENGTH_LONG).show();
            }
        }
    }



}
