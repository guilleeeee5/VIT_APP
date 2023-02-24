package com.VITAPP.Backend;

public class Discapacitado_VIsual extends User{
    private String edificio;
    private int[][] mapa;

    public Discapacitado_VIsual(String name, String apellido, String password, String email, int ID, String[] edificios, int[][] mapa) {
        super(name, apellido, password, email, ID);
        this.edificio = edificio;
        this.mapa = mapa;
    }

    public Discapacitado_VIsual() {
    }

    public String getEdificios() {
        return edificio;
    }

    public void setEdificios(String[] edificios) {
        this.edificio = edificio;
    }

    public int[][] getMapa() {
        return mapa;
    }

    public void setMapa(int[][] mapa) {
        this.mapa = mapa;
    }
}
