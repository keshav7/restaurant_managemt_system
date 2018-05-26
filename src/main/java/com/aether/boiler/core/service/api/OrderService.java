package com.aether.boiler.core.service.api;

import com.aether.boiler.core.domain.Order;
import com.aether.boiler.datatypes.request.OrderRequest;

/**
 * Created by keshav.gupta on 18/05/18.
 */
public interface OrderService{
    Order createOrder(OrderRequest orderRequest);
}
