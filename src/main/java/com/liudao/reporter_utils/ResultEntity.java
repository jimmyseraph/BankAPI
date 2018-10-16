package com.liudao.reporter_utils;

public class ResultEntity {
    private long duration;
    private String status;
    private String error_message;

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getError_message() {
        return error_message;
    }

    public void setError_message(String error_message) {
        this.error_message = error_message;
    }

    @Override
    public String toString() {
        return "ResultEntity{" +
                "duration=" + duration +
                ", status='" + status + '\'' +
                ", error_message='" + error_message + '\'' +
                '}';
    }
}
