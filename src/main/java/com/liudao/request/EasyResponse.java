package com.liudao.request;

/**
 * EasyResponse is the core of this framework. It define the common methods that should be implemented in a response.
 * @author liudao
 * @version 1.0
 */
public interface EasyResponse {
    /**
     * Get the body of the response
     * @return the body content as a string
     */
    String getBody();

    /**
     * Get the body content of the response as the specified type
     * @param bodyType the type you want to return
     * @return he body content as the specified type
     */
    <T> T getBody(Class<T> bodyType);

    /**
     * Get the value of the header
     * @param headerName the name of the header
     * @return the value of the header
     */
    String getHeader(String headerName);

    /**
     * Get the value of the cookie
     * @param cookName the name of the cookie
     * @return the value of the cookie
     */
    String getCookie(String cookName);

    /**
     * Get the response code
     * @return the response code
     */
    int getCode();
}
