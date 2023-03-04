package com.VITAPP.Backend;

import java.util.Arrays;

public class Discapacitado_VIsual extends User{
    private String edificio;
    private int[][] mapa;

    public Discapacitado_VIsual(int ID, String name, String apellido, String password, String email,  String edificio, int[][] mapa) {
        super(ID, name, apellido, password, email);
        this.edificio = edificio;
        this.mapa = mapa;
    }

    public Discapacitado_VIsual() {
    }

    public String getEdificios() {
        return edificio;
    }

    public void setEdificio(String edificio) {
        this.edificio = edificio;
    }

    public int[][] getMapa() {
        return mapa;
    }

    public void setMapa(int[][] mapa) {
        this.mapa = mapa;
    }


}
