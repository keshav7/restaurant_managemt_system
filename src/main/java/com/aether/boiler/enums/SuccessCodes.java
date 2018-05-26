package com.aether.boiler.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum SuccessCodes implements com.ekart.transport.core.enumInterfaces.SuccessCodes {

    CREATED("CREATED","Created"),
    SUCCESSFULLY_UPDATED("SUCCESSFULLY_UPDATED","Updated"),
    OK("OK","Ok");

    @Getter
    private String code;
    @Getter
    private String description;
}
