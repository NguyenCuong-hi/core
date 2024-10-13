package com.example.core.utils;

import com.example.core.dto.request.search.SearchDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

public class PageUtils<T> {

    public Page<T> getPage(SearchDto searchDto) {
        int pageIndex = searchDto.getPageIndex();
        int pageSize = searchDto.getPageSize();
        if (pageIndex > 0) {
            --pageIndex;
        } else {
            pageIndex = 0;
        }

        Pageable pageable = new PageRequest();
    }
}
