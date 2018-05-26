package com.aether.boiler.core.service.impl;

import com.aether.boiler.core.domain.Customer;
import com.aether.boiler.core.repository.api.CustomerRepository;
import com.aether.boiler.core.service.api.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Created by keshav.gupta on 20/05/18.
 */
@Slf4j
@Component
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;


    @Override
    public Customer create(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Optional<Customer> find(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        return customer;
    }
}