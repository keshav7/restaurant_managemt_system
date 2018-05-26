package com.aether.boiler.core.service.api;

import com.aether.boiler.core.domain.MenuItem;

import java.util.List;
import java.util.Optional;

/**
 * Created by keshav.gupta on 23/05/18.
 */
public interface MenuItemService {
    Optional<MenuItem> find(Long itemId);
    Iterable<MenuItem> find(List<Long> itemIds);
    MenuItem save(MenuItem menuItem);
}
