package com.rancho.demo.spring.data.elasticsearch;

import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.index.query.*;
import org.elasticsearch.search.SearchHit;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.*;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ElasticsearchTemplateTest {

    @Resource
    private ElasticsearchTemplate elasticsearchTemplate;

    @Test
    public void add(){
        try{
            Map<String,Object> map=new HashMap<String,Object>();
            map.put("id","20190909");
            map.put("name","测试");
            map.put("age",22);
            IndexQuery indexQuery=new IndexQueryBuilder().withIndexName("content").withType("doc").withId(map.get("id").toString()).withObject(map).build();
            String result=elasticsearchTemplate.index(indexQuery);
            System.out.println(result);
        }catch (Exception e){

        }
    }

    @Test
    public void search(){
        MatchPhraseQueryBuilder mpqb= QueryBuilders.matchPhraseQuery("name","测试");
        try{
            SearchQuery searchQuery = new NativeSearchQueryBuilder() .withQuery(mpqb).build();
            elasticsearchTemplate.query(searchQuery,searchResponse ->{
                if (searchResponse.getHits().getTotalHits() > 0) {
                    SearchHit[] searchHits = searchResponse.getHits().getHits();
                    for(SearchHit searchHit:searchHits){
                        System.out.println(searchHit.getSourceAsString());
                    }
                }
                return null;
            });
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void update(){
        try{
            Map<String,Object> map=new HashMap<String,Object>();
            map.put("id","20190909");
            map.put("name","测试-update");
            map.put("age",22);
            IndexQuery indexQuery=new IndexQueryBuilder().withIndexName("content").withType("doc").withId(map.get("id").toString()).withObject(map).build();
            String result=elasticsearchTemplate.index(indexQuery);
            System.out.println(result);
        }catch (Exception e){

        }
    }

    @Test
    public void delete(){
        try{
            elasticsearchTemplate.delete("content","doc","20190909");
        }catch (Exception e){

        }
    }
}
