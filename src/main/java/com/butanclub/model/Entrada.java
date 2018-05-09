/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.butanclub.model;

/**
 *
 * @author Jose Manuel Navarro
 */
public class Entrada {

    private int id;
    private String usuario;
    private int concierto;
    private int cantidad;

    public Entrada(String usuario, int concierto, int cantidad) {
        this.usuario = usuario;
        this.concierto = concierto;
        this.cantidad = cantidad;
    }

    public Entrada(int id, String usuario, int concierto, int cantidad) {
        this.id = id;
        this.usuario = usuario;
        this.concierto = concierto;
        this.cantidad = cantidad;
    }

    public int getId() {
        return id;
    }

    public String getUsuario() {
        return usuario;
    }

    public int getConcierto() {
        return concierto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setConcierto(int concierto) {
        this.concierto = concierto;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Entrada() {
    }

}
