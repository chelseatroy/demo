package com.example.projects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Project {
    private String description;

    @JsonProperty(value = "display_name")
    private String displayName;

    @JsonProperty(value = "classifications_count")
    private Integer classificationsCount;


    private String slug;
    private String webViewUrl;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Integer getClassificationsCount() {
        return classificationsCount;
    }

    public void setClassificationsCount(Integer classificationsCount) {
        this.classificationsCount = classificationsCount;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public void setWebViewUrl(String webViewUrl) {
        this.webViewUrl = webViewUrl;
    }

    public String getWebViewUrl() {
        return webViewUrl;
    }
}
