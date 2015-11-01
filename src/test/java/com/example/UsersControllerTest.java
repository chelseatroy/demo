package com.example;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;

import static com.jayway.jsonassert.impl.matcher.IsCollectionWithSize.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class UsersControllerTest {
    private MockMvc mockMvc;

    @Mock
    private UsersService usersService;

    @InjectMocks
    private UsersController subject;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Test
    public void usersEndpoint_asksServiceForUsers() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(subject).build();

        when(usersService.getUsers())
                .thenReturn(Collections.singletonList(new User()));

        mockMvc.perform(get("/users"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.users", hasSize(1)));
    }
}