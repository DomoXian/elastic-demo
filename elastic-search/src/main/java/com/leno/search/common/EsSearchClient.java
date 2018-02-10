package com.leno.search.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>用户搜索客户端</p>
 *
 * @author: XianGuo
 * @date: 2018年01月31日
 */
@Service("searchClient")
@Slf4j
public class EsSearchClient implements SearchClient {

    @Autowired
    private RestHighLevelClient client;

    @Override
    public List<JSONObject> search(SearchRequest request) {
        try {
            SearchResponse response = client.search(request);
            if (response.getHits() == null) {
                return null;
            }
            List<JSONObject> list = new ArrayList<>();
            response.getHits().forEach(item -> list.add(JSON.parseObject(item.getSourceAsString())));
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public <T> List<T> search(SearchRequest request, Class<T> tClass) {
        List<JSONObject> searchResponse = this.search(request);
        if (searchResponse == null) {
            return null;
        }
        List<T> list = new ArrayList<>(searchResponse.size());
        searchResponse.forEach(item -> list.add(JSON.parseObject(JSON.toJSONString(item), tClass)));
        return list;
    }
}
