package com.tutran.backend.api.service.impl;

import com.tutran.backend.api.entity.User;
import com.tutran.backend.api.entity.UserAuthority;
import com.tutran.backend.api.repository.UserAuthorityRepository;
import com.tutran.backend.api.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AdminUserInitializer implements CommandLineRunner {

    private final UserRepository userRepository;

    private final UserAuthorityRepository userAuthorityRepository;

    private final PasswordEncoder passwordEncoder;

    @Value("${admin.username}")
    private String username;

    @Value("${admin.email}")
    private String email;

    @Value("${admin.password}")
    private String password;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        if (userRepository.existsByUsernameOrEmail(username, email)) {
            return;
        }

        var user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPasswordHash(passwordEncoder.encode(password));

        userRepository.save(user);

        var userRoleAuthority = new UserAuthority();
        userRoleAuthority.setUser(user);
        userRoleAuthority.setName(UserAuthority.AuthorityType.USER);

        userAuthorityRepository.save(userRoleAuthority);

        var adminRoleAuthority = new UserAuthority();
        adminRoleAuthority.setUser(user);
        adminRoleAuthority.setName(UserAuthority.AuthorityType.ADMIN);

        userAuthorityRepository.save(adminRoleAuthority);
    }

}
