package com.tutran.backend.api.payload.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserCreateRequest {

    @JsonProperty(value = "username")
    @NotEmpty(message = "must not be empty")
    private String username;

    @JsonProperty(value = "email")
    @NotEmpty(message = "must not be empty")
    @Email
    private String email;

    @JsonProperty(value = "password")
    @NotEmpty(message = "must not be empty")
    @Size(min = 8, max = 32, message = "must be between 8 and 32 characters")
    private String password;

}
