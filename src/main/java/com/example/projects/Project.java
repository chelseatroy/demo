package com.example.projects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Project {
    private String description;

    @JsonProperty(value = "display_name")
    private String displayName;

    @JsonProperty(value = "classifications_count")
    private Integer classificationsCount;

    @JsonProperty(value = "tags")
    List<Category> categories;

    private String slug;
    private String webViewUrl;
    private String redirect;

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

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public String getWebViewUrl() {
        return webViewUrl;
    }

    public void setRedirect(String redirect) {
        this.redirect = redirect;
    }

    public String getRedirect() {
        return redirect;
    }

    static class Category {
        private String category;

        @JsonCreator
        public Category(String category) {
            this.category = category;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }
    }
}
