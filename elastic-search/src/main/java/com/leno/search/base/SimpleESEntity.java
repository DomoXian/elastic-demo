package com.leno.search.base;

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
     * 类型
     */
    private String type;

    /**
     * id
     */
    private String id;

    public SimpleESEntity() {
    }

    public SimpleESEntity(String index, String type, String id) {
        this.index = index;
        this.type = type;
        this.id = id;
    }

    @Override
    public String getIndex() {
        return this.index;
    }

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public String getId() {
        return this.id;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setId(String id) {
        this.id = id;
    }
}
