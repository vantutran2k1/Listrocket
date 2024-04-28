package com.tutran.backend.api.payload;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;

@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ApiError {

    @JsonProperty(value = "messages")
    @NonNull
    private Object messages;

    @JsonProperty(value = "status")
    private HttpStatus status;

}
