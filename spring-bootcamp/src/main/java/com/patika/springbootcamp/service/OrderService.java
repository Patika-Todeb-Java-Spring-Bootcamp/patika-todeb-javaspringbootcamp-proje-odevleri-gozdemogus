package com.patika.springbootcamp.service;

import com.patika.springbootcamp.exception.EntityNotFoundException;
import com.patika.springbootcamp.model.dto.OrderDTO;
import com.patika.springbootcamp.model.entity.Order;
import com.patika.springbootcamp.model.entity.Product;
import com.patika.springbootcamp.model.mapper.OrderMapper;
import com.patika.springbootcamp.repository.OrderRepository;
import com.patika.springbootcamp.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final OrderMapper orderMapper;

    public List<Order> getAllOrders() {
        List<Order> allOrders = orderRepository.findAll();
        //  List<OrderDTO> allOrderDTOs = orderMapper.toOrderDTOs(allOrders);
        return allOrders;
    }

    public OrderDTO findById(Long id) {
        Order order = orderRepository.findOrderById(id);
        OrderDTO orderDTO = orderMapper.toOrderDTO(order);
        return orderDTO;
    }

    public Order createOrder(OrderDTO orderDTO) {
        Order order = orderMapper.toOrder(orderDTO);
        Order savedOrder = orderRepository.save(order);
        return savedOrder;
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    public Order updateOrder(Long id, OrderDTO newOrderDTO) {
        Order order = orderMapper.toOrder(newOrderDTO);
        Order orderById = orderRepository.findOrderById(id);
        if (orderById == null) {
            throw new EntityNotFoundException(String.valueOf(orderById.getId()));
        }
        orderById.setFinished(order.isFinished());
        orderById.setBoughtProductId(order.getBoughtProductId());
        orderById.setConfirmed(order.isConfirmed());
        return orderById;
    }

    public Order buyProduct(Long OrderId, Long ProductId) {
        Order orderById = orderRepository.findOrderById(OrderId);
        Product productById = productRepository.findProductById(ProductId);
        orderById.setBoughtProductId(productById.getId());
        return orderById;
    }

    public Order cancelPurchasing(Long OrderId) {
        Order orderById = orderRepository.findOrderById(OrderId);
        orderById.setConfirmed(false);
        return orderById;
    }

}
