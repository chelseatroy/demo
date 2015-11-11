package com.example;

import com.example.users.User;
import com.example.users.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("!test")
public class DatabaseBootstrapper implements CommandLineRunner {
    @Autowired
    UsersRepository usersRepository;

    @Override
    public void run(String... args) throws Exception {
        User user = new User();
        user.setName("mom");
        usersRepository.save(user);
    }
}