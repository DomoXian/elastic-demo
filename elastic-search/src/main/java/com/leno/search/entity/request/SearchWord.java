package com.leno.search.entity.request;

import lombok.Data;

/**
 * <p>搜索词</p>
 *
 * @author: XianGuo
 * @date: 2018年02月09日
 */
@Data
public class SearchWord {

    /**
     * 搜索关键字
     */
    private String keyword;

    /**
     * 查询类型
     */
    private int queryType;

}
