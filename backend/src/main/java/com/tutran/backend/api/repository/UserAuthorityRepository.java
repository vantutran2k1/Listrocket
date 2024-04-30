package com.tutran.backend.api.repository;

import com.tutran.backend.api.entity.UserAuthority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserAuthorityRepository extends JpaRepository<UserAuthority, Long> {

    @Query("select (count(u) > 0) from UserAuthority u where u.user.id = :userId and u.name = concat('ROLE_', :name)")
    boolean existsByUserIdAndName(@Param("userId") long userId, @Param("name") String name);

}