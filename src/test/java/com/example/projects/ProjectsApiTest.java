package com.example.projects;

import com.example.Application;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class ProjectsApiTest {
    @Autowired
    private WebApplicationContext webAppContext;

    @Autowired
    private RestTemplate restTemplate;

    private MockRestServiceServer mockZooniverseServer;

    @Before
    public void setUp() throws Exception {
        mockZooniverseServer = MockRestServiceServer.createServer(restTemplate);
    }

    @Test
    public void projectsEndpoint_returnsListOfProjects() throws Exception {
        mockZooniverseServer.expect(method(HttpMethod.GET))
                .andExpect(requestTo("https://panoptes-staging.zooniverse.org/api/projects"))
                .andRespond(withSuccess("{\n" +
                        "  \"projects\": [{}]\n" +
                        "}", MediaType.APPLICATION_JSON));

        ZooniverseProjectsService.ProjectsResponse projectsResponse = restTemplate.getForObject(
                "https://panoptes-staging.zooniverse.org/api/projects",
                ZooniverseProjectsService.ProjectsResponse.class
        );
        mockZooniverseServer.verify();

        List<Project> projects = projectsResponse.getProjects();
        assertThat(projects, hasSize(1));
    }
}
