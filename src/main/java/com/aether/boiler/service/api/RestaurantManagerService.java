package com.aether.boiler.service.api;

import com.aether.boiler.datatypes.request.RestaurantRequest;
import com.ekart.transport.core.dto.response.ClientResponse;

/**
 * Created by keshav.gupta on 25/05/18.
 */
public interface RestaurantManagerService {

    ClientResponse create(RestaurantRequest restaurantRequest);

}
