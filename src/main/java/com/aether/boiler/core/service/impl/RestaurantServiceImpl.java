package com.aether.boiler.core.service.impl;

import com.aether.boiler.core.domain.Restaurant;
import com.aether.boiler.core.repository.api.RestaurantRepository;
import com.aether.boiler.core.service.api.RestaurantService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Created by keshav.gupta on 23/05/18.
 */
@Slf4j
@Component
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    RestaurantRepository restaurantRepository;


    @Override
    public Restaurant save(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    @Override
    public Optional<Restaurant> find(Long id) {
        return restaurantRepository.findById(id);
    }
}
