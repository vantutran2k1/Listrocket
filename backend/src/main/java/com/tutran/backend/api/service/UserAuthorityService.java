package com.tutran.backend.api.service;

import com.tutran.backend.api.payload.userauthority.UserAuthorityCreateRequest;
import com.tutran.backend.api.payload.userauthority.UserAuthorityDefaultResponse;

public interface UserAuthorityService {

    UserAuthorityDefaultResponse createUserAuthority(long userId, UserAuthorityCreateRequest request);

    UserAuthorityDefaultResponse createDefaultUserAuthority(long userId);

}
