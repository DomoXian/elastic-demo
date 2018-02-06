package com.leno.search.base;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.message.BasicHeader;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>用户搜索客户端</p>
 *
 * @author: XianGuo
 * @date: 2018年01月31日
 */
@Service
public class SimpleSearchClient<T extends IESEntity> implements IElasticSearchClient<T> {

    @Autowired
    private RestHighLevelClient client;


    @Override
    public void save(T entity) {
        try {
            IndexRequest request = new IndexRequest(entity.getIndex(), entity.getType(), entity.getId());
            request.source(JSON.toJSONString(entity), XContentType.JSON);
            client.index(request, new BasicHeader("header", "value"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<JSONObject> search(QueryBuilder queryBuilder, IESEntity entity) {
        try {

            SearchRequest request = new SearchRequest();

            if (entity.getIndex() != null) {
                request.indices(entity.getIndex());
            }
            if (entity.getType() != null) {
                request.types(entity.getType());
            }
            SearchSourceBuilder builder = new SearchSourceBuilder();
            builder.query(queryBuilder);
            request.source(builder);
            SearchResponse response = client.search(request);
            List<JSONObject> list = new ArrayList<>();
            response.getHits().forEach(item -> {
                list.add(JSON.parseObject(item.getSourceAsString()));
            });
            return list;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
