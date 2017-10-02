package com.csalazar.formularioventas.controlador;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.csalazar.formularioventas.modelo.Correlativo;

/**
 * Created by csalazar on 29/09/2017.
 */

public class ConsultaCorrelativo {

    private SQLiteDatabase sqLiteDatabase;
    private ControladorBase controladorBase;

    public ConsultaCorrelativo(Context context){
        controladorBase = new ControladorBase(context);
    }

    public static ContentValues CorrelativoContent(Correlativo correlativo){
        ContentValues CVCorrelativo = new ContentValues();
        CVCorrelativo.put(ControladorBase.TIPO_FORMULARIO, correlativo.getTipoFormulario());
        CVCorrelativo.put(ControladorBase.NUMERO, correlativo.getNumero());

        return CVCorrelativo;
    }

    public String InsertCorrelativo(Correlativo correlativo){
        sqLiteDatabase = controladorBase.getWritableDatabase();
        sqLiteDatabase.insert(ControladorBase.TABLA_CORRELATIVO,null,CorrelativoContent(correlativo));

        return "";
    }

    public Cursor buscarCorrelativo(String tipoFormulario){

        sqLiteDatabase = controladorBase.getReadableDatabase();
        String where = ControladorBase.TIPO_FORMULARIO + "= ?";
        String[] whereParametros = {tipoFormulario};
        Cursor cQuery;
        if(tipoFormulario != null){
            cQuery = sqLiteDatabase.query(ControladorBase.TABLA_CORRELATIVO, null, where, whereParametros, null, null, null);
        }else{
            cQuery = sqLiteDatabase.query(ControladorBase.TABLA_CORRELATIVO, null, null, null, null, null, null);
        }

        if(cQuery.moveToFirst())
        {
            return cQuery;

        }
        return null;
    }

    public String updateCorrelativo(Correlativo correlativo){
        String where = ControladorBase.TIPO_FORMULARIO + "= ?";
        String[] whereParametros = {ControladorBase.TABLA_CORRELATIVO};
        sqLiteDatabase.update(ControladorBase.TABLA_CORRELATIVO,CorrelativoContent(correlativo),where,whereParametros);

        return "";
    }

}
