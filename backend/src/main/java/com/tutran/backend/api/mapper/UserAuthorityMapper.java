package com.tutran.backend.api.mapper;

import com.tutran.backend.api.entity.UserAuthority;
import com.tutran.backend.api.payload.userauthority.UserAuthorityCreateRequest;
import com.tutran.backend.api.payload.userauthority.UserAuthorityDefaultResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserAuthorityMapper {

    UserAuthority userAuthorityCreateRequestToUserAuthority(UserAuthorityCreateRequest request);

    UserAuthorityDefaultResponse userToUserAuthorityDefaultResponse(UserAuthority userAuthority);

}
