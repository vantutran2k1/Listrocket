package com.tutran.backend.api.mapper;

import com.tutran.backend.api.entity.User;
import com.tutran.backend.api.payload.user.UserCreateRequest;
import com.tutran.backend.api.payload.user.UserDefaultResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    User userCreateRequestToUser(UserCreateRequest userCreateRequest);

    UserDefaultResponse userToUserDefaultResponse(User user);

}
