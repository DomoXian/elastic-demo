package com.leno.entity;

import com.leno.entity.base.ElasticsEntity;

import java.util.Date;
import java.util.UUID;

/**
 * <p>TODO</p>
 *
 * @author: XianGuo
 * @date: 2018年01月23日
 */
public class ExampleElasticsEntity implements ElasticsEntity {

    private String id;
    private String message;
    private Date created;

    public ExampleElasticsEntity(String message) {
        id = UUID.randomUUID().toString();
        this.message = message;
        created = new Date();
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getIndex() {
        return "examples";
    }

    @Override
    public String getType() {
        return "examples";
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
