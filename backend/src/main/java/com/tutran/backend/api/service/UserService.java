package com.tutran.backend.api.service;

import com.tutran.backend.api.entity.User;
import com.tutran.backend.api.payload.user.UserCreateRequest;
import com.tutran.backend.api.payload.user.UserDefaultResponse;

public interface UserService {

    UserDefaultResponse createUser(UserCreateRequest request);

    boolean existsById(long id);

    User getByIdOrThrowException(long id);

}
