package com.tutran.backend.api.service;

import com.tutran.backend.api.payload.user.UserCreateRequest;
import com.tutran.backend.api.payload.user.UserDefaultResponse;

public interface UserService {

    public UserDefaultResponse createUser(UserCreateRequest request);

}
