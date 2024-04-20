package com.tutran.backend.api.repository;

import com.tutran.backend.api.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}