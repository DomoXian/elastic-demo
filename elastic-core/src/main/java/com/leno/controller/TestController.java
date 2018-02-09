package com.leno.controller;

import com.leno.elastic.dal.model.UserDO;
import com.leno.elastic.dal.query.UserQuery;
import com.leno.elastic.manager.UserManager;
import com.leno.search.common.SimpleSearchClient;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>TODO</p>
 *
 * @author: XianGuo
 * @date: 2018年01月22日
 */
@RestController
public class TestController {

    @Autowired
    private UserManager userManager;


    @Autowired
    private SimpleSearchClient simpleSearchClient;

    @GetMapping("/getUserList.json")
    public Object getUserList() {
        UserQuery userQuery = new UserQuery();
        userQuery.createCriteria().andStatusEqualTo(0);
        return userManager.selectByQuery(userQuery);
    }

    @GetMapping("search.json")
    public Object search() {

        SearchRequest request = new SearchRequest();
        request.indices("moyu_index2");
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.query(QueryBuilders.matchAllQuery());
        request.source(sourceBuilder);
        return simpleSearchClient.search(request,UserDO.class);
    }

}
