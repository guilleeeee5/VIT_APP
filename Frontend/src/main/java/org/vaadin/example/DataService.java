package org.vaadin.example;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class DataService {
    private static final String urlPrefix = "http://backend:8081";
    @RequestMapping
    public static Jefe_Establecimiento comprobarJefeInicio(String email, String pasword){
        //int n = BBDD.length();
        Jefe_Establecimiento jefeEstablecimientoAux = null;
        

        return jefeEstablecimientoAux;
    }
    @RequestMapping
    public static Discapacitado_VIsual comprobarDiscInicio(String email, String pasword){
        //int n = BBDD.length();
        Discapacitado_VIsual discapacitadoVIsual = null;


        return discapacitadoVIsual;
    }
    @RequestMapping
    public static Admin comprobarAdminInicio(String email, String pasword){
        //int n = BBDD.length();
        Admin admin = null;


        return admin;
    }
}
