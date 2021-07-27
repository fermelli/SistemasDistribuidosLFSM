package com.fermelli.alumnos.dao.entity;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserModel, Long> {
    
    Optional<UserModel> findByUsernameAndPassword(String username, String password);
}
