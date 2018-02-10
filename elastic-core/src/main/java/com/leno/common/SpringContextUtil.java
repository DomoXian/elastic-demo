package com.leno.common;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * <p>TODO</p>
 *
 * @author: XianGuo
 * @date: 2018年02月07日
 */
public class SpringContextUtil implements ApplicationContextAware {

    private static ApplicationContext act;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        act = applicationContext;
    }

    public static <T> T getBean(Class<T> tClass) {
        return act.getBean(tClass);
    }

}
