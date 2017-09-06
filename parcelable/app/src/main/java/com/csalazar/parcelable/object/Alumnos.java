package com.csalazar.parcelable.object;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by csalazar on 6/09/2017.
 */

public class Alumnos implements Parcelable {
    private String nombre;
    private String apellidos;

    protected Alumnos(Parcel in) {
        nombre = in.readString();
        apellidos = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nombre);
        dest.writeString(apellidos);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Alumnos> CREATOR = new Parcelable.Creator<Alumnos>() {
        @Override
        public Alumnos createFromParcel(Parcel in) {
            return new Alumnos(in);
        }

        @Override
        public Alumnos[] newArray(int size) {
            return new Alumnos[size];
        }
    };

    public Alumnos() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
}
