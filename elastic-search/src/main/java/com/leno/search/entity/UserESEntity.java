package com.leno.search.entity;

import lombok.Data;

import java.util.Date;

/**
 * <p>用户搜索结果</p>
 *
 * @author: XianGuo
 * @date: 2018年01月31日
 */
@Data
public class UserESEntity extends BaseEntity {


    private static final long serialVersionUID = -750071967756810272L;
    /**
     * 主键
     */
    private Long userId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 登录名
     */
    private String loginName;

    /**
     * 密码
     */
    private String loginPwd;

    /**
     * 状态
     */
    private Integer status;

    private Date gmtCreate;

    private Date gmtModified;
}
