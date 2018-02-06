package com.leno.search.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
        HttpHost host = new HttpHost(elasticsProperties.getClusterNodes(),9200);
        return new RestHighLevelClient(RestClient.builder(host));
    }


}
