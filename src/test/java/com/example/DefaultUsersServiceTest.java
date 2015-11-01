package com.example;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class DefaultUsersServiceTest {
    @Mock
    private UsersRepository usersRepository;

    @InjectMocks
    private DefaultUsersService subject;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Test
    public void getUsers_returnsAUser() {
        User user = new User();
        user.setName("Blah");

        when(usersRepository.findAll()).thenReturn(Collections.singletonList(user));

        List<User> users = subject.getUsers();

        assertThat(users, is(Collections.singletonList(user)));
    }
}