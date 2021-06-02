package com.maciel.goettms.orderservice.controller;

import com.maciel.goettms.orderservice.model.Order;
import com.maciel.goettms.orderservice.repository.OrderRepository;
import com.maciel.goettms.orderservice.service.SaveOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/orderservices")
public class OrderServiceController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private SaveOrderService saveOrderService;

    @GetMapping
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<Order> get(@PathVariable Long orderId) {
        return orderRepository.findById(orderId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Order adicionar(@Valid @RequestBody Order order) {
        return saveOrderService.save(order);
    }

    @PutMapping("/{orderId}")
    public ResponseEntity<Order> update(@PathVariable Long orderId,
                                           @Valid @RequestBody Order order) {
        if (!orderRepository.existsById(orderId)) {
            return ResponseEntity.notFound().build();
        }

        order.setId(orderId);
        order = saveOrderService.save(order);

        return ResponseEntity.ok(order);
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<Void> delete(@PathVariable Long orderId) {
        if (!orderRepository.existsById(orderId)) {
            return ResponseEntity.notFound().build();
        }

        orderRepository.deleteById(orderId);

        return ResponseEntity.noContent().build();
    }

}
