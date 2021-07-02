package com.fermelli.meet;

import com.fermelli.meet.data.Meet;
import com.fermelli.meet.security.JWTService;
import com.fermelli.meet.service.MeetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/meets")
public class MeetController {

    @Autowired
    MeetService meetService;
    JWTService jwtService = new JWTService();

    /**
     * Retorna toda la lista de reuniones
     *
     * @param token
     * @return lista de reuniones
     */
    @GetMapping
    public ResponseEntity<List<Meet>> getMeets(@RequestHeader("Authorization") String token) {
        if (jwtService.verificarToken(token)) {
            List<Meet> meets = meetService.getMeets();
            return new ResponseEntity<>(meets, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    /**
     * Crea una nueva reunion en base a un formato json
     *
     * @param token
     * @param meet
     * @return nueva reunion creada
     */
    @PostMapping(value = "/")
    public ResponseEntity<Meet> createMeet(@RequestHeader("Authorization") String token, @RequestBody Meet meet) {
        if (jwtService.verificarToken(token)) {
            final Meet productData = meetService.create(meet);
            return new ResponseEntity<>(productData, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    /**
     * Devuelve informacion de la reunion en base a su ID
     *
     * @param token
     * @param id
     * @return detalles de la reunion
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<Meet> getMeet(@RequestHeader("Authorization") String token, @PathVariable Long id) {
        if (jwtService.verificarToken(token)) {
            Meet meet = meetService.getMeet(id);
            return new ResponseEntity<>(meet, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    /**
     * Remueve una reunion en base a su ID proporcionado
     *
     * @param token
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteMeet(@RequestHeader("Authorization") String token, @PathVariable Long id) {
        if (jwtService.verificarToken(token)) {
            meetService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    /**
     * Actualizar los datos de una reunion en base a su ID
     *
     * @param token
     * @param meet
     * @param id
     * @return detalles de la reunion
     */
    @PutMapping(value = "/{id}")
    public ResponseEntity<Meet> updateMeet(@RequestHeader("Authorization") String token, @RequestBody Meet meet, @PathVariable Long id) {
        if (jwtService.verificarToken(token)) {
            meet = meetService.update(meet, id);
            return new ResponseEntity<>(meet, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

}
