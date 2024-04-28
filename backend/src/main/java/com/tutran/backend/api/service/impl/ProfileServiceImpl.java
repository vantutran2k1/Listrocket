package com.tutran.backend.api.service.impl;

import com.tutran.backend.api.mapper.ProfileMapper;
import com.tutran.backend.api.payload.profile.ProfileCreateRequest;
import com.tutran.backend.api.payload.profile.ProfileDefaultResponse;
import com.tutran.backend.api.repository.ProfileRepository;
import com.tutran.backend.api.service.ProfileService;
import com.tutran.backend.api.service.UserService;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository profileRepository;

    private final UserService userService;

    private final ProfileMapper profileMapper;

    @Override
    @Transactional
    public ProfileDefaultResponse createProfile(long userId, ProfileCreateRequest request) {
        if (!userService.existsById(userId)) {
            throw new EntityNotFoundException("User with id '" + userId + "' not found");
        }
        if (profileRepository.existsByUserId(userId)) {
            throw new EntityExistsException("Profile for user with id '" + userId + "' already exists");
        }

        var profile = profileMapper.profileCreateRequestToProfile(request);
        profile.setUser(userService.getByIdOrThrowException(userId));

        var savedProfile = profileRepository.save(profile);
        return profileMapper.profileToProfileDefaultResponse(savedProfile);
    }

}
