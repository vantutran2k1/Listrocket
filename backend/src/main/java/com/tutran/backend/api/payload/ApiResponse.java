package com.tutran.backend.api.payload;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;

@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {

    @JsonProperty(value = "data")
    @NonNull
    private T data;

    @JsonProperty(value = "meta")
    private Object meta;

    @JsonProperty(value = "status_code")
    private String statusCode;

}
