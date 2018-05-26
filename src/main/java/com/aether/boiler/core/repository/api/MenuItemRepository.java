package com.aether.boiler.core.repository.api;

import com.aether.boiler.core.domain.MenuItem;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by keshav.gupta on 23/05/18.
 */
public interface MenuItemRepository extends CrudRepository<MenuItem, Long> {
}
