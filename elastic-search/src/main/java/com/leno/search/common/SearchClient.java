package com.leno.search.common;


import com.alibaba.fastjson.JSONObject;
import org.elasticsearch.action.search.SearchRequest;

import java.util.List;

/**
 * <p>搜索相关接口</p>
 *
 * @author: XianGuo
 * @date: 2018年01月31日
 */
public interface SearchClient {

    /**
     * 搜索结果
     */
    List<JSONObject> search(SearchRequest request);

    /**
     * 搜索
     */
    <T> List<T> search(SearchRequest request, Class<T> tClass);


}
