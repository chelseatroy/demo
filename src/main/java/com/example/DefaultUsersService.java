package com.example;

import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class DefaultUsersService implements UsersService {
    @Override
    public List<User> getUsers() {
        User user = new User();
        user.setName("Jared");

        return Collections.singletonList(user);
    }
}
