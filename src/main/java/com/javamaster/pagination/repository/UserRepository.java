package com.javamaster.pagination.repository;

import com.javamaster.pagination.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
