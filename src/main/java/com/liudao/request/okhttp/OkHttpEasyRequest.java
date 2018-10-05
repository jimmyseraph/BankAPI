package com.liudao.request.okhttp;

import com.liudao.request.EasyRequest;
import com.liudao.request.EasyResponse;
import okhttp3.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class OkHttpEasyRequest implements EasyRequest {

    private final OkHttpClient client = new OkHttpClient.Builder()
            .followRedirects(false)
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .build();
    private String url;
    private Map<String,String> queryParams;
    private Map<String,String> headers;
    private Map<String,String> cookies;
    private String method;
    private RequestBody requestBody;

    public OkHttpEasyRequest(){
        queryParams = new HashMap<>();
        headers = new HashMap<>();
        cookies = new HashMap<>();
        this.method = "GET";
        requestBody = null;
    }

    @Override
    public EasyRequest setUrl(String url) {
        this.url = url;
        return this;
    }

    @Override
    public String getUrl() {
        return this.url;
    }

    @Override
    public EasyRequest addQueryParam(String paramKey, String paramValue) {
        queryParams.put(paramKey, paramValue);
        return this;
    }

    @Override
    public String getQueryParam(String paramKey) {
        return queryParams.get(paramKey);
    }

    @Override
    public EasyRequest addHeader(String headerName, String headerValue) {
        headers.put(headerName, headerValue);
        return this;
    }

    @Override
    public String getHeader(String headerName) {
        return headers.get(headerName);
    }

    @Override
    public EasyRequest addCookie(String cookName, String cookValue) {
        cookies.put(cookName, cookValue);
        return this;
    }

    @Override
    public EasyRequest setBody(String mimeType, String content) {
        MediaType mediaType = MediaType.parse(mimeType);
        this.requestBody = RequestBody.create(mediaType, content);
        return this;
    }

    @Override
    public EasyRequest setMethod(String method) {
        this.method = method.toUpperCase();
        return this;
    }

    @Override
    public String getMethod() {
        return this.method;
    }

    @Override
    public EasyResponse execute() throws IOException {
        if(this.url == null || this.url.equals("")){
            throw new RuntimeException("url could not be null...");
        }
        if(this.method == null || this.method.equals("")){
            throw new RuntimeException("method could not be null...");
        }
        Request.Builder builder = new Request.Builder();
        // if queryParams has values, they will concat to the tail of url
        if(queryParams.size() != 0){
            StringBuffer queryString = new StringBuffer();
            queryParams.forEach((k, v)->
                queryString.append("&")
                    .append(k)
                    .append("=")
                    .append(v)
            );
            if(!this.url.contains("?")) {
                queryString.replace(0, 1, "?");
            }
            this.url = this.url + queryString;
        }
        builder.url(this.url);
        // if headers has values, they will add to request;
        if(headers.size() != 0){
            headers.forEach((k, v) -> builder.addHeader(k, v));
        }
        // if cookies has values, they will add to request;
        if(cookies.size() != 0){
            StringBuffer cookieString = new StringBuffer();
            cookies.forEach((k, v) -> cookieString
                    .append(k).append("=").append(v).append(";"));
            builder.addHeader("Cookie",cookieString.toString());
        }
        builder.method(this.method, this.requestBody);
        Request request = builder.build();
        Response response = client.newCall(request).execute();
        return new OkHttpEasyResponse(this.url, response);
    }

}
