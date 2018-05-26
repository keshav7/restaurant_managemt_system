package com.aether.boiler.controller;

import com.aether.boiler.datatypes.request.CustomerRequest;
import com.aether.boiler.service.api.CustomerManagerService;
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
 * Created by keshav.gupta on 20/05/18.
 */

@RestController
@RequestMapping("/customer/")
@Slf4j
@Api(value = "/", description = "Customer APIs")
public class CustomerController {



    @Autowired
    CustomerManagerService customerManagerService;

    @RequestMapping(value = "create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public
    @ResponseBody
    ResponseEntity createCustomer(
            @RequestBody @Valid CustomerRequest request,
            HttpServletRequest httpServletRequest) {
        ClientResponse clientResponse = null;
        try {
            clientResponse = customerManagerService.create(request);
        } catch (Exception e) {
            log.error("LoadManagerException in  getLoadExpectationForUnloading", e);
        }
        return new ResponseEntity<>(clientResponse, clientResponse.getHttpStatus());
    }


}
