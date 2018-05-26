package com.aether.boiler.service.impl;

import com.aether.boiler.core.domain.MenuItem;
import com.aether.boiler.core.domain.Order;
import com.aether.boiler.core.domain.OrderMenuItem;
import com.aether.boiler.core.service.api.MenuItemService;
import com.aether.boiler.core.service.api.OrderMenuItemService;
import com.aether.boiler.core.service.api.OrderService;
import com.aether.boiler.datatypes.request.ItemListRequest;
import com.aether.boiler.datatypes.request.OrderRequest;
import com.aether.boiler.datatypes.response.MenuItemResponse;
import com.aether.boiler.datatypes.response.OrderResponse;
import com.aether.boiler.enums.SuccessCodes;
import com.aether.boiler.service.api.OrderManagerService;
import com.ekart.transport.core.dto.response.ClientResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by keshav.gupta on 20/05/18.
 */
@Slf4j
@Component
public class OrderManagerServiceImpl implements OrderManagerService {

    @Autowired
    OrderService orderService;

    @Autowired
    MenuItemService menuItemService;

    @Autowired
    OrderMenuItemService orderMenuItemService;

    @Override
    public ClientResponse createOrder(OrderRequest orderRequest) {

        Order order =  orderService.createOrder(orderRequest);

        List<ItemListRequest> itemListRequests = orderRequest.getItemList();
        List<Long> itemIds = itemListRequests.stream().map(ItemListRequest::getMenuItemId).collect(Collectors.toList());
        Iterable<MenuItem> menuItems = menuItemService.find(itemIds);
        Optional<MenuItem> menuItem;
        OrderMenuItem orderMenuItem;
        MenuItemResponse menuItemResponse;
        List<MenuItemResponse> menuItemResponseList = new ArrayList<>();
        for(ItemListRequest itemListRequest: itemListRequests) {
            menuItem = menuItemService.find(itemListRequest.getMenuItemId());
            orderMenuItem = new OrderMenuItem();
            orderMenuItem.setMenuItem(menuItem.get());
            orderMenuItem.setOrder(order);
            orderMenuItem.setQuantity(itemListRequest.getQuantity());
            orderMenuItemService.save(orderMenuItem);
            menuItemResponse = populateMenuItemResponse(menuItem.get());
            menuItemResponse.setQuantity(itemListRequest.getQuantity());
            menuItemResponseList.add(menuItemResponse);

        }

        OrderResponse orderResponse = OrderResponse.builder()
                .customerId(orderRequest.getCustomerId())
                .itemList(menuItemResponseList)
                .totalPrice(orderRequest.getTotalPrice()).build();

        return new ClientResponse(SuccessCodes.OK, HttpStatus.OK, orderResponse);
    }


    private MenuItemResponse populateMenuItemResponse(MenuItem menuItem) {
        return MenuItemResponse.builder()
                .name(menuItem.getName())
                .restaurantId(menuItem.getRestaurant().getId())
                .type(menuItem.getType())
                .description(menuItem.getDescription())
                .price(menuItem.getPrice())
                .build();

    }

}
