package com.rancho.demo.rest.low.elasticsearch;

import org.apache.http.HttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.nio.entity.NStringEntity;
import org.apache.http.util.EntityUtils;
import org.elasticsearch.client.Request;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestLowTest {

    @Resource
    private RestClient client;

    @Test
    public void add() {
        try {
            Request request = new Request("PUT", "/content/doc/20190909");
            String jsonString = "{\"id\":\"20190909\",\"name\":\"测试\",\"age\":22}";
            HttpEntity entity = new NStringEntity(jsonString, ContentType.APPLICATION_JSON);
            request.setEntity(entity);
            Response response = client.performRequest(request);
            String result = EntityUtils.toString(response.getEntity());
            System.out.println(result);
        } catch (Exception e) {

        }
    }

    @Test
    public void search() {
        try {
            Request request = new Request("GET", "/content/_search");
            String jsonString = "{\"query\":{\"match\":{\"name\":\"测试\"}}}";
            HttpEntity entity = new NStringEntity(jsonString, ContentType.APPLICATION_JSON);
            request.setEntity(entity);
            Response response = client.performRequest(request);
            String result = EntityUtils.toString(response.getEntity());
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void update() {
        try {
            Request request = new Request("PUT", "/content/doc/20190909");
            String jsonString = "{\"id\":\"20190909\",\"name\":\"测试-update\",\"age\":22}";
            HttpEntity entity = new NStringEntity(jsonString, ContentType.APPLICATION_JSON);
            request.setEntity(entity);
            Response response = client.performRequest(request);
            String result = EntityUtils.toString(response.getEntity());
            System.out.println(result);
        } catch (Exception e) {

        }
    }

    @Test
    public void get() {
        try {
            Request request = new Request("GET", "/content/doc/20190909");
            Response response = client.performRequest(request);
            String result = EntityUtils.toString(response.getEntity());
            System.out.println(result);
        } catch (Exception e) {

        }
    }

    @Test
    public void delete() {
        try {
            Request request = new Request("DELETE", "/content/doc/20190909");
            Response response = client.performRequest(request);
            String result = EntityUtils.toString(response.getEntity());
            System.out.println(result);
        } catch (Exception e) {

        }
    }
}
