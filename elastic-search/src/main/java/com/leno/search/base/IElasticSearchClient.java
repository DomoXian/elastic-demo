package com.leno.search.base;


import com.alibaba.fastjson.JSONObject;
import org.elasticsearch.index.query.QueryBuilder;

import java.util.List;

/**
 * <p>搜索相关接口</p>
 *
 * @author: XianGuo
 * @date: 2018年01月31日
 */
public interface IElasticSearchClient<T extends IESEntity> {

    /**
     * 保存某个实体类
     */
    void save(T entity);

    /**
     * 搜索功能
     */
    List<JSONObject> search(QueryBuilder queryBuilder, IESEntity entity);
}
