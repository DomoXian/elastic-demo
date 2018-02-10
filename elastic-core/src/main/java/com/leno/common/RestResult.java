package com.leno.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import static com.leno.common.RestCodeEnum.SUCCESS;

/**
 * <p>rest api 结果</p>
 *
 * @author: XianGuo
 * @date: 2018年02月10日
 */
@Data
public class RestResult<T> {

    private int code;

    private String desc;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    public void setRestCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public void setRestCodeEnum(RestCodeEnum restCodeEnum) {
        this.setRestCode(restCodeEnum.getCode(), restCodeEnum.getDesc());
    }

    public static <T> RestResult<T> getSuccessResult(T data) {
        RestResult<T> restResult = new RestResult<>();
        restResult.setRestCodeEnum(SUCCESS);
        restResult.setData(data);
        return restResult;
    }

    public static RestResult getFailResult(int code, String desc) {
        RestResult restResult = new RestResult();
        restResult.setRestCode(code, desc);
        return restResult;
    }

    public static RestResult getFailResult(RestCodeEnum restCodeEnum) {
        return getFailResult(restCodeEnum.getCode(), restCodeEnum.getDesc());
    }

}
