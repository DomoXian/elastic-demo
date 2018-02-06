package com.leno.mybatisgen;

/**
 * Created by houenxun on 16/3/14.
 */
public class ColumnInfo {
    private String name;
    private String calssName;
    private String typeName;
    private String precision;
    private String scale;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCalssName() {
        return calssName;
    }

    public void setCalssName(String calssName) {
        this.calssName = calssName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getPrecision() {
        return precision;
    }

    public void setPrecision(String precision) {
        this.precision = precision;
    }

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }
}
