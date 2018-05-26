package com.aether.boiler.controller;

import com.aether.boiler.datatypes.request.RestaurantRequest;
import com.aether.boiler.service.api.RestaurantManagerService;
import com.ekart.transport.core.dto.response.ClientResponse;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * Created by keshav.gupta on 25/05/18.
 */
@RestController
@RequestMapping("/restaurant/")
@Slf4j
@Api(value = "/", description = "Restaurant apis")
public class RestaurantController {

    @Autowired
    RestaurantManagerService restaurantManagerService;
    @RequestMapping(value = "create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public
    @ResponseBody
    ResponseEntity addRestaurant(
            @RequestBody @Valid RestaurantRequest request,
            HttpServletRequest httpServletRequest) {
        ClientResponse clientResponse = null;
        try {
            clientResponse = restaurantManagerService.create(request);
        } catch (Exception e) {
            log.error("LoadManagerException in  getLoadExpectationForUnloading", e);
        }
        return new ResponseEntity<>(clientResponse, clientResponse.getHttpStatus());
    }



}
