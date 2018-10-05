package com.liudao.request;

public interface EasyResponse {
    String getBody();
    <T> T getBody(Class<T> bodyType);
    String getHeader(String headerName);
    String getCookie(String cookName);
    int getCode();
}
