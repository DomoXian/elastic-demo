package com.leno.common;

import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <p>controller异常统一处理</p>
 *
 * @author: XianGuo
 * @date: 2018年02月10日
 */
@ControllerAdvice
public class ElasticControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public Object handlerValidException(MethodArgumentNotValidException e) {
        RestResult result = RestResult.getFailResult(RestCodeEnum.PARAMS_ERROR);
        BindingResult bindingResult = e.getBindingResult();
        if (bindingResult == null || CollectionUtils.isEmpty(bindingResult.getAllErrors())) {
            return result;
        }

        List<ObjectError> errors = bindingResult.getAllErrors();
        result.setDesc(errors.get(0).getDefaultMessage());
        return result;
    }
}
