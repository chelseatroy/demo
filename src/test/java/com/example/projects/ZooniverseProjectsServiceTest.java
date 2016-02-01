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
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.client.MockRestServiceServer.createServer;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.*;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class ZooniverseProjectsServiceTest {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ZooniverseProjectsService subject;

    private MockRestServiceServer mockZooniverseServer;

    @Before
    public void setUp() throws Exception {
        mockZooniverseServer = createServer(restTemplate);
    }

    @Test
    public void getProjects_makesApiCall_andDeserializesResponse() {
        mockZooniverseServer.expect(method(HttpMethod.GET))
                .andExpect(requestTo("https://panoptes-staging.zooniverse.org/api/projects"))
                .andExpect(header("Accept", "application/vnd.api+json; version=1"))
                .andRespond(withSuccess("{\n" +
                        "  \"projects\": [\n" +
                        "    {\n" +
                        "      \"id\": \"195\",\n" +
                        "      \"display_name\": \"oldweather\",\n" +
                        "      \"classifications_count\": 390,\n" +
                        "      \"subjects_count\": 24,\n" +
                        "      \"created_at\": \"2015-03-31T13:14:45.887Z\",\n" +
                        "      \"updated_at\": \"2015-09-30T19:10:45.654Z\",\n" +
                        "      \"available_languages\": [\n" +
                        "        \"en\"\n" +
                        "      ],\n" +
                        "      \"title\": \"oldweather\",\n" +
                        "      \"description\": \"Old Weather aims to recover worldwide weather observations to help improve climate model predictions.\",\n" +
                        "      \"introduction\": \"Help scientists recover Arctic and worldwide weather observations made by United States ships since the mid-19th century by transcribing ships' logs. These transcriptions will contribute to climate model projections and will improve our knowledge of past environmental conditions. Historians will use your work to track past ship movements and tell the stories of the people on board.\",\n" +
                        "      \"private\": false,\n" +
                        "      \"retired_subjects_count\": 0,\n" +
                        "      \"configuration\": null,\n" +
                        "      \"live\": false,\n" +
                        "      \"urls\": [],\n" +
                        "      \"migrated\": false,\n" +
                        "      \"classifiers_count\": 6,\n" +
                        "      \"slug\": \"perryroper/oldweather\",\n" +
                        "      \"redirect\": \"\",\n" +
                        "      \"beta_requested\": false,\n" +
                        "      \"beta_approved\": false,\n" +
                        "      \"launch_requested\": false,\n" +
                        "      \"launch_approved\": true,\n" +
                        "      \"href\": \"/projects/195\",\n" +
                        "      \"workflow_description\": \"\",\n" +
                        "      \"primary_language\": \"en\",\n" +
                        "      \"tags\":[\"astronomy\"\n" +
                        "      ],\n" +
                        "      \"experimental_tools\": [],\n" +
                        "      \"links\": {\n" +
                        "        \"workflows\": [\n" +
                        "          \"611\"\n" +
                        "        ],\n" +
                        "        \"subject_sets\": [\n" +
                        "          \"2369\",\n" +
                        "          \"2370\",\n" +
                        "          \"2371\"\n" +
                        "        ],\n" +
                        "        \"owner\": {\n" +
                        "          \"id\": \"1246309\",\n" +
                        "          \"type\": \"users\",\n" +
                        "          \"href\": \"/users/1246309\"\n" +
                        "        },\n" +
                        "        \"project_contents\": [\n" +
                        "          \"195\"\n" +
                        "        ],\n" +
                        "        \"project_roles\": [\n" +
                        "          \"1488\",\n" +
                        "          \"1487\",\n" +
                        "          \"681\"\n" +
                        "        ],\n" +
                        "        \"pages\": [\n" +
                        "          \"780\",\n" +
                        "          \"779\",\n" +
                        "          \"778\",\n" +
                        "          \"777\"\n" +
                        "        ],\n" +
                        "        \"avatar\": {\n" +
                        "          \"href\": \"/projects/195/avatar\",\n" +
                        "          \"type\": \"avatars\"\n" +
                        "        },\n" +
                        "        \"background\": {\n" +
                        "          \"href\": \"/projects/195/background\",\n" +
                        "          \"type\": \"backgrounds\"\n" +
                        "        },\n" +
                        "        \"attached_images\": {\n" +
                        "          \"href\": \"/projects/195/attached_images\",\n" +
                        "          \"type\": \"attached_images\"\n" +
                        "        },\n" +
                        "        \"classifications_export\": {\n" +
                        "          \"href\": \"/projects/195/classifications_export\",\n" +
                        "          \"type\": \"classifications_exports\"\n" +
                        "        },\n" +
                        "        \"subjects_export\": {\n" +
                        "          \"href\": \"/projects/195/subjects_export\",\n" +
                        "          \"type\": \"subjects_exports\"\n" +
                        "        },\n" +
                        "        \"aggregations_export\": {\n" +
                        "          \"href\": \"/projects/195/aggregations_export\",\n" +
                        "          \"type\": \"aggregations_exports\"\n" +
                        "        }\n" +
                        "      }\n" +
                        "    }\n" +
                        "    ]\n" +
                        "}", MediaType.APPLICATION_JSON));

        List<Project> projects = subject.getProjects();

        assertThat(projects, hasSize(1));

        Project project = projects.get(0);
        assertThat(project.getDisplayName(), is("oldweather"));
        assertThat(project.getDescription(), is("Old Weather aims to recover worldwide weather observations to help improve climate model predictions."));
        assertThat(project.getClassificationsCount(), is(390));

        assertThat(project.getCategories().size(), is(1));
        assertThat(project.getCategories().get(0).getCategory(), is("astronomy"));
        assertThat(project.getWebViewUrl(), is("https://www.zooniverse.org/projects/perryroper/oldweather"));
    }

    @Test
    public void translateProjects_setsWebViewUrl() {
        Project projectWithSlug = new Project();
        projectWithSlug.setSlug("mysciencelab/awesomeproject");

        Project projectWithSpecialUrl = new Project();
        projectWithSpecialUrl.setRedirect("awesomeproject.org");

        projectWithSlug = subject.translateProject(projectWithSlug);
        projectWithSpecialUrl = subject.translateProject(projectWithSpecialUrl);

        assertThat(projectWithSlug.getWebViewUrl(), is("https://www.zooniverse.org/projects/mysciencelab/awesomeproject"));
        assertThat(projectWithSpecialUrl.getWebViewUrl(), is("awesomeproject.org"));
    }
}