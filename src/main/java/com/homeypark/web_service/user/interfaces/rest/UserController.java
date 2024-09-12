package com.homeypark.web_service.user.interfaces.rest;


import com.homeypark.web_service.user.application.internal.queryServices.UserQueryService;
import com.homeypark.web_service.user.domain.model.entities.User;
import com.homeypark.web_service.user.domain.model.queries.GetAllUsersQuery;
import com.homeypark.web_service.user.domain.model.queries.GetUserByIdQuery;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    private final UserQueryService userQueryService;

    public UserController(UserQueryService userQueryService) {
        this.userQueryService = userQueryService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {

        var getAllUsersQuery = new GetAllUsersQuery();
        var users = userQueryService.handle(getAllUsersQuery);

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
        var getUserByIdQuery = new GetUserByIdQuery(id);

        var user = userQueryService.handle(getUserByIdQuery);

        return user.map(u -> new ResponseEntity<>(u, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
