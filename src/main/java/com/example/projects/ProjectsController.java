package com.example.projects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProjectsController {
    @Autowired
    ZooniverseProjectsService zooniverseProjectsService;

    @RequestMapping("/projects")
    public ProjectsResponse index() {
        return new ProjectsResponse(zooniverseProjectsService.getProjects());
    }

    private class ProjectsResponse {
        private List<Project> projects;

        public ProjectsResponse(List<Project> projects) {
            this.projects = projects;
        }

        public List<Project> getProjects() {
            return projects;
        }

        public void setProjects(List<Project> projects) {
            this.projects = projects;
        }
    }
}
