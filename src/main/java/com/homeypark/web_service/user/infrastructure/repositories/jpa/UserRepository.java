package com.homeypark.web_service.user.infrastructure.repositories.jpa;

import com.homeypark.web_service.user.domain.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {}
