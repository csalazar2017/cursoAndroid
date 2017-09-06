package com.csalazar.parcelable.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.csalazar.parcelable.R;
import com.csalazar.parcelable.object.Alumnos;
import com.csalazar.parcelable.object.Clase;

import java.util.List;

public class ReciveDatos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recive_datos);

        Clase clase = getIntent().getParcelableExtra("nvClase");
        Log.i("Curso", clase.getNombre());
        Log.i("Descripcion", clase.getNombre());

        List<Alumnos> alumnosEnviados;
        alumnosEnviados = clase.getAlumnos();

        for(int i = 0; i < alumnosEnviados.size(); i++){
            Log.i("Alumon registrados: ", alumnosEnviados.get(i).getNombre() + " " + alumnosEnviados.get(i).getApellidos());
        }
    }
}
