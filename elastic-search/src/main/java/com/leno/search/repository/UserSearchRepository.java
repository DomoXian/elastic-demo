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
     * 全文搜索(match)
     */

    /**
     * 紧邻搜索（match_phrase）
     */

    /**
     * 精确搜索（term）
     */
    List<UserESEntity> searchUserByRequest(CommonSearchRequest request);
}
