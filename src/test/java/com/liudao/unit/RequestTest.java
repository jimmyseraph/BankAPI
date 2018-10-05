package com.liudao.unit;

import com.liudao.request.EasyRequest;
import com.liudao.request.EasyResponse;
import com.liudao.request.okhttp.OkHttpEasyRequest;
import org.testng.annotations.Test;

import java.io.IOException;

public class RequestTest {
    @Test
    public void testRequest(){
        EasyRequest request = new OkHttpEasyRequest()
                .setUrl("https://www.taobao.com")
                .addHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36")
                .setMethod("GET");
        try {
            EasyResponse response = request.execute();
            System.out.println(response.getCookie("thw"));
            System.out.println(response.getHeader("EagleId"));
            System.out.println(response.getBody());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
