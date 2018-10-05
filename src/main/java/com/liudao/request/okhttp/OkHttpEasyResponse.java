package com.liudao.request.okhttp;

import com.google.gson.Gson;
import com.liudao.request.EasyResponse;
import okhttp3.Cookie;
import okhttp3.HttpUrl;
import okhttp3.Response;

import java.io.IOException;
import java.util.List;

public class OkHttpEasyResponse implements EasyResponse {

    private Response response;
    private String bodyString;
    private String url;

    public  OkHttpEasyResponse(String url,Response response) throws IOException {
        this.response = response;
        this.bodyString = response.body().string();
        this.url = url;
    }

    @Override
    public String getBody() {
        return this.bodyString;
    }

    @Override
    public <T> T getBody(Class<T> bodyType) {
        Gson gson = new Gson();
        return gson.fromJson(this.bodyString, bodyType);
    }

    @Override
    public String getHeader(String headerName) {
        return response.header(headerName);
    }

    @Override
    public String getCookie(String cookName) {
        List<String> cookies = response.headers("Set-Cookie");
        for(String cookie : cookies){
            HttpUrl httpUrl = HttpUrl.parse(this.url);
            Cookie c = Cookie.parse(httpUrl,cookie);
            if(c.name().equals(cookName)){
                return c.value();
            }
        }
        return null;
    }

    @Override
    public int getCode() {
        return response.code();
    }
}
