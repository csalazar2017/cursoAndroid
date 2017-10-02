package com.csalazar.formularioventas.controlador;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.csalazar.formularioventas.modelo.Cliente;

import java.util.Date;

/**
 * Created by csalazar on 29/09/2017.
 */

public class ConsultaCliente {

    private SQLiteDatabase sqLiteDatabase;
    private ControladorBase controladorBase;

    public ConsultaCliente(Context context){
        controladorBase = new ControladorBase(context);
    }

    public static ContentValues ClienteCabeceraContent(Cliente cliente){
        Date fechaActual =  new Date();
        ContentValues CVCliente = new ContentValues();
        CVCliente.put(ControladorBase.NUMERO_FORMULARIO, cliente.getNumFormulario());
        CVCliente.put(ControladorBase.USUARIO_ID, "csalazar");
        CVCliente.put(ControladorBase.FECHA, fechaActual.toString());
        CVCliente.put(ControladorBase.COORDENADA_X,cliente.getCoordenadaX());
        CVCliente.put(ControladorBase.COORDENADA_Y,cliente.getCoordenadaY());


        return CVCliente;
    }

    public static ContentValues ClienteDetalleContent(Cliente cliente){
        ContentValues CVCliente = new ContentValues();
        CVCliente.put(ControladorBase.NUMERO_FORMULARIO, cliente.getNumFormulario());
        CVCliente.put(ControladorBase.NOMBRE_CLIENTE, cliente.getNombre());
        CVCliente.put(ControladorBase.DIRECCION, cliente.getDireccion());
        CVCliente.put(ControladorBase.TELEFONO, cliente.getTelefono());
        CVCliente.put(ControladorBase.NIT, cliente.getNit());
        CVCliente.put(ControladorBase.CORREO,cliente.getCorreo());
        CVCliente.put(ControladorBase.CONTACTO,cliente.getContacto());

        return CVCliente;
    }

    public String InsertCliente(Cliente cliente){
        sqLiteDatabase = controladorBase.getWritableDatabase();
        sqLiteDatabase.insert(ControladorBase.TABLA_CLIENTE,null,ClienteCabeceraContent(cliente));
        sqLiteDatabase.insert(ControladorBase.TABLA_DETALLE,null,ClienteDetalleContent(cliente));

        return "";
    }

    public Cursor buscarUsuario(String numFormulario)
    {
        sqLiteDatabase = controladorBase.getReadableDatabase();
        String where = ControladorBase.NUMERO_FORMULARIO  + "= ?" ;
        String[] whereParametros = {numFormulario};
        Cursor cQuery;
        if(numFormulario != null){
            String consulta = "select c.path, b.nomCliente, b.direccion, b.nit, b.telefono, b.correo, b.contacto, " +
                    "a.coordenadaX, a.coordenadaY, a.numFormulario from Cabecera a " +
                    "inner join Detalle b on a.numFormulario = b.numFormulario " +
                    "left join Imagen c on a.numFormulario = c.numFormulario where c.numFormulario = ?";
            cQuery = sqLiteDatabase.rawQuery(consulta,whereParametros);
            //cQuery = sqLiteDatabase.query(ControladorBase.TABLA_DETALLE, null, where, whereParametros, null, null, null);
        }else{
            String consulta = "select c.path, b.nomCliente, b.direccion, b.nit, b.telefono, b.correo, b.contacto, " +
                    "a.coordenadaX, a.coordenadaY, a.numFormulario from Cabecera a " +
                    "inner join Detalle b on a.numFormulario = b.numFormulario " +
                    "left join Imagen c on a.numFormulario = c.numFormulario";
            cQuery = sqLiteDatabase.rawQuery(consulta,null);
            //cQuery = sqLiteDatabase.query(ControladorBase.TABLA_DETALLE, null, null, null, null, null, null);
        }

        if(cQuery.moveToFirst())
        {
            return cQuery;

        }
        return null;
    }


}
