package org.vaadin.example;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

public class DataService {
    private static final String urlPrefix = "http://localhost:8081";
    @RequestMapping("/Jefe_Establecimiento/")
    public static Jefe_Establecimiento comprobarJefeInicio(@RequestParam String email,@RequestParam String pasword) throws IOException {

        String query = String.format("email=%s&password=%s",
                URLEncoder.encode(email, "UTF-8"),
                URLEncoder.encode(pasword, "UTF-8"));
        URL requestUrl = new URL(urlPrefix + "/Jefe_Establecimiento" + "?" + query);

        Jefe_Establecimiento jefeEstablecimientoAux = null;
        // Crear una conexión HTTP
        HttpURLConnection connection = (HttpURLConnection) requestUrl.openConnection();
        connection.setRequestMethod("GET");

        // Leer la respuesta del backend
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        Gson gson = new Gson();

        jefeEstablecimientoAux = gson.fromJson(String.valueOf(response), new TypeToken<Jefe_Establecimiento>(){}.getType());

        // Imprimir la respuesta del backend
        System.out.println(response.toString());


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
