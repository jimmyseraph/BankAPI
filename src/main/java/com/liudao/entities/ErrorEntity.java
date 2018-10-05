package com.liudao.entities;

/**
 * ErrorEntity to store the json object of the response body when request failed
 * @author liudao
 * @version 1.0
 */
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
