package com.example.core.dto.request.search;

public class SearchDto {
    private int pageIndex;

    private int pageSize;

    private String keyword;

    public SearchDto(int pageIndex, int pageSize, String keyword) {
        this.setPageIndex(pageIndex);
        this.setPageSize(pageSize);
        this.keyword = keyword;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        if (pageIndex != null && pageIndex > 0){
            this.pageIndex = pageIndex;
        }else {
            this.pageIndex = 0;
        }
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        if (pageSize != null && pageSize > 0){
            this.pageSize = pageSize;
        }
        else
            this.pageSize = 10;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public void setPageSizeAndPageIndex(Integer pageIndex, Integer pageSize){
        this.setPageIndex(pageIndex);
        this.setPageSize(pageSize);
    }
}
