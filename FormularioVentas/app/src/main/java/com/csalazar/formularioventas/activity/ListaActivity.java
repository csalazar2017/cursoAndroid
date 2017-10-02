package com.csalazar.formularioventas.activity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.csalazar.formularioventas.R;
import com.csalazar.formularioventas.adapter.ListClienteAdapter;
import com.csalazar.formularioventas.controlador.ConsultaCliente;
import com.csalazar.formularioventas.modelo.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ListaActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ListClienteAdapter itemCliente;
    private Context context;
    private List<Cliente> clientesList;
    private ConsultaCliente consultaCliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openNuevoCliente();
            }
        });
        initComponents();
    }

    private void initComponents(){
        context = this;
        recyclerView = (RecyclerView) findViewById(R.id.rv_clientes);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 1);
        recyclerView.setLayoutManager(gridLayoutManager);
        llenado();
    }

    private void llenado(){
        //clientesList = new ArrayList<>();

        //clientesList.add(new Cliente("Imagen","Aaron Salazar","zona 21","4530252-9","40434745","aaronmob@hotmail.com","csalazar","14.23","-19.98","1"));
        //clientesList.add(new Cliente("Imagen","Mario Guzman","zona 17","12345-6","56891274","maguzman@hotmail.com","Mario","23.23","-9.98","1"));
        Cursor cQuery;
        consultaCliente = new ConsultaCliente(this);
        cQuery = consultaCliente.buscarUsuario(null);

        if(cQuery != null) {
            if (cQuery.moveToFirst()) {
                itemCliente = new ListClienteAdapter(context, cQuery);
                recyclerView.setAdapter(itemCliente);
            }
        }else {
            itemCliente = new ListClienteAdapter(context, cQuery);
            recyclerView.setAdapter(itemCliente);
        }
    }

    private void openNuevoCliente(){
        Intent intent = new Intent(this, ClienteActivity.class);

        startActivityForResult(intent, 1001);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if((resultCode == RESULT_OK) && (requestCode == 1001)){
            Log.i("Listado Clientes","Resultado Actividad");
            llenado();
        }
    }

}
