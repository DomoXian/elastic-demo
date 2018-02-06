package com.leno.mybatisgen.enums;

/**
 * Created by houenxun on 16/3/14.
 * 列类型
 */
public enum ColumnTypeEnum {
    normal, //普通列
    primary, //主键
    gmtCreate,// 创建日期
    gmtModified, // 最后修改时间
    lockVersion, // 乐观锁版本
    status, //状态
    isDeleted,// 逻辑删除
    ;


    private ColumnTypeEnum() {

    }
}
