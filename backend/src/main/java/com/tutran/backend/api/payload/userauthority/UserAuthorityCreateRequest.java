package com.tutran.backend.api.payload.userauthority;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tutran.backend.api.entity.UserAuthority;
import com.tutran.backend.api.validator.ValueOfEnum;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class UserAuthorityCreateRequest {

    @JsonProperty(value = "name")
    @NotEmpty(message = "must not be empty")
    @ValueOfEnum(enumClass = UserAuthority.AuthorityType.class, message = "must be any of authority type: ADMIN, USER")
    private String name;

}
