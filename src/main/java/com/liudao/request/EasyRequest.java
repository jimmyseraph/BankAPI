package com.liudao.request;

import java.io.IOException;

/**
 * EasyRequest is the core of this framework. It define the common methods that should be implemented in a request.
 * @author liudao
 * @version 1.0
 */
public interface EasyRequest {
    /**
     * mime type of plain
     */
    String PLAIN = "text/plain; charset=utf-8";
    /**
     * mime type of form-data
     */
    String FORM = "application/x-www-form-urlencoded";
    /**
     * mime type of json
     */
    String JSON = "application/json; charset=utf-8";
    /**
     * mime type of xml
     */
    String XML = "application/xml; charset=utf-8";
    /**
     * mime type of soap v1.2
     */
    String SOAP12 = "application/xml+soap; charset=utf-8";

    /**
     * Set a proper url to the request
     * @param url the url to request, must be "http"/"https"
     * @return this request instance
     */
    EasyRequest setUrl(String url);

    /**
     * Get the url of this request
     * @return the url of this request
     */
    String getUrl();

    /**
     * Add key=value to the tail of the url
     * @param paramKey key
     * @param paramValue value
     * @return this request instance
     */
    EasyRequest addQueryParam(String paramKey, String paramValue);

    /**
     * Get the parameter value from url
     * @param paramKey the key of the parameter
     * @return the value of the parameter
     */
    String getQueryParam(String paramKey);

    /**
     * Add a header to the request
     * @param headerName the name of the header
     * @param headerValue the value of the header
     * @return this request instance
     */
    EasyRequest addHeader(String headerName, String headerValue);

    /**
     * Get the value of the specify header
     * @param headerName the name of the header
     * @return the value of the header
     */
    String getHeader(String headerName);

    /**
     * Add a cookie to the request
     * @param cookName the name of the cookie
     * @param cookValue the value of the cookie
     * @return this request instance
     */
    EasyRequest addCookie(String cookName, String cookValue);

    /**
     * Set the body content of the request
     * @param mimeType specify the content type of the body
     * @param content the content of body
     * @return this request instance
     */
    EasyRequest setBody(String mimeType, String content);

    /**
     * Set the method of the request, default is GET
     * @param method the method of the request
     * @return this request instance
     */
    EasyRequest setMethod(String method);

    /**
     * Get the method of this request
     * @return the method
     */
    String getMethod();

    /**
     * Execute this request
     * @return the EasyResponse Object
     * @throws IOException some exception during connection
     */
    EasyResponse execute() throws IOException;

}
