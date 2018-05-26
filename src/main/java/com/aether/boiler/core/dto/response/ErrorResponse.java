package com.aether.boiler.core.dto.response;

import com.aether.boiler.enumInterfaces.Errors;
import com.aether.boiler.exception.ServiceException;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * Created by keshav.gupta on 13/05/18.
 */
@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorResponse {

    private int errorStatusCode;
    private int errorInternalStatusCode;
    private String errorReasonCode;
    private String errorDescription;
    private Map<String, String> additionalData;


    public ErrorResponse(ServiceException se) {
        this.errorStatusCode = se.getErrorStatusCode();
        this.errorReasonCode = se.getErrorReasonCode();
        this.errorDescription = se.getErrorDescription();
        this.errorInternalStatusCode = se.getErrorInternalStatusCode();
        if (se.getAdditionalData() != null)
            this.additionalData = se.getAdditionalData();
    }

    public ErrorResponse(Errors errors) {
        this.errorStatusCode = errors.getStatus().value();
        this.errorReasonCode = errors.getCode();
        this.errorDescription = errors.getDescription();
        this.errorInternalStatusCode = errors.getInternalErrorCode();
    }
}

