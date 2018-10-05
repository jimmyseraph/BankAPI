package com.liudao.entities;

public class ErrorEntity {
    private String error;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public boolean equals(Object obj) {
        return this.error.equals(((ErrorEntity)obj).getError());
    }
}
