package com.liudao.entities;
/**
 * SuccessEntity to store the json object of the response body when request succeed
 * @author liudao
 * @version 1.0
 */
public class SuccessEntity {
    private String success;

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    @Override
    public boolean equals(Object obj) {
        return this.success.equals(((SuccessEntity)obj).getSuccess());
    }
}
