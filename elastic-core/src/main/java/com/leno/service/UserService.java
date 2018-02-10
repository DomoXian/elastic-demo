package com.leno.service;

import com.leno.common.RestResult;
import com.leno.elastic.dal.model.UserDO;
import com.leno.model.request.UserRequest;
import com.leno.search.entity.UserESEntity;

import java.util.List;

/**
 * <p>用户相关服务</p>
 *
 * @author: XianGuo
 * @date: 2018年02月10日
 */
public interface UserService {

    /**
     * 根据请求参数获取用户利比饿哦
     */
    RestResult<List<UserDO>> getUserList(UserRequest request);

    /**
     * 全文搜索
     */
    RestResult<List<UserESEntity>> searchMatchByName(String userName);


    /**
     * 精确搜索
     */
    RestResult<List<UserESEntity>>  searchTermByName(String userName);


    /**
     * 紧邻搜索
     */
    RestResult<List<UserESEntity>>  searchMatchPhraseByName(String userName);
}
