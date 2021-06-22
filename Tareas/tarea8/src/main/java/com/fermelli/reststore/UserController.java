package com.fermelli.reststore;

import com.fermelli.reststore.data.User;
import com.fermelli.reststore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * Retorna toda la lista de usuarios
     *
     * @return lista de usuarios
     */
    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = userService.getUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    /**
     * Crea un nuevo usuario en base a un formato json
     *
     * @param user
     * @return nuevo usuario creado
     */
    @PostMapping(value = "/")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        final User userData = userService.create(user);
        return new ResponseEntity<>(userData, HttpStatus.CREATED);
    }

    /**
     * Devuelve informacion del usuario en base a su ID
     *
     * @param id
     * @return detalles del cliente
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        User user = userService.getUser(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    /**
     * Remueve un usuario en base a su ID proporcionado
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Actualizar los datos de un usuario en base a su ID
     *
     * @param id
     * @return detalles del usuario
     */
    @PutMapping(value = "/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable Long id) {
        user = userService.update(user, id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
