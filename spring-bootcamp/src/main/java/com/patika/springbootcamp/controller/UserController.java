package com.patika.springbootcamp.controller;


import com.patika.springbootcamp.model.dto.ProductDTO;
import com.patika.springbootcamp.model.dto.UserDTO;
import com.patika.springbootcamp.model.entity.Product;
import com.patika.springbootcamp.model.entity.User;
import com.patika.springbootcamp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    //buy product
    @PutMapping("/{userid}/buy/{product_id}")
    public ResponseEntity buyProduct(
            @PathVariable Long userid,
            @PathVariable Long product_id) {
        User save = userService.buyProduct(userid, product_id);
        if (save == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("The operation could not be performed.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(save);

    }

    //get all
    @GetMapping(path = "/all")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> allUsers = userService.getAllUsers();
        return ResponseEntity.ok(allUsers);
    }

    //get particular user
    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable("id") Long id) {
        User byId;
        try {
            byId = userService.getById(id);
        } catch (RuntimeException exception) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(byId);
    }

    //add new user
    @PostMapping("/create")
    public ResponseEntity createNewProduct(@RequestBody UserDTO userDTO) {
        User respUser = userService.create(userDTO);
        if (respUser == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("User could not be created..");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(respUser);
    }

    //delete user
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable(name = "id") Long id) {
        try {
            userService.delete(id);
        } catch (RuntimeException exception) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body("User deleted successfully");
    }

    //update
    @PutMapping("/{username}")
    public ResponseEntity updateUser(
            @PathVariable String username,
            @RequestBody UserDTO userDTO) {
        User update = userService.update(username, userDTO);
        if (update == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("User could not be updated..");
        }
        return ResponseEntity.status(HttpStatus.OK).body(update);
    }

}
