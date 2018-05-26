package com.aether.boiler.core.service.impl;

import com.aether.boiler.core.domain.MenuItem;
import com.aether.boiler.core.repository.api.MenuItemRepository;
import com.aether.boiler.core.service.api.MenuItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * Created by keshav.gupta on 23/05/18.
 */
@Slf4j
@Component
public class MenuItemServiceImpl implements MenuItemService{


    @Autowired
    MenuItemRepository menuItemRepository;

    @Override
    public Optional<MenuItem> find(Long itemId) {
        return menuItemRepository.findById(itemId);
    }

    @Override
    public Iterable<MenuItem> find(List<Long> itemIds) {
        return menuItemRepository.findAllById(itemIds);
    }

    @Override
    public MenuItem save(MenuItem menuItem) {
        return menuItemRepository.save(menuItem);
    }
}
