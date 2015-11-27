package com.example.projects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

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
        return response.getBody().getProjects();
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
