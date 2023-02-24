package com.VITAPP.Backend;

public class Invidente extends User{
    private String[] edificios;
    private int[][] mapa;

    public Invidente(String name, String apellido, String password, String email, int ID, String[] edificios, int[][] mapa) {
        super(name, apellido, password, email, ID);
        this.edificios = edificios;
        this.mapa = mapa;
    }

    public Invidente() {
    }

    public String[] getEdificios() {
        return edificios;
    }

    public void setEdificios(String[] edificios) {
        this.edificios = edificios;
    }

    public int[][] getMapa() {
        return mapa;
    }

    public void setMapa(int[][] mapa) {
        this.mapa = mapa;
    }
}
