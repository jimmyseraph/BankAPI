package com.liudao.entities;

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
