package com.fermelli.meet.dao.entity;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserModel, Long> {
    
    Optional<UserModel> findByEmailAndPassword(String email, String password);
}
