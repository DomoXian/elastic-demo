package com.leno.search.repository;

import com.leno.search.entity.UserESEntity;
import com.leno.search.entity.request.CommonSearchRequest;

import java.util.List;

/**
 * <p>用户搜索数据提供</p>
 *
 * @author: XianGuo
 * @date: 2018年02月09日
 */
public interface UserSearchRepository {


    /**
     * 搜索
     */
    List<UserESEntity> searchUserByRequest(CommonSearchRequest request);

}
