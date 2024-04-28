package com.tutran.backend.api.payload.profile;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class ProfileCreateRequest {

    @JsonProperty(value = "first_name")
    @NotEmpty(message = "must not be empty")
    private String firstName;

    @JsonProperty(value = "last_name")
    @NotEmpty(message = "must not be empty")
    private String lastName;

    @JsonProperty(value = "date_of_birth")
    @DateTimeFormat(pattern = "yyyy/mm/dd")
    private LocalDate dateOfBirth;

}
