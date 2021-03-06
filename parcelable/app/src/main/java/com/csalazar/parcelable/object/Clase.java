package com.csalazar.parcelable.object;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by csalazar on 6/09/2017.
 */

public class Clase implements Parcelable {
    private String nombre;
    private String descripcion;
    List<Alumnos> alumnos = new ArrayList<>();

    protected Clase(Parcel in) {
        nombre = in.readString();
        descripcion = in.readString();
        if (in.readByte() == 0x01) {
            alumnos = new ArrayList<Alumnos>();
            in.readList(alumnos, Alumnos.class.getClassLoader());
        } else {
            alumnos = null;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nombre);
        dest.writeString(descripcion);
        if (alumnos == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(alumnos);
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Clase> CREATOR = new Parcelable.Creator<Clase>() {
        @Override
        public Clase createFromParcel(Parcel in) {
            return new Clase(in);
        }

        @Override
        public Clase[] newArray(int size) {
            return new Clase[size];
        }
    };

    public Clase() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Alumnos> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumnos> alumnos) {
        this.alumnos = alumnos;
    }
}
