package com.tutran.backend.api.service;

import com.tutran.backend.api.payload.profile.ProfileCreateRequest;
import com.tutran.backend.api.payload.profile.ProfileDefaultResponse;

public interface ProfileService {

    ProfileDefaultResponse createProfile(long userId, ProfileCreateRequest request);

}
