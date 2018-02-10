package com.leno.model.request;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * <p>用户请求参数</p>
 *
 * @author: XianGuo
 * @date: 2018年02月10日
 */
@Data
public class UserRequest {

    @NotBlank(message = "用户名不能为空")
    private String userName;

    @NotBlank(message = "登录名不能为空")
    private String loginName;


}
