package org.vaadin.example;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

public class DataService {
    private static final String urlPrefix = "http://localhost:8081";

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

    public static Discapacitado_VIsual comprobarDiscInicio(String email, String pasword) throws IOException {
        String query = String.format("email=%s&password=%s",
                URLEncoder.encode(email, "UTF-8"),
                URLEncoder.encode(pasword, "UTF-8"));
        URL requestUrl = new URL(urlPrefix + "/Discapacitado_Visual" + "?" + query);

        Discapacitado_VIsual discAux = null;
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

        discAux = gson.fromJson(String.valueOf(response), new TypeToken<Discapacitado_VIsual>(){}.getType());

        // Imprimir la respuesta del backend
        System.out.println(response.toString());


        return discAux;
    }

    public static Admin comprobarAdminInicio(String email, String pasword) throws IOException {
        String query = String.format("email=%s&password=%s",
                URLEncoder.encode(email, "UTF-8"),
                URLEncoder.encode(pasword, "UTF-8"));
        URL requestUrl = new URL(urlPrefix + "/Admin" + "?" + query);

        Admin adminAux = null;
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

        adminAux = gson.fromJson(String.valueOf(response), new TypeToken<Admin>(){}.getType());

        // Imprimir la respuesta del backend
        System.out.println(response.toString());


        return adminAux;
    }
    public static boolean anhadirDiscapacitado(@RequestBody Discapacitado_VIsual discapacitadoVIsual){
        boolean result = false;
        Gson g = new Gson();
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String datospasar = discapacitadoVIsual.mostrarJson();
        StringEntity entidad = null;
        try {
            entidad = new StringEntity(datospasar);
            HttpPost requestpuesta = new HttpPost(urlPrefix + "/Discapacitado_Visual_Registro");
            requestpuesta.setHeader("Content-Type", "application/json");
            requestpuesta.setHeader("Accept", "application/json");
            requestpuesta.setEntity(entidad);
            CloseableHttpResponse response = null;
            response = httpClient.execute(requestpuesta);
            String respuestaActual = new BasicResponseHandler().handleResponse(response);
            discapacitadoVIsual = g.fromJson(respuestaActual, new TypeToken<Discapacitado_VIsual>(){}.getType());

        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (HttpResponseException e) {
            throw new RuntimeException(e);
        } catch (ClientProtocolException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if(discapacitadoVIsual.getName() != null){
            result = true;
        }
        return result;
    }
    public static boolean anhadirJefe(@RequestBody Jefe_Establecimiento jefeEstablecimiento){
        boolean result = false;
        Gson g = new Gson();
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String datospasar = jefeEstablecimiento.mostrarJson();
        StringEntity entidad = null;
        try {
            entidad = new StringEntity(datospasar);
            HttpPost requestpuesta = new HttpPost(urlPrefix + "/Jefe_Establecimiento_Registro");
            requestpuesta.setHeader("Content-Type", "application/json");
            requestpuesta.setHeader("Accept", "application/json");
            requestpuesta.setEntity(entidad);
            CloseableHttpResponse response = null;
            response = httpClient.execute(requestpuesta);
            String respuestaActual = new BasicResponseHandler().handleResponse(response);
            jefeEstablecimiento = g.fromJson(respuestaActual, new TypeToken<Jefe_Establecimiento>(){}.getType());

        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (HttpResponseException e) {
            throw new RuntimeException(e);
        } catch (ClientProtocolException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if(jefeEstablecimiento.getName() != null){
            result = true;
        }
        return result;
    }
}