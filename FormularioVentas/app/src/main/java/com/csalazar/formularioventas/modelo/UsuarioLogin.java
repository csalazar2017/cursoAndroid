package com.csalazar.formularioventas.modelo;

/**
 * Created by csalazar on 27/09/2017.
 */

public class UsuarioLogin {
    private String idUsuario;
    private String nombre;
    private String password;

    public UsuarioLogin(String idUsuario, String nombre, String password) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.password = password;
    }

    public UsuarioLogin() {
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
