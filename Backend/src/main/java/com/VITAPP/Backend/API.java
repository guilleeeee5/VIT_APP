package com.VITAPP.Backend;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

public class API {
    //Inicio de sesion
    @GetMapping("/Discapacitado_VIsual/{email}/{password}")
    public Discapacitado_VIsual iniciarSesionDisc(@PathVariable String email, String password){
        DataHanding data = new DataHanding();
    }
    @GetMapping("/Jefe_Establecimiento{email}/{password}")
    public Jefe_Establecimiento iniciarSesionJefe(@PathVariable String email, String password){
        DataHanding data = new DataHanding();
    }
}
