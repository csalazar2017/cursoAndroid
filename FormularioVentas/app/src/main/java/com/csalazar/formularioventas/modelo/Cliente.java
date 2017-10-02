package com.csalazar.formularioventas.modelo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by csalazar on 28/09/2017.
 */

public class Cliente implements Parcelable {

    private String imagen;
    private String nombre;
    private String direccion;
    private String nit;
    private String telefono;
    private String correo;
    private String contacto;
    private String coordenadaX;
    private String coordenadaY;
    private String numFormulario;

    public Cliente() {
    }

    public Cliente(String imagen, String nombre, String direccion, String nit, String telefono, String correo, String contacto, String coordenadaX, String coordenadaY, String numFormulario) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.direccion = direccion;
        this.nit = nit;
        this.telefono = telefono;
        this.correo = correo;
        this.contacto = contacto;
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
        this.numFormulario = numFormulario;
    }

    protected Cliente(Parcel in) {
        imagen = in.readString();
        nombre = in.readString();
        direccion = in.readString();
        nit = in.readString();
        telefono = in.readString();
        correo = in.readString();
        contacto = in.readString();
        coordenadaX = in.readString();
        coordenadaY = in.readString();
        numFormulario = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(imagen);
        dest.writeString(nombre);
        dest.writeString(direccion);
        dest.writeString(nit);
        dest.writeString(telefono);
        dest.writeString(correo);
        dest.writeString(contacto);
        dest.writeString(coordenadaX);
        dest.writeString(coordenadaY);
        dest.writeString(numFormulario);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Cliente> CREATOR = new Parcelable.Creator<Cliente>() {
        @Override
        public Cliente createFromParcel(Parcel in) {
            return new Cliente(in);
        }

        @Override
        public Cliente[] newArray(int size) {
            return new Cliente[size];
        }
    };

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getCoordenadaX() {
        return coordenadaX;
    }

    public void setCoordenadaX(String coordenadaX) {
        this.coordenadaX = coordenadaX;
    }

    public String getCoordenadaY() {
        return coordenadaY;
    }

    public void setCoordenadaY(String coordenadaY) {
        this.coordenadaY = coordenadaY;
    }

    public String getNumFormulario() {
        return numFormulario;
    }

    public void setNumFormulario(String numFormulario) {
        this.numFormulario = numFormulario;
    }
}
