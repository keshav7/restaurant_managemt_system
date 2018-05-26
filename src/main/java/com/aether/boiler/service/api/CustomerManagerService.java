package com.aether.boiler.service.api;

import com.aether.boiler.datatypes.request.CustomerRequest;
import com.ekart.transport.core.dto.response.ClientResponse;

/**
 * Created by keshav.gupta on 20/05/18.
 */
public interface CustomerManagerService {
    ClientResponse create(CustomerRequest request);
}
