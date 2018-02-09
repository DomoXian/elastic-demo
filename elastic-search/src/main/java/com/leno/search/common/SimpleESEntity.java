package com.leno.search.common;

/**
 * <p>TODO</p>
 *
 * @author: XianGuo
 * @date: 2018年01月31日
 */
public class SimpleESEntity implements IESEntity {

    /**
     * 索引
     */
    private String index;

    /**
     * id
     */
    private String id;

    public SimpleESEntity() {
    }

    public SimpleESEntity(String index) {
        this.index = index;
    }

    public SimpleESEntity(String index, String id) {
        this.index = index;
        this.id = id;
    }

    @Override
    public String getIndex() {
        return this.index;
    }

    @Override
    public String getId() {
        return this.id;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public void setId(String id) {
        this.id = id;
    }
}
