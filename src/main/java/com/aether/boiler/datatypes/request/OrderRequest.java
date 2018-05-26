package com.aether.boiler.datatypes.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by keshav.gupta on 13/05/18.
 */

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderRequest {

    @NotNull
    private Long customerId;
    @NotNull
    private List<ItemListRequest> itemList;
    @NotNull
    private Double totalPrice;

}
