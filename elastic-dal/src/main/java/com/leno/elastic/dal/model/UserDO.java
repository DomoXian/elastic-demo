package com.leno.elastic.dal.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class UserDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     * user.user_id
     */
    private Long userId;

    /**
     * 用户名
     * user.user_name
     */
    private String userName;

    /**
     * 登录名
     * user.login_name
     */
    private String loginName;

    /**
     * 密码
     * user.login_pwd
     */
    private String loginPwd;

    /**
     * 状态
     * user.status
     */
    private Integer status;

    /**
     * 
     * user.gmt_create
     */
    private Date gmtCreate;

    /**
     * 
     * user.gmt_modified
     */
    private Date gmtModified;

}