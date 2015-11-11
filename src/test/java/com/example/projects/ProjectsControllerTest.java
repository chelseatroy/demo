package com.example.projects;

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
import static org.mockito.Mockito.stub;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ProjectsControllerTest {
    private MockMvc mockMvc;

    @InjectMocks
    ProjectsController subject;

    @Mock
    private ZooniverseProjectsService mockProjectsService;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Test
    public void projectsEndpoint_asksServiceForProjects() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(subject).build();

        stub(mockProjectsService.getProjects()).toReturn(Collections.singletonList(new Project()));

        mockMvc.perform(get("/projects"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.projects", hasSize(1)));

    }
}
