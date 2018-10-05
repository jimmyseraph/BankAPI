package com.liudao.step;

import com.google.gson.Gson;
import com.liudao.request.EasyRequest;
import com.liudao.request.EasyResponse;
import com.liudao.request.okhttp.OkHttpEasyRequest;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import static org.testng.Assert.*;

public class StepDefine {

    private EasyRequest request;
    private EasyResponse response;

    @When("^Create http request with url (.*?)$")
    public void create_http_request(String url){
        request = new OkHttpEasyRequest();
        request.setUrl(url);
    }

    @And("^Add query param (.*?), value is (.*?)$")
    public void add_query_param(String name, String value){
        request.addQueryParam(name, value);
    }

    @And("^Add header (.*?), value is (.*?)$")
    public void add_header(String name, String value){
        request.addHeader(name, value);
    }

    @And("^Add cookie (.*?), value is (.*?)$")
    public void add_cookie(String name, String value){
        request.addCookie(name, value);
    }

    @And("^Request method is ([a-zA-Z]{3,})$")
    public void set_method(String method){
        request.setMethod(method);
    }

    @And("^Set content type is (.*?), body is$")
    public void set_body(String type, String content) throws UnsupportedEncodingException {
        String mimeType = EasyRequest.PLAIN;
        switch (type) {
            case "json":
                mimeType = EasyRequest.JSON;
                break;
            case "xml":
                mimeType = EasyRequest.XML;
                break;
            case "soap":
                mimeType = EasyRequest.SOAP12;
                break;
            case "form":
                mimeType = EasyRequest.FORM;
                content = URLEncoder.encode(content, "utf-8");
                break;
        }
        request.setBody(mimeType, content);
    }

    @And("^Send the request$")
    public void send_request() throws IOException {
        response = request.execute();
        System.out.println("get the response -> Code: "+response.getCode());
        System.out.println("body: "+response.getBody());
    }

    @Then("^Assert the code is (.*?)$")
    public void assert_code(String code){
        assertEquals(response.getCode(), Integer.parseInt(code));
    }

    @Then("^Assert body is (.*?) with the value$")
    public void assert_body_object(String className, String bodyString) throws ClassNotFoundException {
        Class<?> clazz = Class.forName("com.liudao.entities."+className);
        Object actual = response.getBody(clazz);
        Object excepted = new Gson().fromJson(bodyString, clazz);
        assertEquals(actual, excepted);
    }
}
