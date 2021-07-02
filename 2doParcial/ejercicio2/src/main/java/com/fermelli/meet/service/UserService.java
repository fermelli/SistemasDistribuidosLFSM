package com.fermelli.meet.service;

import com.fermelli.meet.dao.entity.UserRepository;
import com.fermelli.meet.data.LoginData;
import com.fermelli.meet.security.JWTService;
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
        if ("sis258".equals(usuario) && "distribuidos".equals(password)) {
            return jwtService.generarToken(usuario);
        }
        return null;
    }

}
