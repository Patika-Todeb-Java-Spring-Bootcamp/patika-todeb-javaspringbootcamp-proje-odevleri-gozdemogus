package com.patika.springbootcamp.model.mapper;

import com.patika.springbootcamp.model.dto.ProductDTO;
import com.patika.springbootcamp.model.dto.UserDTO;
import com.patika.springbootcamp.model.entity.Product;
import com.patika.springbootcamp.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO toUserDTO(User user);

    List<UserDTO> toUserDTOs(List<User> users);

    User toUser(UserDTO userDTO, @MappingTarget User user);

}

