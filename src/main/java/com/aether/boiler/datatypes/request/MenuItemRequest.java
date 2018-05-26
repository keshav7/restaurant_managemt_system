package com.aether.boiler.datatypes.request;

import com.aether.boiler.core.enums.MenuItemType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Created by keshav.gupta on 23/05/18.
 */
@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MenuItemRequest {

    @NotNull
    Long restaurantId;
    String name;
    @NotNull
    MenuItemType type;
    @NotNull
    String description;
    @NotNull
    Double price;

}
