package com.tutran.backend.api.payload.userauthority;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tutran.backend.api.entity.UserAuthority;
import lombok.Data;

@Data
public class UserAuthorityDefaultResponse {

    @JsonProperty(value = "name")
    private UserAuthority.AuthorityType name;

}
