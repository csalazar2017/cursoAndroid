package com.csalazar.formularioventas.controlador;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.csalazar.formularioventas.modelo.UsuarioLogin;

/**
 * Created by csalazar on 27/09/2017.
 */

public class ConsultaUsuario {

    private SQLiteDatabase sqLiteDatabase;
    private ControladorBase controladorBase;

    public ConsultaUsuario(Context context){
        controladorBase = new ControladorBase(context);
    }

    public static ContentValues UsuarioContent(UsuarioLogin usuarioLogin){

        ContentValues CVUsuario = new ContentValues();
        CVUsuario.put(ControladorBase.USUARIO_ID,usuarioLogin.getIdUsuario());
        CVUsuario.put(ControladorBase.USUARIO_NOMBRE,usuarioLogin.getNombre());
        CVUsuario.put(ControladorBase.USUARIO_PASSWORD,usuarioLogin.getPassword());

        return CVUsuario;
    }

    public String InsertUsuario(UsuarioLogin usuarioLogin){
        sqLiteDatabase = controladorBase.getWritableDatabase();
        sqLiteDatabase.insert(ControladorBase.USUARIO,null,UsuarioContent(usuarioLogin));

        return "";
    }
}
