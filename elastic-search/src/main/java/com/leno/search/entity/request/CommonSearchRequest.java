package com.leno.search.entity.request;

import java.util.List;

/**
 * <p>封装的搜索请求</p>
 *
 * @author: XianGuo
 * @date: 2018年02月09日
 */
public class CommonSearchRequest {

    private List<SearchWord> searchWords;

    /**
     * 添加搜索关键字
     * @param keyword
     * @param esQueryType
     */
    private void addSearchWord(String keyword,int esQueryType){
        SearchWord searchWord = new SearchWord();
    }
}
