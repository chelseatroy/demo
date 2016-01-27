package com.example.projects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ZooniverseProjectsService implements ProjectsService {
    @Autowired
    private RestTemplate restTemplate;

    public List<Project> getProjects() {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.add("Accept", "application/vnd.api+json; version=1");

        HttpEntity<?> httpEntity = new HttpEntity<>(requestHeaders);

        HttpEntity<ProjectsResponse> response = restTemplate.exchange(
                "https://panoptes-staging.zooniverse.org/api/projects",
                HttpMethod.GET,
                httpEntity,
                ProjectsResponse.class);
        List<Project> projects = response.getBody().getProjects();

        projects.stream()
                .filter(project -> project.getSlug() != null)
                .map(project -> translateProject(project))
                .collect(Collectors.toList());

        return projects;
    }

    private Project translateProject(Project project) {
        project.setWebViewUrl("https://www.zooniverse.org/projects/" + project.getSlug());
        return project;
    }

    public static class ProjectsResponse {
        private List<Project> projects;

        public List<Project> getProjects() {
            return projects;
        }

        public void setProjects(List<Project> projects) {
            this.projects = projects;
        }
    }
}
