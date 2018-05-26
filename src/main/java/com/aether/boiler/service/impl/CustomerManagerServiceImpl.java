package com.aether.boiler.service.impl;

import com.aether.boiler.core.domain.Customer;
import com.aether.boiler.core.service.api.CustomerService;
import com.aether.boiler.datatypes.request.CustomerRequest;
import com.aether.boiler.enums.SuccessCodes;
import com.aether.boiler.service.api.CustomerManagerService;
import com.ekart.transport.core.dto.response.ClientResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * Created by keshav.gupta on 20/05/18.
 */
@Slf4j
@Component
public class CustomerManagerServiceImpl implements CustomerManagerService{

    @Autowired
    CustomerService customerService;

    @Override
    public ClientResponse create(CustomerRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .phoneNumber(request.getPhoneNumber())
                .email(request.getEmail())
                .address(request.getAddress())
                .city(request.getCity())
                .country(request.getCountry()).build();

        customer =  customerService.create(customer);

        return new ClientResponse(SuccessCodes.OK, HttpStatus.OK, customer);
    }
}
