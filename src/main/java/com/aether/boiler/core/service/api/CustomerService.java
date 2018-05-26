package com.aether.boiler.core.service.api;

import com.aether.boiler.core.domain.Customer;

import java.util.Optional;

/**
 * Created by keshav.gupta on 20/05/18.
 */
public interface CustomerService {

    Customer create(Customer customer);
    Optional<Customer> find(Long id);
}
