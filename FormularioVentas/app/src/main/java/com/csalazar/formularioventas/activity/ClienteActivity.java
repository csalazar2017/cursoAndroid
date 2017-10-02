package com.csalazar.formularioventas.activity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.csalazar.formularioventas.R;
import com.csalazar.formularioventas.controlador.ConsultaCorrelativo;
import com.csalazar.formularioventas.controlador.ControladorBase;
import com.csalazar.formularioventas.modelo.Cliente;
import com.csalazar.formularioventas.modelo.Correlativo;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class ClienteActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Cliente cliente;
    private EditText textNombre;
    private EditText textDirecccion;
    private EditText textNit;
    private EditText textTelefono;
    private EditText textCorreo;
    private EditText textContacto;

    private ConsultaCorrelativo consultaCorrelativo;
    private Correlativo nCorrelativo;
    private int correlativo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openImagen();

            }
        });

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.id_map);
        mapFragment.getMapAsync(this);

        initComponents();
    }

    private void initComponents(){
        textNombre = (EditText) findViewById(R.id.et_nombre);
        textDirecccion = (EditText) findViewById(R.id.et_direccion);
        textNit = (EditText) findViewById(R.id.et_nit);
        textTelefono = (EditText) findViewById(R.id.et_telefono);
        textCorreo = (EditText) findViewById(R.id.et_correo);
        textContacto = (EditText) findViewById(R.id.et_contacto);

        recuperaCorrelativo();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    private void openImagen(){
        cliente = new Cliente("",textNombre.getText().toString(),textDirecccion.getText().toString(),
                textNit.getText().toString(), textTelefono.getText().toString(), textCorreo.getText().toString(),
                textContacto.getText().toString(),"","",nCorrelativo.toString());

        Intent intent = new Intent(this, ImagenActivity.class);
        intent.putExtra("clienteNuevo",cliente);

        startActivityForResult(intent,1001);

    }

    private void recuperaCorrelativo(){
        Cursor cQuery;
        correlativo = 0;
        consultaCorrelativo = new ConsultaCorrelativo(this);
        cQuery = consultaCorrelativo.buscarCorrelativo(ControladorBase.TABLA_CORRELATIVO);
        if(cQuery != null){
            if(cQuery.moveToFirst()){
                correlativo = cQuery.getInt(1);
                nCorrelativo = new Correlativo(ControladorBase.TABLA_CORRELATIVO, correlativo + 1);
                consultaCorrelativo.updateCorrelativo(nCorrelativo);
            }
        }else{
            nCorrelativo = new Correlativo(ControladorBase.TABLA_CORRELATIVO,1);
            consultaCorrelativo.InsertCorrelativo(nCorrelativo);
            correlativo = 1;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if((resultCode == RESULT_OK) && (requestCode == 1001)){
            Log.i("Cliente", "activity result");
            Intent intent = new Intent();
            this.setResult(ClienteActivity.RESULT_OK, intent);
            finish();
        }
    }
}
