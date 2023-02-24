package com.VITAPP.Backend;

public class DataHanding {
    public Discapacitado_VIsual comprobarDisc(String email, String password){
        Discapacitado_VIsual discapacitadAUX = new Discapacitado_VIsual();
        //Consulta BBDD
        return discapacitadAUX;
    }
    public Jefe_Establecimiento comprobarJefe(String email, String password){
        Jefe_Establecimiento jefeAux = new Jefe_Establecimiento();
        //Consulta BBDD
        return jefeAux;
    }
    public Admin comprobarAdmin(String email, String password){
        Admin adminAux = new Admin();
        //Consulta BBDD
        return adminAux;
    }
}
