package com.tutran.backend.api.mapper;

import com.tutran.backend.api.entity.Profile;
import com.tutran.backend.api.entity.User;
import com.tutran.backend.api.payload.profile.ProfileCreateRequest;
import com.tutran.backend.api.payload.profile.ProfileDefaultResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProfileMapper {

    Profile profileCreateRequestToProfile(ProfileCreateRequest profileCreateRequest);

    @Mapping(source = "user", target = "userId", qualifiedByName = "userToUserId")
    ProfileDefaultResponse profileToProfileDefaultResponse(Profile profile);

    @Named(value = "userToUserId")
    static Long userToUserId(User user) {
        return user.getId();
    }

}
