package com.csalazar.formularioventas.activity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.csalazar.formularioventas.R;
import com.csalazar.formularioventas.adapter.ListImagenAdapter;
import com.csalazar.formularioventas.controlador.ConsultaCliente;
import com.csalazar.formularioventas.controlador.ConsultaCorrelativo;
import com.csalazar.formularioventas.modelo.Cliente;
import com.csalazar.formularioventas.modelo.Correlativo;
import com.csalazar.formularioventas.modelo.Imagen;

import java.util.ArrayList;
import java.util.List;

public class ImagenActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ListImagenAdapter listImagenAdapter;
    private Context context;
    private List<Imagen> imagenesList;

    private Cliente cliente;
    private ConsultaCliente consultaCliente;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                //        .setAction("Action", null).show();
                    guardarCliente(view);
            }
        });
        cliente = getIntent().getParcelableExtra("clienteNuevo");
        initComponents();
    }

    private void initComponents(){
        context = this;
        recyclerView = (RecyclerView) findViewById(R.id.rv_imagenes);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context,3);

        recyclerView.setLayoutManager(gridLayoutManager);

        imagenesList = new ArrayList<>();
        imagenesList.add(new Imagen(R.drawable.usuario));

        listImagenAdapter = new ListImagenAdapter(context, imagenesList);
        recyclerView.setAdapter(listImagenAdapter);
    }

    private void guardarCliente(View view){
        consultaCliente = new ConsultaCliente(this);
        consultaCliente.InsertCliente(cliente);

        Intent intent = new Intent();
        this.setResult(ImagenActivity.RESULT_OK, intent);
        finish();
    }



}
