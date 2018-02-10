package com.leno.search.common;

import com.alibaba.fastjson.JSONObject;
import org.elasticsearch.action.search.SearchRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>TODO</p>
 *
 * @author: XianGuo
 * @date: 2018年02月10日
 */
@Service("luSearchClient")
public class LuSearchClient implements SearchClient {
    @Override
    public List<JSONObject> search(SearchRequest request) {
        return null;
    }

    @Override
    public <T> List<T> search(SearchRequest request, Class<T> tClass) {
        return null;
    }
}
