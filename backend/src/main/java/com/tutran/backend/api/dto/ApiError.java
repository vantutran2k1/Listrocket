package com.tutran.backend.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ApiError {

    @JsonProperty(value = "messages")
    private Object messages;
    
    @JsonProperty(value = "status_code")
    private String statusCode;

}
