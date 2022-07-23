package com.patika.springbootcamp.service;

import com.patika.springbootcamp.model.dto.ProductDTO;
import com.patika.springbootcamp.model.dto.UserDTO;
import com.patika.springbootcamp.model.entity.Product;
import com.patika.springbootcamp.model.entity.User;
import com.patika.springbootcamp.model.mapper.UserMapper;
import com.patika.springbootcamp.repository.ProductRepository;
import com.patika.springbootcamp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final ProductRepository productRepository;


    //user buys product
    public User buyProduct(Long userId, Long productid) {

        User user = userRepository.findById(userId).get();
        Product productByTitle = productRepository.findProductById(productid);
        List<Product> productSet = user.getProductsBought();
        productSet.add(productByTitle);
        user.setProductsBought(productSet);
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        List<User> allUsers = userRepository.findAll();
        return allUsers;
    }


    public User getById(Long id) {
        Optional<User> byId = userRepository.findById(id);
        return byId.orElseThrow(() -> new RuntimeException(" not found!"));
    }

    public User create(UserDTO userDTO) {
        User user = UserMapper.toEntity(userDTO);
        return userRepository.save(user);
    }

    public void delete(Long id) {
        getById(id);
        userRepository.deleteById(id);
    }

    public User update(String username, UserDTO userDTO) {
        Optional<User> userByUsername = userRepository.findUserByUsername(username);
        if (!userByUsername.isPresent())
            return null;
        User updatedUser = userByUsername.get();
        if (!StringUtils.isEmpty(userDTO.getUsername())) {
            updatedUser.setUsername(userDTO.getUsername());
        }
        if (!StringUtils.isEmpty(userDTO.getAbout())) {
            updatedUser.setAbout(userDTO.getAbout());
        }

        return userRepository.save(updatedUser);
    }

}
