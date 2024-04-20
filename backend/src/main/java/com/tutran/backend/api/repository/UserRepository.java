package com.tutran.backend.api.repository;

import com.tutran.backend.api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}