package com.example.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsersController {
    @Autowired
    private UsersService usersService;

    @RequestMapping("/users")
    public UsersResponse index() {
        return new UsersResponse(usersService.getUsers());
    }

    private class UsersResponse {
        private final List<User> users;

        public UsersResponse(List<User> users) {
            this.users = users;
        }

        public List<User> getUsers() {
            return users;
        }
    }
}
