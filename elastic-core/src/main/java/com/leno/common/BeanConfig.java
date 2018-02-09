package com.leno.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>TODO</p>
 *
 * @author: XianGuo
 * @date: 2018年02月07日
 */
@Configuration
public class BeanConfig {

    @Bean
    public SpringContextUtil getContext() {
        return new SpringContextUtil();
    }
}
