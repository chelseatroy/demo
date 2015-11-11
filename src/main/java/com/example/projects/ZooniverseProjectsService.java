package com.example.projects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ZooniverseProjectsService implements ProjectsService {
    @Autowired
    private RestTemplate restTemplate;

    public List<Project> getProjects() {
        ProjectsResponse response = restTemplate.getForObject(
                "https://panoptes-staging.zooniverse.org/api/projects",
                ProjectsResponse.class);
        return response.getProjects();
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
