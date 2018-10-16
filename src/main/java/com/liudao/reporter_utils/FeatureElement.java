package com.liudao.reporter_utils;

public class FeatureElement {
    private int line;
    private String name;
    private String description;
    private String keyword;
    private String type;
    private StepEntity[] steps;

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
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

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public StepEntity[] getSteps() {
        return steps;
    }

    public void setSteps(StepEntity[] steps) {
        this.steps = steps;
    }
}
