package com.aether.boiler.service.impl;

import com.aether.boiler.core.domain.Restaurant;
import com.aether.boiler.core.service.api.RestaurantService;
import com.aether.boiler.datatypes.request.RestaurantRequest;
import com.aether.boiler.enums.SuccessCodes;
import com.aether.boiler.service.api.RestaurantManagerService;
import com.ekart.transport.core.dto.response.ClientResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * Created by keshav.gupta on 25/05/18.
 */
@Slf4j
@Component
public class RestaurantManagerServiceImpl implements RestaurantManagerService {

    @Autowired
    RestaurantService restaurantService;

    @Override
    public ClientResponse create(RestaurantRequest restaurantRequest) {

        Restaurant restaurant = setDomainAttributes(restaurantRequest);
        restaurant = restaurantService.save(restaurant);
        return new ClientResponse(SuccessCodes.OK, HttpStatus.OK, restaurant);
    }

    private Restaurant setDomainAttributes(RestaurantRequest restaurantRequest) {

        return Restaurant.builder()
                .name(restaurantRequest.getName())
                .description(restaurantRequest.getDescription())
                .address(restaurantRequest.getAddress())
                .build();
    }
}
