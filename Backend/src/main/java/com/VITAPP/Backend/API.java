package com.VITAPP.Backend;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;

@RestController
public class API {
    //Inicio de sesion
    @GetMapping("/Discapacitado_Visual")
    public Discapacitado_VIsual iniciarSesionDisc(@RequestParam String email,@RequestParam String password) throws SQLException, ClassNotFoundException {
        DataHanding data = new DataHanding();
        return data.comprobarDisc(email, password);
    }
    @GetMapping("/Jefe_Establecimiento")
    public Jefe_Establecimiento iniciarSesionJefe(@RequestParam String email,@RequestParam String password) throws SQLException, ClassNotFoundException {
        DataHanding data = new DataHanding();
        return data.comprobarJefe(email, password);
    }
    @GetMapping("/Admin")
    public Admin iniciarSesionAdmin(@RequestParam String email,@RequestParam String password) throws SQLException, ClassNotFoundException {
        DataHanding data = new DataHanding();
        return data.comprobarAdmin(email, password);
    }

    @GetMapping("/gestionEstablecimiento")
    public ArrayList<Jefe_Establecimiento> get_Establecimientos() throws SQLException, ClassNotFoundException{
        DataHanding data = new DataHanding();
        return data.devolverEstablecimientos();

    }

    @PostMapping("/Discapacitado_Visual_Registro")
    public Discapacitado_VIsual crearRegistroDiscapacitado(@RequestBody Discapacitado_VIsual discapacitado_visual) throws SQLException, ClassNotFoundException {
        DataHanding data = new DataHanding();
        return data.comprobarRegistro(discapacitado_visual);
    }

    @PostMapping("/Jefe_Establecimiento_Registro")
    public Jefe_Establecimiento crearRegistroJefeEstablecimiento(@RequestBody Jefe_Establecimiento jefe_establecimiento) throws SQLException, ClassNotFoundException {
        DataHanding data = new DataHanding();
        return data.comprobarRegistroJefeEstablecimiento(jefe_establecimiento);
    }

    @DeleteMapping("/Jefe_Establecimiento/{cif}")
    public ArrayList<Jefe_Establecimiento> eliminarJefe(@PathVariable String cif) throws SQLException, ClassNotFoundException {
        DataHanding data = new DataHanding();
        data.eliminarJefe(cif);
        return data.devolverEstablecimientos();
    }

    @PutMapping("/Jefe_Establecimiento")
    public ArrayList<Jefe_Establecimiento> modificarjefe(@RequestBody ArrayList<Jefe_Establecimiento> jefesActualziar) throws SQLException, ClassNotFoundException {
        DataHanding data = new DataHanding();
        Jefe_Establecimiento jefeAntiguo = jefesActualziar.get(0);
        Jefe_Establecimiento jefeNuevo = jefesActualziar.get(1);
        return data.modificarJefe(jefeAntiguo, jefeNuevo);
    }

    /*@PutMapping(value = "/Imagen/{cif}")
    public ResponseEntity<String> actualizarImagen(@PathVariable String cif, @RequestBody Jefe_Establecimiento request) {
        String imagenBase64 = request.getImagen().toString();
        byte[] imagenBytes = Base64.getDecoder().decode(imagenBase64);

        // Actualizar la imagen en la base de datos utilizando el cif del jefe de establecimiento
        // ...

        return ResponseEntity.ok("Imagen actualizada correctamente");

    }*/
    @PutMapping("/Imagen/{cif}")
    public ResponseEntity<String> actualizarImagen(@PathVariable String cif, @RequestBody byte[] imagenBytes) {
        try {
            // Decodificar la imagen y almacenarla en la base de datos
            String imagenBase64 = Base64.getEncoder().encodeToString(imagenBytes);

            DataHanding dataHanding = new DataHanding();
            dataHanding.guardarImagen(imagenBase64, cif);

            // Devolver una respuesta satisfactoria
            return ResponseEntity.ok("Imagen actualizada correctamente");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al actualizar la imagen");
        }
    }

}
