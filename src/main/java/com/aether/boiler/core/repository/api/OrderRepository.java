package com.aether.boiler.core.repository.api;

import com.aether.boiler.core.domain.Order;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by keshav.gupta on 17/05/18.
 */
public interface OrderRepository extends CrudRepository<Order, Long> {

}