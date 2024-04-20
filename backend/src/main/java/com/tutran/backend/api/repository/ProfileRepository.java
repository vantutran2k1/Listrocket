package com.tutran.backend.api.repository;

import com.tutran.backend.api.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
}