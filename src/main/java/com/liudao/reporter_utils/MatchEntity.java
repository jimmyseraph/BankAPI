package com.liudao.reporter_utils;

import java.util.Arrays;

public class MatchEntity {
    private String location;
    private ArgumentEntity[] arguments;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public ArgumentEntity[] getArguments() {
        return arguments;
    }

    public void setArguments(ArgumentEntity[] arguments) {
        this.arguments = arguments;
    }

    @Override
    public String toString() {
        return "MatchEntity{" +
                "location='" + location + '\'' +
                ", arguments=" + Arrays.toString(arguments) +
                '}';
    }
}
