package com.liudao.request;

import java.io.IOException;

public interface EasyRequest {
    String PLAIN = "text/plain; charset=utf-8";
    String FORM = "application/x-www-form-urlencoded";
    String JSON = "application/json; charset=utf-8";
    String XML = "application/xml; charset=utf-8";
    String SOAP12 = "application/xml+soap; charset=utf-8";

    EasyRequest setUrl(String url);
    String getUrl();
    EasyRequest addQueryParam(String paramKey, String paramValue);
    String getQueryParam(String paramKey);
    EasyRequest addHeader(String headerName, String headerValue);
    String getHeader(String headerName);
    EasyRequest addCookie(String cookName, String cookValue);
    EasyRequest setBody(String mimeType, String content);
    EasyRequest setMethod(String method);
    String getMethod();
    EasyResponse execute() throws IOException;

}
