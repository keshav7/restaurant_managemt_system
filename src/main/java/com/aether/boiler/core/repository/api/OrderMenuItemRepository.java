package com.aether.boiler.core.repository.api;

import com.aether.boiler.core.domain.OrderMenuItem;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by keshav.gupta on 23/05/18.
 */
public interface OrderMenuItemRepository extends CrudRepository<OrderMenuItem, Long> {
}
