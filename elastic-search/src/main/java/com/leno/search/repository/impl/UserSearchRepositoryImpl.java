package com.leno.search.repository.impl;

import com.leno.search.entity.UserESEntity;
import com.leno.search.entity.request.CommonSearchRequest;
import com.leno.search.repository.UserSearchRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>搜索数据提供实现</p>
 *
 * @author: XianGuo
 * @date: 2018年02月09日
 */
@Service
public class UserSearchRepositoryImpl implements UserSearchRepository {


    @Override
    public List<UserESEntity> searchUserByRequest(CommonSearchRequest request) {
        return null;
    }


}
