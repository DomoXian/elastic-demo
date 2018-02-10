# elasticsearch 6.x DEMO
## 简述
### SpringBoot+elasticsearch6.x搭建的es全文搜索服务demo,主要技术:
   - 1、SpringBoot+Mybatis+Elasticsearch6.x框架
   - 2、使用RestHighLevelClient作为搜索java api
   - 3、使用LogStash同步mysql数据
   
## 环境安装

* 创建需用同步数据的表 示例：

    ```CREATE TABLE user
     (
       user_id      BIGINT AUTO_INCREMENT
       COMMENT '主键'
         PRIMARY KEY,
       user_name    VARCHAR(30) DEFAULT ''              NOT NULL
       COMMENT '用户名',
       sex          INT DEFAULT '0'                     NOT NULL
       COMMENT '性别',
       login_name   VARCHAR(20) DEFAULT ''              NOT NULL
       COMMENT '登录名',
       login_pwd    VARCHAR(30) DEFAULT ''              NOT NULL
       COMMENT '密码',
       status       INT DEFAULT '0'                     NOT NULL
       COMMENT '状态',
       gmt_create   TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
       gmt_modified TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
     );

* elasticsearch安装<br>
    ` brew install elasticsearch 
      安装完成之后检查一下elasticsearch状态,使用curl命令
      curl localhost:9200
    ` 
* 中文分词器安装<br>
    ` elasticsearch-plugin install https://github.com/medcl/elasticsearch-analysis-ik/releases/download/v6.x/elasticsearch-analysis-ik-6.x.zip `
    <br>"6.x表示对应的elasticsearch版本"
    
* 创建索引和映射
    ```{
           "mappings":{
               "doc":{
                   "properties":{
                       "@timestamp":{
                           "type":"date"
                       },
                       "@version":{
                           "type":"text",
                           "fields":{
                               "keyword":{
                                   "type":"keyword",
                                   "ignore_above":256
                               }
                           }
                       },
                       "gmt_create":{
                           "type":"date"
                       },
                       "gmt_modified":{
                           "type":"date"
                       },
                       "login_name":{
                           "type":"text",
                           "fields":{
                               "keyword":{
                                   "type":"keyword",
                                   "ignore_above":256
                               }
                           },
                           "analyzer":"ik_max_word"
                       },
                       "login_pwd":{
                           "type":"text",
                           "fields":{
                               "keyword":{
                                   "type":"keyword",
                                   "ignore_above":256
                               }
                           }
                       },
                       "sex":{
                           "type":"long"
                       },
                       "status":{
                           "type":"long"
                       },
                       "user_id":{
                           "type":"long"
                       },
                       "user_name":{
                           "type":"text",
                           "fields":{
                               "keyword":{
                                   "type":"keyword",
                                   "ignore_above":256
                               }
                           },
                           "analyzer":"ik_max_word"
                       }
                   }
               }
           }
       } 

* 安装LogStash<br>
    ` brew install LogStash`

## 使用方法

* 同步数据脚本
    `sh moyu_index_sync.sh`


