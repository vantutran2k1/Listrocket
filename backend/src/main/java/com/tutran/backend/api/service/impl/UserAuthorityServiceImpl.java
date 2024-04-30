package com.tutran.backend.api.service.impl;

import com.tutran.backend.api.entity.UserAuthority;
import com.tutran.backend.api.mapper.UserAuthorityMapper;
import com.tutran.backend.api.payload.userauthority.UserAuthorityCreateRequest;
import com.tutran.backend.api.payload.userauthority.UserAuthorityDefaultResponse;
import com.tutran.backend.api.repository.UserAuthorityRepository;
import com.tutran.backend.api.service.UserAuthorityService;
import com.tutran.backend.api.service.UserService;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Log4j2
public class UserAuthorityServiceImpl implements UserAuthorityService {

    private final UserAuthorityRepository userAuthorityRepository;

    private final UserService userService;

    private final UserAuthorityMapper userAuthorityMapper;

    @Override
    @Transactional
    public UserAuthorityDefaultResponse createUserAuthority(long userId, UserAuthorityCreateRequest request) {
        return createUserAuthorityInternal(userId, request);
    }

    @Override
    @Transactional
    public UserAuthorityDefaultResponse createDefaultUserAuthority(long userId) {
        var request = new UserAuthorityCreateRequest();
        request.setName(UserAuthority.AuthorityType.USER.name());

        return createUserAuthorityInternal(userId, request);
    }

    private UserAuthorityDefaultResponse createUserAuthorityInternal(long userId, UserAuthorityCreateRequest request) {
        if (!userService.existsById(userId)) {
            throw new EntityNotFoundException("User with id '" + userId + "' not found");
        }

        var userAuthority = userAuthorityMapper.userAuthorityCreateRequestToUserAuthority(request);
        var authorityName = userAuthority.getName();
        if (userAuthorityRepository.existsByUserIdAndName(userId, authorityName.name())) {
            throw new EntityExistsException(
                    "Existing role '" + authorityName + "' for user with id '" + userId + "'"
            );
        }

        userAuthority.setUser(userService.getByIdOrThrowException(userId));

        var savedUserAuthority = userAuthorityRepository.save(userAuthority);
        return userAuthorityMapper.userToUserAuthorityDefaultResponse(savedUserAuthority);
    }

}
