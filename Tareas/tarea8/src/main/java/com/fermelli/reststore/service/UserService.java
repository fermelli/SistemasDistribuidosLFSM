package com.fermelli.reststore.service;

import com.fermelli.reststore.dao.entity.UserModel;
import com.fermelli.reststore.dao.entity.UserRepository;
import com.fermelli.reststore.data.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User create(final User user) {

        UserModel userModel = new UserModel();
        BeanUtils.copyProperties(user, userModel);
        userModel = userRepository.save(userModel);

        User userData = new User();
        BeanUtils.copyProperties(userModel, userData);

        return userData;
    }

    public List<User> getUsers() {

        List<UserModel> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);

        List<User> userList = new ArrayList<>();
        for (UserModel userModel : users) {
            User user = new User();
            BeanUtils.copyProperties(userModel, user);
            userList.add(user);
        }

        return userList;
    }

    public User getUser(Long id) {

        Optional<UserModel> user = userRepository.findById(id);
        User userData = new User();
        BeanUtils.copyProperties(user.get(), userData);

        return userData;
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    public User update(final User user, Long id) {

        Optional<UserModel> optionalUser = userRepository.findById(id);
        UserModel recoveredUser;
        if (optionalUser.isPresent()) {
            recoveredUser = optionalUser.get(); //obtener directamente la clase producto
            BeanUtils.copyProperties(user, recoveredUser);
            recoveredUser = userRepository.save(recoveredUser);
            return user;
        } else {
            // Avisar al usuario de que no se ha encontrado el producto
            return null;
        }
    }

    public String login(String email, String password) {
        return "JSON Web Token";
    }

}
