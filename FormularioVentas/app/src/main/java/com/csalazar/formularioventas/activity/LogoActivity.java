package com.csalazar.formularioventas.activity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.csalazar.formularioventas.R;
import com.csalazar.formularioventas.controlador.ControladorBase;

public class LogoActivity extends AppCompatActivity {

    private Handler mHandler;
    //private SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo);
        mHandler = new Handler();
        mHandler.postDelayed(receiveRunnable, 5000);

        /*ControladorBase controladorBase = new ControladorBase(this);
        sqLiteDatabase = controladorBase.getReadableDatabase();
        sqLiteDatabase.execSQL("delete from " + ControladorBase.TABLA_USUARIO);
        sqLiteDatabase.execSQL("delete from " + ControladorBase.TABLA_CLIENTE);
        sqLiteDatabase.execSQL("delete from " + ControladorBase.TABLA_DETALLE);
        sqLiteDatabase.execSQL("delete from " + ControladorBase.TABLA_IMAGEN);
        sqLiteDatabase.execSQL("delete from " + ControladorBase.TABLA_PARAMETROS);
        sqLiteDatabase.execSQL("delete from " + ControladorBase.TABLA_CORRELATIVO);*/
    }

    private Runnable receiveRunnable = new Runnable() {
        @Override
        public void run() {
            startLogin();
        }
    };

    private void startLogin(){
        Intent intent = new Intent(this, LoginActivity.class);

        startActivity(intent);
    }

}
