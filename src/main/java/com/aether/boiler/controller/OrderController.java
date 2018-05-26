package com.aether.boiler.controller;

import com.aether.boiler.datatypes.request.OrderRequest;
import com.aether.boiler.service.api.OrderManagerService;
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
 * Created by keshav.gupta on 13/05/18.
 */

@RestController
@RequestMapping("/order/")
@Slf4j
@Api(value = "/", description = "Order apis")
public class OrderController {

    @Autowired
    OrderManagerService orderManagerService;

    @RequestMapping(value = "create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public
    @ResponseBody
    ResponseEntity createOrder(
            @RequestBody @Valid OrderRequest request,
            HttpServletRequest httpServletRequest) {
        ClientResponse clientResponse = null;
        try {
            clientResponse = orderManagerService.createOrder(request);
        } catch (Exception e) {
            log.error("LoadManagerException in  getLoadExpectationForUnloading", e);
        }
        return new ResponseEntity<>(clientResponse, clientResponse.getHttpStatus());
    }
}
