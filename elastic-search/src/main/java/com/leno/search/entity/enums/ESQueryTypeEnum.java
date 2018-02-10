package com.leno.search.entity.enums;

/**
 * <p>es查询类型</p>
 *
 * @author: XianGuo
 * @date: 2018年02月09日
 */
public enum ESQueryTypeEnum {
    MATCH(1, "match", "全文匹配"), MATCH_PHRASE(2, "match_phrase", "紧邻搜索"), TERM(3, "term", "精确匹配");

    private Integer code;
    private String englishCode;
    private String desc;

    ESQueryTypeEnum(Integer code, String englishCode, String desc) {
        this.code = code;
        this.desc = desc;
        this.englishCode = englishCode;
    }
}
