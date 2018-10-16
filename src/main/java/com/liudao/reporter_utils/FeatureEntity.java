package com.liudao.reporter_utils;

public class FeatureEntity {
    private int line;
    private FeatureElement[] elements;
    private String name;
    private String description;
    private String id;
    private String keyword;
    private String uri;
    private String[] tags;

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public FeatureElement[] getElements() {
        return elements;
    }

    public void setElements(FeatureElement[] elements) {
        this.elements = elements;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }
}
