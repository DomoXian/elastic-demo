package com.leno.controller;

import com.leno.elastic.dal.model.UserDO;
import com.leno.elastic.dal.query.UserQuery;
import com.leno.elastic.manager.UserManager;
import com.leno.search.base.SimpleESEntity;
import com.leno.search.base.SimpleSearchClient;
import com.leno.search.entity.UserESEntity;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    private SimpleSearchClient<UserESEntity> simpleSearchClient;


    @GetMapping("/getUserList.json")
    public Object getUserList() {
        UserQuery userQuery = new UserQuery();
        userQuery.createCriteria().andStatusEqualTo(0);
        return userManager.selectByQuery(userQuery);
    }

    @GetMapping("saveElasticData.json")
    public Object saveElastic() {
        UserQuery userQuery = new UserQuery();
        userQuery.createCriteria().andStatusEqualTo(0);
        List<UserDO> userDOList = userManager.selectByQuery(userQuery);
        for (UserDO item : userDOList) {
            UserESEntity userESEntity = new UserESEntity();
            BeanUtils.copyProperties(item, userESEntity);
            simpleSearchClient.save(userESEntity);
        }
        return "插入成功";
    }

    @GetMapping("search.json")
    public Object search() {

        return simpleSearchClient.search(QueryBuilders.matchQuery("userName", "张三"), new SimpleESEntity("moyu_db", null, null));
    }
}
