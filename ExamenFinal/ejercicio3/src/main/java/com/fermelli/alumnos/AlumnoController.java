package com.fermelli.alumnos;

import com.fermelli.alumnos.data.Alumno;
import com.fermelli.alumnos.security.JWTService;
import com.fermelli.alumnos.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/alumnos")
public class AlumnoController {

    @Autowired
    AlumnoService alumnoService;
    JWTService jwtService = new JWTService();

    /**
     * Retorna toda la lista de alumnos
     *
     * @param token
     * @return lista de alumnos
     */
    @GetMapping
    public ResponseEntity<List<Alumno>> getAlumnos(@RequestHeader("Authorization") String token) {
        if (jwtService.verificarToken(token)) {
            List<Alumno> alumnos = alumnoService.getAlumnos();
            return new ResponseEntity<>(alumnos, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    /**
     * Crea un nuevo alumno en base a un formato json
     *
     * @param token
     * @param alumno
     * @return nuevo alumno creada
     */
    @PostMapping(value = "/")
    public ResponseEntity<Alumno> createAlumno(@RequestHeader("Authorization") String token, @RequestBody Alumno alumno) {
        if (jwtService.verificarToken(token)) {
            int nivel = Integer.parseInt(jwtService.obtenerDatoDelToken(token, "nivel"));
            if (nivel == 1) {
                final Alumno alumnoData = alumnoService.create(alumno);
                return new ResponseEntity<>(alumnoData, HttpStatus.CREATED);
            }
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    /**
     * Devuelve informacion del alumno en base a su ID
     *
     * @param token
     * @param id
     * @return detalles del alumno
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<Alumno> getMeet(@RequestHeader("Authorization") String token, @PathVariable Long id) {
        if (jwtService.verificarToken(token)) {
            int nivel = Integer.parseInt(jwtService.obtenerDatoDelToken(token, "nivel"));
            if (nivel == 1) {
                Alumno alumno = alumnoService.getAlumno(id);
                return new ResponseEntity<>(alumno, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    /**
     * Remueve un alumno en base a su ID proporcionado
     *
     * @param token
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteAlumno(@RequestHeader("Authorization") String token, @PathVariable Long id) {
        if (jwtService.verificarToken(token)) {
            int nivel = Integer.parseInt(jwtService.obtenerDatoDelToken(token, "nivel"));
            if (nivel == 1) {
                alumnoService.delete(id);
                return new ResponseEntity<>(HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    /**
     * Actualizar los datos de un alumno en base a su ID
     *
     * @param token
     * @param alumno
     * @param id
     * @return detalles del alumno
     */
    @PutMapping(value = "/{id}")
    public ResponseEntity<Alumno> updateAlumno(@RequestHeader("Authorization") String token, @RequestBody Alumno alumno, @PathVariable Long id) {
        if (jwtService.verificarToken(token)) {
            int nivel = Integer.parseInt(jwtService.obtenerDatoDelToken(token, "nivel"));
            if (nivel == 1) {
                alumno = alumnoService.update(alumno, id);
                return new ResponseEntity<>(alumno, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

}
