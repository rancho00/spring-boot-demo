package com.rancho.demo.jest.elasticsearch;

import io.searchbox.client.JestClient;
import io.searchbox.client.JestResult;
import io.searchbox.core.*;
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
public class JestTest {

    @Resource
    private JestClient jestClient;

    @Test
    public void add() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", "20190909");
        map.put("name", "测试");
        map.put("age", 22);
        Index index = new Index.Builder(map).id("20190909").index("content").type("doc").build();
        try {
            JestResult jestResult = jestClient.execute(index);
            System.out.println(jestResult.getJsonString());
        } catch (Exception e) {

        }
    }

    @Test
    public void search() {
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.matchPhrasePrefixQuery("name", "测试"));
        Search search = new Search.Builder(searchSourceBuilder.toString()).addIndex("content").addType("doc").build();
        try {
            JestResult jestResult = jestClient.execute(search);
            System.out.println(jestResult.getJsonString());
        } catch (Exception e) {

        }
    }

    /**
     * Index也可以修改
     */
    @Test
    public void update() {
        String script = "{" +
                "    \"doc\" : {" +
                "        \"id\" : \"20190909\"," +
                "        \"name\" : \"测试-update\"," +
                "        \"age\" : \"22\"" +
                "    }" +
                "}";
        Update update = new Update.Builder(script).index("content").type("doc").id("20190909").build();
        try {
            JestResult jestResult = jestClient.execute(update);
            System.out.println(jestResult.getJsonString());
        } catch (Exception e) {

        }
    }

    @Test
    public void get() {
        Get build = new Get.Builder("content", "20190909")
                .type("doc")
                .build();
        try {
            JestResult jestResult = jestClient.execute(build);
            System.out.println(jestResult.getJsonString());
        } catch (Exception e) {

        }
    }


    @Test
    public void delete() {
        Delete delete = new Delete.Builder("20190909").index("content").type("doc").build();
        try {
            JestResult jestResult = jestClient.execute(delete);
            System.out.println(jestResult.getJsonString());
        } catch (Exception e) {

        }
    }
}
