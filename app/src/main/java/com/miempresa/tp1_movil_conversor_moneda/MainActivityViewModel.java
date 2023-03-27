package com.miempresa.tp1_movil_conversor_moneda;

import android.app.Application;
import android.content.Context;

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

    public void EurToDoll(String Eur){
        double eur = Double.parseDouble(Eur);
        valorF.setValue(eur*1.08);
    }
    public void DollToEur(String Doll){
        double doll = Double.parseDouble(Doll);
        valorF.setValue(doll/1.08);

    }

}
