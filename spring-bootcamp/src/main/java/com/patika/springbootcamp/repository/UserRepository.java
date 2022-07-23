package com.patika.springbootcamp.repository;

import com.patika.springbootcamp.model.dto.UserDTO;
import com.patika.springbootcamp.model.entity.Product;
import com.patika.springbootcamp.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByUsername(String title);
}
