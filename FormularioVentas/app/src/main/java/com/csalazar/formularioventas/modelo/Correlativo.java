package com.csalazar.formularioventas.modelo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by csalazar on 29/09/2017.
 */

public class Correlativo implements Parcelable {

    private String tipoFormulario;
    private int numero;

    public Correlativo() {
    }

    public Correlativo(String tipoFormulario, int numero) {
        this.tipoFormulario = tipoFormulario;
        this.numero = numero;
    }

    protected Correlativo(Parcel in) {
        tipoFormulario = in.readString();
        numero = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(tipoFormulario);
        dest.writeInt(numero);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Correlativo> CREATOR = new Parcelable.Creator<Correlativo>() {
        @Override
        public Correlativo createFromParcel(Parcel in) {
            return new Correlativo(in);
        }

        @Override
        public Correlativo[] newArray(int size) {
            return new Correlativo[size];
        }
    };

    public String getTipoFormulario() {
        return tipoFormulario;
    }

    public void setTipoFormulario(String tipoFormulario) {
        this.tipoFormulario = tipoFormulario;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}
