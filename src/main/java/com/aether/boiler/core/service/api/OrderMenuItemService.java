package com.aether.boiler.core.service.api;

import com.aether.boiler.core.domain.OrderMenuItem;

import java.util.List;

/**
 * Created by keshav.gupta on 23/05/18.
 */
public interface OrderMenuItemService {

    Iterable<OrderMenuItem> save(List<OrderMenuItem> orderMenuItemList);
    OrderMenuItem save(OrderMenuItem orderMenuItem);
}
