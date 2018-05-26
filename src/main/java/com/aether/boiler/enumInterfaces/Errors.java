package com.aether.boiler.enumInterfaces;

import org.springframework.http.HttpStatus;

public interface Errors {

    HttpStatus getStatus();

    String getCode();

    String getDescription();

    int getInternalErrorCode();

}
