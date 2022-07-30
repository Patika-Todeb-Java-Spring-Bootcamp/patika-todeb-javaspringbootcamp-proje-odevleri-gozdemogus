package com.patika.springbootcamp.controller;

import com.patika.springbootcamp.exception.RecordNotFoundException;
import com.patika.springbootcamp.model.dto.OrderDTO;
import com.patika.springbootcamp.model.entity.Order;
import com.patika.springbootcamp.model.mapper.OrderMapper;
import com.patika.springbootcamp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    public OrderService orderService;
    @Autowired
    public OrderMapper orderMapper;

    @GetMapping(path = "/all")
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> order = orderService.getAllOrders();
        return ResponseEntity.ok(order);
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable("id") Long id) {

        OrderDTO byId = orderService.findById(id);
        if (byId == null) {
            throw new RecordNotFoundException(String.valueOf(id));
        }
        return ResponseEntity.status(HttpStatus.OK).body(byId);
    }

    @PostMapping("/create")
    public ResponseEntity createNewOrder(@RequestBody OrderDTO orderDTO) {
        Order respOrder = orderService.createOrder(orderDTO);
        if (respOrder == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Order could not be created..");
        }
        OrderDTO orderDTO2 = orderMapper.toOrderDTO(respOrder);
        return ResponseEntity.status(HttpStatus.CREATED).body(orderDTO2);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteOrder(@PathVariable(name = "id") Long id) {
        try {
            orderService.deleteOrder(id);
        } catch (RuntimeException exception) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body("Order deleted successfully");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateOrder(
            @PathVariable Long id,
            @RequestBody OrderDTO orderDTO) {
        Order order = orderService.updateOrder(id, orderDTO);
        if (order == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Order could not be updated..");
        }
        OrderDTO orderDTO1 = orderMapper.toOrderDTO(order);
        return ResponseEntity.status(HttpStatus.OK).body(orderDTO1);
    }

    @PutMapping("/buy/{order_id}/{product_id}")
    public ResponseEntity buyProduct(@PathVariable(name = "order_id") Long order_id,
                                     @PathVariable(name = "product_id") Long product_id) {
        Order order = orderService.buyProduct(order_id, product_id);
        return ResponseEntity.status(HttpStatus.OK).body(order);
    }

    @PutMapping("/cancel/{id}")
    public ResponseEntity cancelPurchasing(@PathVariable Long id) {
        Order order = orderService.cancelPurchasing(id);
        return ResponseEntity.status(HttpStatus.OK).body(order);
    }

}
