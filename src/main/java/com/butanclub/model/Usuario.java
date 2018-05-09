/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.butanclub.model;


/**
 *
 * @author Pedro Luis
 */
public class Usuario {
    String usuario,contraseña,nombre,apellidos,correo,telefono,tipoUsuario;
    String fNacimiento;
    public Usuario(String usuario, String contraseña, String nombre, String apellidos, String correo, String telefono, String tipoUsuario, String fNacimiento) {
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.telefono = telefono;
        this.tipoUsuario = tipoUsuario;
        this.fNacimiento = fNacimiento;
    }

    public Usuario() {
        this.usuario = "";
        this.contraseña = "";
        this.nombre = "";
        this.apellidos = "";
        this.correo = "";
        this.telefono = "";
        this.tipoUsuario = "";
        this.fNacimiento = "";
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setfNacimiento(String fNacimiento) {
        this.fNacimiento = fNacimiento;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getfNacimiento() {
        return fNacimiento;
    }

}
