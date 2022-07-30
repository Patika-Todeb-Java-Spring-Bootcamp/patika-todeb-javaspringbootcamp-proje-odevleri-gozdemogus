package com.patika.springbootcamp.model.mapper;

import com.patika.springbootcamp.model.dto.OrderDTO;
import com.patika.springbootcamp.model.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper(componentModel = "spring")
public interface OrderMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    OrderDTO toOrderDTO(Order order);

    List<OrderDTO> toOrderDTOs(List<Order> orders);

    Order toOrder(OrderDTO orderDTO);
}


