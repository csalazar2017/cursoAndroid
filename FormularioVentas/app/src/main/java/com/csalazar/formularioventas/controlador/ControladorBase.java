package com.csalazar.formularioventas.controlador;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by csalazar on 27/09/2017.
 */

public class ControladorBase extends SQLiteOpenHelper {

    private SQLiteDatabase sqLiteDatabase;
    public final static String nameDataBase = "FormularioVentas";
    public final static int versionDataBase = 1;

    private static final String TEXT_TYPE = " TEXT";
    private static final String INT_TYPE = "Int";
    private static final String COMA = ", ";

    public static final String TABLA_USUARIO = "Usuario";
    public static final String USUARIO_ID = "idUsuario";
    public static final String USUARIO_NOMBRE = "Nombre";
    public static final String USUARIO_PASSWORD = "Password";

    public static final String TABLA_CLIENTE = "Cabecera";
    public static final String NUMERO_FORMULARIO = "numFormulario";
    public static final String FECHA = "fecha";
    public static final String COORDENADA_X = "coordenadaX";
    public static final String COORDENADA_Y = "coordenadaY";

    public static final String TABLA_DETALLE = "Detalle";
    public static final String NOMBRE_CLIENTE = "nomCliente";
    public static final String DIRECCION = "direccion";
    public static final String NIT = "nit";
    public static final String TELEFONO = "telefono";
    public static final String CORREO = "correo";
    public static final String CONTACTO = "contacto";

    public static final String TABLA_IMAGEN = "Imagen";
    public static final String ID_X = "idX";
    public static final String PATH = "path";

    public static final String TABLA_PARAMETROS = "Parametros";
    public static final String CODIGO = "codigo";
    public static final String NOMBRE = "nombre";
    public static final String VALOR = "valor";

    public static final String TABLA_CORRELATIVO = "Correlativo";
    public static final String TIPO_FORMULARIO = "tipoFormulario";
    public static final String NUMERO = "numero";

    public static final String USUARIO = "CREATE TABLE " + TABLA_USUARIO + " (" + USUARIO_ID + TEXT_TYPE + COMA
            + USUARIO_NOMBRE + TEXT_TYPE + COMA + USUARIO_PASSWORD + TEXT_TYPE + ");";

    public static final String CABECERA = "CREATE TABLE " + TABLA_CLIENTE + " (" + NUMERO_FORMULARIO + TEXT_TYPE + COMA
            + USUARIO_ID + TEXT_TYPE + COMA + FECHA + TEXT_TYPE + COMA + COORDENADA_X + TEXT_TYPE + COMA + COORDENADA_Y + TEXT_TYPE
            + ");";

    public static final String DETALLE = "CREATE TABLE " + TABLA_DETALLE + " (" + NUMERO_FORMULARIO + TEXT_TYPE + COMA
            + NOMBRE_CLIENTE + TEXT_TYPE + COMA + DIRECCION + TEXT_TYPE + COMA + NIT + TEXT_TYPE + COMA + TELEFONO + TEXT_TYPE + COMA
            + CORREO + TEXT_TYPE + COMA + CONTACTO + TEXT_TYPE + ");";

    public static final String IMAGEN = "CREATE TABLE " + TABLA_IMAGEN + " (" + NUMERO_FORMULARIO + TEXT_TYPE + COMA
            + ID_X + TEXT_TYPE + COMA + PATH + TEXT_TYPE + ");";

    public static final String PARAMETROS = "CREATE TABLE " + TABLA_PARAMETROS + " (" + CODIGO + TEXT_TYPE + COMA
            + NOMBRE + TEXT_TYPE + COMA + VALOR + TEXT_TYPE + ");";

    public static final String CORRELATIVO = "CREATE TABLE " + TABLA_CORRELATIVO + " (" + TIPO_FORMULARIO + TEXT_TYPE + COMA
            + NUMERO + TEXT_TYPE + ");";

    public ControladorBase(Context context) {
        super(context,ControladorBase.nameDataBase,null,ControladorBase.versionDataBase);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(USUARIO);
        sqLiteDatabase.execSQL(CABECERA);
        sqLiteDatabase.execSQL(DETALLE);
        sqLiteDatabase.execSQL(IMAGEN);
        sqLiteDatabase.execSQL(PARAMETROS);
        sqLiteDatabase.execSQL(CORRELATIVO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void openReaderDataBase(){
        sqLiteDatabase = this.getReadableDatabase();
    }

    public void openWriteDataBase(){
        sqLiteDatabase = this.getWritableDatabase();
    }

    public void closeDataBase(){
        if(sqLiteDatabase != null){
            sqLiteDatabase.close();
        }
    }

    @Override
    public void onOpen(SQLiteDatabase sldb){
        super.onOpen(sldb);
        if(!sldb.isReadOnly()){
            sldb.execSQL("PRAGMA foreing_keys=on;");
        }
    }
}
