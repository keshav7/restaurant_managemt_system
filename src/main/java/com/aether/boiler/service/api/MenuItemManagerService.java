package com.aether.boiler.service.api;

import com.aether.boiler.core.domain.MenuItem;
import com.aether.boiler.datatypes.request.MenuItemRequest;
import com.ekart.transport.core.dto.response.ClientResponse;

/**
 * Created by keshav.gupta on 23/05/18.
 */
public interface MenuItemManagerService {
    ClientResponse create(MenuItemRequest menuItemRequest);
    MenuItem get(Long menuItemId);
}
