package com.Assignment.onlineLibrary.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Assignment.onlineLibrary.entity.userEntity;

public interface UserRepository extends JpaRepository<userEntity, Long> {
    
        Optional<userEntity> findByEmail(String email);

}

