package com.aether.boiler.core.service.impl;

import com.aether.boiler.core.domain.OrderMenuItem;
import com.aether.boiler.core.repository.api.OrderMenuItemRepository;
import com.aether.boiler.core.service.api.OrderMenuItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by keshav.gupta on 23/05/18.
 */
@Slf4j
@Component
public class OrderMenuItemServiceImpl  implements OrderMenuItemService{

    @Autowired
    OrderMenuItemRepository orderMenuItemRepository;

    @Override
    public Iterable<OrderMenuItem> save(List<OrderMenuItem> orderMenuItemList) {
        return orderMenuItemRepository.saveAll(orderMenuItemList);
    }

    @Override
    public OrderMenuItem save(OrderMenuItem orderMenuItem) {
        return orderMenuItemRepository.save(orderMenuItem);
    }
}
