package com.maciel.goettms.orderservice.service;

import com.maciel.goettms.orderservice.model.Order;
import com.maciel.goettms.orderservice.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class SaveOrderService {

//    @Autowired
    private OrderRepository orderRepository;

//    @Autowired
    private SaveEquipmentService saveEquipmentService;

    public Order save(Order order) {
        if (order.getEquipment().getId()==null) {
           order.getEquipment().setId(saveEquipmentService.save(order.getEquipment()).getId());
        }

        return orderRepository.save(order);
    }

}
