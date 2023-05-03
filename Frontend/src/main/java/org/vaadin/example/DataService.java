package org.vaadin.example;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

public class DataService {
    private static final String urlPrefix = "http://localhost:8081";

    public static Jefe_Establecimiento comprobarJefeInicio(@RequestParam String email, @RequestParam String pasword) throws IOException {

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

        jefeEstablecimientoAux = gson.fromJson(String.valueOf(response), new TypeToken<Jefe_Establecimiento>() {
        }.getType());

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

        discAux = gson.fromJson(String.valueOf(response), new TypeToken<Discapacitado_VIsual>() {
        }.getType());

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

        adminAux = gson.fromJson(String.valueOf(response), new TypeToken<Admin>() {
        }.getType());

        // Imprimir la respuesta del backend
        System.out.println(response.toString());


        return adminAux;
    }

    public static boolean anhadirDiscapacitado(@RequestBody Discapacitado_VIsual discapacitadoVIsual) {
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
            discapacitadoVIsual = g.fromJson(respuestaActual, new TypeToken<Discapacitado_VIsual>() {
            }.getType());

        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (HttpResponseException e) {
            throw new RuntimeException(e);
        } catch (ClientProtocolException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (discapacitadoVIsual.getName() != null) {
            result = true;
        }
        return result;
    }

    public static boolean anhadirJefe(@RequestBody Jefe_Establecimiento jefeEstablecimiento) {
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
            jefeEstablecimiento = g.fromJson(respuestaActual, new TypeToken<Jefe_Establecimiento>() {
            }.getType());

        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (HttpResponseException e) {
            throw new RuntimeException(e);
        } catch (ClientProtocolException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (jefeEstablecimiento.getName() != null) {
            result = true;
        }
        return result;
    }

    public static ArrayList<Jefe_Establecimiento> obtenerListaEstablecimientos() throws IOException, URISyntaxException {

        ArrayList<Jefe_Establecimiento> jefito = new ArrayList<>();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(new URI(urlPrefix + "/gestionEstablecimiento")).GET().build();
        Gson gson = new Gson();
        String resultado = null;
        HttpResponse<String> respuesta = null;

        try {
            respuesta = HttpClient.newBuilder().build().send(httpRequest, HttpResponse.BodyHandlers.ofString());
            resultado = respuesta.body();
            jefito = gson.fromJson(resultado, new com.googlecode.gentyref.TypeToken<ArrayList<Jefe_Establecimiento>>() {
            }.getType());

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return jefito;
    }

    public static ArrayList<Jefe_Establecimiento> actualizarEstablecimiento(@RequestBody ArrayList<Jefe_Establecimiento> montarJSON) throws URISyntaxException, IOException {
        Gson g = new Gson();
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPut request = new HttpPut(urlPrefix + "/Jefe_Establecimiento");
        request.setHeader("Content-Type", "application/json");
        request.setHeader("Accept", "application/json");
        String jsonpasado = "[" + montarJSON.get(0).mostrarJson() + "," + montarJSON.get(1).mostrarJson() + "]";
        StringEntity stringEntity = new StringEntity(jsonpasado);
        request.setEntity(stringEntity);
        CloseableHttpResponse response = httpClient.execute(request);
        String respuestaActual = new BasicResponseHandler().handleResponse(response);

        montarJSON = g.fromJson(respuestaActual, new TypeToken<ArrayList<Jefe_Establecimiento>>() {
        }.getType());

        return montarJSON;
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/Jefe_Establecimiento/{cif}")
    public static ArrayList<Jefe_Establecimiento> eliminarJefeEstablecimiento(@PathVariable String cif) throws URISyntaxException, IOException, InterruptedException {
        Gson g = new Gson();
        ArrayList<Jefe_Establecimiento> listaDevuelta = new ArrayList<>();
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpDelete request = new HttpDelete(urlPrefix + "/Jefe_Establecimiento/" + cif);
        request.setHeader("Content-Type", "application/json");
        request.setHeader("Accept", "application/json");
        CloseableHttpResponse response = httpClient.execute(request);
        String respuestaActual = new BasicResponseHandler().handleResponse(response);
        listaDevuelta = g.fromJson(respuestaActual, new TypeToken<ArrayList<Jefe_Establecimiento>>() {
        }.getType());
        return listaDevuelta;
    }

    public static BufferedImage obtenerImagen(String cif) throws IOException, URISyntaxException {
        String url = urlPrefix + "/Imagen/" + cif;
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(new URI(url)).GET().build();
        HttpResponse<InputStream> respuesta = null;
        try {
            respuesta = HttpClient.newBuilder().build().send(httpRequest, HttpResponse.BodyHandlers.ofInputStream());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        BufferedImage imagen = null;
        try (InputStream inputStream = respuesta.body()) {
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            int nRead;
            byte[] data = new byte[102400];
            while ((nRead = inputStream.read(data, 0, data.length)) != -1) {
                buffer.write(data, 0, nRead);
            }
            buffer.flush();
            byte[] bytes = buffer.toByteArray();
            imagen = ImageIO.read(new ByteArrayInputStream(bytes));
        }
        return imagen;
    }


}