package com.homeypark.web_service.user.interfaces.rest;


import com.homeypark.web_service.user.application.internal.commandServices.UserCommandService;
import com.homeypark.web_service.user.application.internal.queryServices.UserQueryService;
import com.homeypark.web_service.user.domain.model.commands.CreateUserCommand;
import com.homeypark.web_service.user.domain.model.entities.User;
import com.homeypark.web_service.user.domain.model.queries.GetAllUsersQuery;
import com.homeypark.web_service.user.domain.model.queries.GetUserByIdQuery;
import com.homeypark.web_service.user.interfaces.rest.resources.CreateUserResource;
import com.homeypark.web_service.user.interfaces.rest.resources.UserResource;
import com.homeypark.web_service.user.interfaces.rest.transformers.CreateUserCommandFromResourceAssembler;
import com.homeypark.web_service.user.interfaces.rest.transformers.UserResourceFromEntityAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    private final UserQueryService userQueryService;
    private final UserCommandService userCommandService;

    public UserController(UserQueryService userQueryService, UserCommandService userCommandService) {
        this.userQueryService = userQueryService;
        this.userCommandService = userCommandService;
    }

    @GetMapping
    public ResponseEntity<List<UserResource>> getAllUsers() {

        var getAllUsersQuery = new GetAllUsersQuery();
        var users = userQueryService.handle(getAllUsersQuery);

        var usersResource = users.stream().map(UserResourceFromEntityAssembler::toResourceFromEntity).toList();

        return new ResponseEntity<>(usersResource, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResource> getUserById(@PathVariable("id") Long id) {
        var getUserByIdQuery = new GetUserByIdQuery(id);

        var user = userQueryService.handle(getUserByIdQuery);

        return user.map(u -> new ResponseEntity<>(UserResourceFromEntityAssembler.toResourceFromEntity(u), HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<UserResource> createUser(@RequestBody CreateUserResource createUserResource) {
        var createUserCommand = CreateUserCommandFromResourceAssembler.toCommandFromResource(createUserResource);

        var user = userCommandService.handle(createUserCommand);


        return user.map(u -> new ResponseEntity<>(UserResourceFromEntityAssembler.toResourceFromEntity(u), HttpStatus.CREATED)).orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }
}
