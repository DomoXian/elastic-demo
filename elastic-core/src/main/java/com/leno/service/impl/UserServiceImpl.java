package com.leno.service.impl;

import com.leno.common.RestResult;
import com.leno.elastic.dal.model.UserDO;
import com.leno.elastic.dal.query.UserQuery;
import com.leno.elastic.manager.UserManager;
import com.leno.model.request.UserRequest;
import com.leno.search.common.SearchClient;
import com.leno.search.entity.UserESEntity;
import com.leno.service.UserService;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>用户相关接口实现</p>
 *
 * @author: XianGuo
 * @date: 2018年02月10日
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private SearchClient searchClient;

    @Autowired
    private UserManager userManager;

    @Override
    public RestResult<List<UserDO>> getUserList(UserRequest request) {
        UserQuery userQuery = new UserQuery();
        userQuery.createCriteria().andStatusEqualTo(0)
                .andUserNameEqualTo(request.getUserName())
                .andLoginNameEqualTo(request.getLoginName());
        return RestResult.getSuccessResult(userManager.selectByQuery(userQuery));
    }

    @Override
    public RestResult<List<UserESEntity>> searchMatchByName(String userName) {
        SearchRequest searchRequest = new SearchRequest();
        searchRequest.indices("moyu_index2");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.matchQuery("user_name", userName));
        searchRequest.source(searchSourceBuilder);
        return RestResult.getSuccessResult(searchClient.search(searchRequest, UserESEntity.class));
    }

    @Override
    public RestResult<List<UserESEntity>> searchTermByName(String userName) {
        SearchRequest searchRequest = new SearchRequest();
        searchRequest.indices("moyu_index2");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.termQuery("user_name", userName));
        searchRequest.source(searchSourceBuilder);
        return RestResult.getSuccessResult(searchClient.search(searchRequest, UserESEntity.class));
    }

    @Override
    public RestResult<List<UserESEntity>> searchMatchPhraseByName(String userName) {
        SearchRequest searchRequest = new SearchRequest();
        searchRequest.indices("moyu_index2");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.matchPhraseQuery("user_name", userName));
        searchRequest.source(searchSourceBuilder);
        return RestResult.getSuccessResult(searchClient.search(searchRequest, UserESEntity.class));
    }
}
