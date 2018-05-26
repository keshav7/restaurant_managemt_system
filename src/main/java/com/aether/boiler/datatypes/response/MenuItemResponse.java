package com.aether.boiler.datatypes.response;

import com.aether.boiler.core.enums.MenuItemType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by keshav.gupta on 23/05/18.
 */
@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MenuItemResponse {
    Long restaurantId;
    String name;
    MenuItemType type;
    String description;
    Double price;
    Integer quantity;
}
