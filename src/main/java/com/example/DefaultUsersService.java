package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class DefaultUsersService implements UsersService {
    @Autowired
    private UsersRepository usersRepository;

    @Override
    public List<User> getUsers() {
        return usersRepository.findAll();
    }
}
