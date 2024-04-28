package com.tutran.backend.api.service.impl;

import com.tutran.backend.api.entity.User;
import com.tutran.backend.api.mapper.UserMapper;
import com.tutran.backend.api.payload.user.UserCreateRequest;
import com.tutran.backend.api.payload.user.UserDefaultResponse;
import com.tutran.backend.api.repository.UserRepository;
import com.tutran.backend.api.service.UserService;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public UserDefaultResponse createUser(UserCreateRequest request) {
        var user = userMapper.userCreateRequestToUser(request);
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new EntityExistsException("Email '" + user.getEmail() + "' already exists");
        }
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new EntityExistsException("Username '" + user.getUsername() + "' already exists");
        }

        user.setPasswordHash(passwordEncoder.encode(request.getPassword()));

        var savedUser = userRepository.save(user);
        return userMapper.userToUserDefaultResponse(savedUser);
    }

    @Override
    public boolean existsById(long id) {
        return userRepository.existsById(id);
    }

    @Override
    public User getByIdOrThrowException(long id) {
        var userOptional = userRepository.findById(id);
        if (userOptional.isEmpty()) {
            throw new EntityNotFoundException("User with id '" + id + "' not found");
        }

        return userOptional.get();
    }

}
