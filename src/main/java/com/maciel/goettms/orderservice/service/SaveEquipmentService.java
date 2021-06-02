package com.maciel.goettms.orderservice.service;

import com.maciel.goettms.orderservice.model.Equipment;
import com.maciel.goettms.orderservice.repository.CustomerRepository;
import com.maciel.goettms.orderservice.repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaveEquipmentService {

    @Autowired
    private EquipmentRepository equipmentRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public Equipment save (Equipment equipment) {
        if (equipment.getCustomer().getId() == null) {
            equipment.getCustomer().setId(customerRepository.save(equipment.getCustomer()).getId());
        }

        return  equipmentRepository.save(equipment);
    }
}
