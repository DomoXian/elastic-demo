package com.leno.search.common;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * <p>ES客户端工程类</p>
 *
 * @author: XianGuo
 * @date: 2018年02月07日
 */
public class ESClientDecorator implements InitializingBean, DisposableBean {

    private RestHighLevelClient restHighLevelClient;

    private HttpHost httpHost;

    public ESClientDecorator(HttpHost httpHost) {
        this.httpHost = httpHost;
    }

    public RestHighLevelClient getRestHighLevelClient() {
        if (restHighLevelClient == null) {
            restHighLevelClient = new RestHighLevelClient(RestClient.builder(httpHost));
        }
        return restHighLevelClient;
    }


    @Override
    public void destroy() throws Exception {
        restHighLevelClient.close();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        restHighLevelClient = new RestHighLevelClient(RestClient.builder(httpHost));
    }
}
