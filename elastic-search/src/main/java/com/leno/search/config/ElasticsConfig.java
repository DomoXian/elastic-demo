package com.leno.search.config;

import com.leno.search.common.ESClientDecorator;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * <p>搜索连接客户端</p>
 *
 * @author: XianGuo
 * @date: 2018年01月23日
 */
@Configuration
@EnableConfigurationProperties(ElasticsProperties.class)
public class ElasticsConfig {


    @Autowired
    private ElasticsProperties elasticsProperties;

    /**
     * 初始化
     */
    @Bean
    public RestHighLevelClient restHighLevelClient() {
        return getEsClientDecorator().getRestHighLevelClient();
    }

    @Bean
    @Scope("singleton")
    public ESClientDecorator getEsClientDecorator() {
        return new ESClientDecorator(new HttpHost(elasticsProperties.getClusterNodes(), elasticsProperties.getPort()));
    }


}
