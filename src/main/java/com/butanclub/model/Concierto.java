/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.butanclub.model;

import java.util.Date;

/**
 *
 * @author Pedro Luis
 */
public class Concierto {

    private int id;
    private String nombre;
    private String artista;
    private String hora;
    private String fecha;
    private float precio;
    private String genero;
    private String imagen;

    public Concierto(int _id, String _imagen, String _nombre, String _artista, float _precio, String _fecha, String _hora, String _genero) {
        id = _id;
        nombre = _nombre;
        artista = _artista;
        hora = _hora;
        fecha = _fecha;
        precio = _precio;
        genero = _genero;
        imagen = _imagen;
    }

    public Concierto() {
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getArtista() {
        return artista;
    }

    public String getHora() {
        return hora;
    }

    public String getFecha() {
        return fecha;
    }

    public float getPrecio() {
        return precio;
    }

    public String getGenero() {
        return genero;
    }

    public String getImagen() {
        return imagen;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

}
