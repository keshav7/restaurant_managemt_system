package com.aether.boiler.core.service.impl;

import com.aether.boiler.core.domain.Customer;
import com.aether.boiler.core.domain.Order;
import com.aether.boiler.core.enums.OrderState;
import com.aether.boiler.core.repository.api.OrderRepository;
import com.aether.boiler.core.service.api.CustomerService;
import com.aether.boiler.core.service.api.OrderService;
import com.aether.boiler.datatypes.request.OrderRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by keshav.gupta on 18/05/18.
 */
@Slf4j
@Component
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    CustomerService customerService;


    @Override
    public Order createOrder(OrderRequest orderRequest) {

        Customer customer = customerService.find(orderRequest.getCustomerId()).get();
        Order order = setDomainAttributesForLoadUnit(orderRequest, customer);
        order = orderRepository.save(order);

        return order;
    }



    private Order setDomainAttributesForLoadUnit(OrderRequest orderRequest, Customer customer) {
        Order order = new Order();
        order.setCustomer(customer);
        order.setPrice(orderRequest.getTotalPrice());
        order.setState(OrderState.CREATED);
        return order;

    }

}
