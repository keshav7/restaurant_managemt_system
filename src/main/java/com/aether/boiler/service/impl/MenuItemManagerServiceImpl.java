package com.aether.boiler.service.impl;

import com.aether.boiler.core.domain.MenuItem;
import com.aether.boiler.core.domain.Restaurant;
import com.aether.boiler.core.service.api.MenuItemService;
import com.aether.boiler.core.service.api.RestaurantService;
import com.aether.boiler.datatypes.request.MenuItemRequest;
import com.aether.boiler.enums.SuccessCodes;
import com.aether.boiler.service.api.MenuItemManagerService;
import com.ekart.transport.core.dto.response.ClientResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Created by keshav.gupta on 23/05/18.
 */
@Slf4j
@Component
public class MenuItemManagerServiceImpl implements MenuItemManagerService{

    @Autowired
    MenuItemService menuItemService;

    @Autowired
    RestaurantService restaurantService;

    @Override
    public ClientResponse create(MenuItemRequest menuItemRequest) {
        MenuItem menuItem = setDomainAttributes(menuItemRequest);
        menuItem = menuItemService.save(menuItem);
        return new ClientResponse(SuccessCodes.OK, HttpStatus.OK, menuItem);
    }

    @Override
    public MenuItem get(Long menuItemId) {
        return null;
    }

    private MenuItem setDomainAttributes(MenuItemRequest request) {
        Optional<Restaurant> restaurant = restaurantService.find(request.getRestaurantId());
        return MenuItem.builder()
                .restaurant(restaurant.get())
                .name(request.getName())
                .price(request.getPrice())
                .type(request.getType())
                .description(request.getDescription()).build();
    }
}
