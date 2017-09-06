package com.csalazar.parcelable.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.csalazar.parcelable.R;
import com.csalazar.parcelable.object.Alumnos;
import com.csalazar.parcelable.object.Clase;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        informacion();

    }

    private void informacion(){
        List<Alumnos> listAlumnos = new ArrayList<>();
        Clase claseNueva = new Clase();
        claseNueva.setNombre("Matematicas");
        claseNueva.setDescripcion("Clase de matematicas para sexto primaria");

        for(int i = 0; i < 5; i++){
            Alumnos alumno = new Alumnos();
            alumno.setNombre("Nombre " + i);
            alumno.setApellidos("Apellido " + i);
            listAlumnos.add(alumno);
        }


        claseNueva.setAlumnos(listAlumnos);

        Intent intent = new Intent(this, ReciveDatos.class);
        intent.putExtra("nvClase", claseNueva);

        startActivity(intent);

        finish();

    }
}
