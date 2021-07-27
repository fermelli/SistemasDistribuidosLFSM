package com.fermelli.alumnos.service;

import com.fermelli.alumnos.dao.entity.UserModel;
import com.fermelli.alumnos.dao.entity.UserRepository;
import com.fermelli.alumnos.data.LoginData;
import com.fermelli.alumnos.data.User;
import com.fermelli.alumnos.security.JWTService;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    JWTService jwtService = new JWTService();

    public String login(LoginData loginData) {
        String usuario = loginData.getUsuario();
        String password = loginData.getPassword();
        Optional<UserModel> user = userRepository.findByUsernameAndPassword(usuario, password);
        if (user.isPresent()) {
            User userData = new User();
            BeanUtils.copyProperties(user.get(), userData);
            return jwtService.generarToken(userData.getUsername(), userData.getNivel());
        }
        return null;
    }

}
