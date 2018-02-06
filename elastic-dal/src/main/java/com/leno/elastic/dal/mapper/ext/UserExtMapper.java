package com.leno.elastic.dal.mapper.ext;

import com.leno.elastic.dal.mapper.UserMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * MyBatis Ext Mapper for User.
 */

@Mapper
@Repository
public interface UserExtMapper extends UserMapper {

}