package com.rancho.demo.rest.high.elasticsearch;

import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.MatchPhrasePrefixQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestHighTest {

    @Resource
    private RestHighLevelClient restHighLevelClient;


    @Test
    public void add() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", "20190909");
        map.put("name", "测试");
        map.put("age", 22);
        try {
            IndexRequest indexRequest = new IndexRequest("content", "doc", map.get("id").toString()).source(map);
            IndexResponse indexResponse = restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
            System.out.println(indexResponse.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void search() {
        SearchRequest searchRequest = new SearchRequest().indices("content").types("doc");
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        MatchPhrasePrefixQueryBuilder mppqb = QueryBuilders.matchPhrasePrefixQuery("name", "测试");
        sourceBuilder.query(mppqb);
        try {
            SearchResponse sr = this.restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
            String result = sr.toString();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void update() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", "20190909");
        map.put("name", "测试-update");
        map.put("age", 22);
        try {
            UpdateRequest request = new UpdateRequest("content", "doc", map.get("id").toString()).doc(map);
            UpdateResponse updateResponse = restHighLevelClient.update(request, RequestOptions.DEFAULT);
            System.out.println(updateResponse.toString());
        } catch (Exception e) {

        }
    }

    @Test
    public void get() {
        try {
            GetRequest request = new GetRequest("content", "doc", "20190909");
            GetResponse getResponse = this.restHighLevelClient.get(request, RequestOptions.DEFAULT);
            System.out.println(getResponse.toString());
        } catch (Exception e) {

        }
    }

    @Test
    public void delete() {
        try {
            DeleteRequest request = new DeleteRequest("content", "doc", "20190909");
            DeleteResponse deleteResponse = this.restHighLevelClient.delete(request, RequestOptions.DEFAULT);
            System.out.println(deleteResponse.toString());
        } catch (Exception e) {

        }
    }
}
