package com.fermelli.alumnos;

import com.fermelli.alumnos.data.LoginData;
import com.fermelli.alumnos.security.JWTService;
import com.fermelli.alumnos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    UserService userService;
    JWTService jwtService = new JWTService();

    /**
     * Devuelve un token para autenticar al usuario
     *
     * @param loginData
     * @return token de autenticacion
     */
    @PostMapping(value = "/login")
    public ResponseEntity<String> getToken(@RequestBody LoginData loginData) {
        String token = userService.login(loginData);
        if (token == null) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity<>(token, HttpStatus.OK);
    }

}
