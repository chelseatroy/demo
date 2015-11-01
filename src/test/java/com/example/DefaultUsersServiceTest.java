package com.example;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class DefaultUsersServiceTest {
    @InjectMocks
    private DefaultUsersService subject;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Test
    public void getUsers_returnsAUser() {
        User user = new User();
        user.setName("Jared");

        List<User> users = subject.getUsers();

        assertThat(users, is(Collections.singletonList(user)));
    }
}