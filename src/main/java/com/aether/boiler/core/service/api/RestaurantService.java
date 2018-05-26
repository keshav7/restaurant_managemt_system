package com.aether.boiler.core.service.api;

import com.aether.boiler.core.domain.Restaurant;

import java.util.Optional;

/**
 * Created by keshav.gupta on 23/05/18.
 */
public interface RestaurantService {

    Restaurant save(Restaurant restaurant);
    Optional<Restaurant> find(Long id);
}
