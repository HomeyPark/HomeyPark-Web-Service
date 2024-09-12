package com.homeypark.web_service.user.domain.services;

import com.homeypark.web_service.user.domain.model.commands.CreateUserCommand;
import com.homeypark.web_service.user.domain.model.entities.User;

import java.util.Optional;

public interface IUserCommandService {
    Optional<User> handle(CreateUserCommand command);
}
