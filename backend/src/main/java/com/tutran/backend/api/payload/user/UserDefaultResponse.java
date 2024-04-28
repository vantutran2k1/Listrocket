package com.tutran.backend.api.payload.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserDefaultResponse {

    @JsonProperty(value = "id")
    private long id;

    @JsonProperty(value = "username")
    private String username;

    @JsonProperty(value = "email")
    private String email;

}
