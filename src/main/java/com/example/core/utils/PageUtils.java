//package com.example.core.utils;
//
//import com.example.core.dto.request.search.SearchDto;
//import org.springframework.data.domain.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
//
//public class PageUtils<T> {
//
//
//    public Page<T> getPage(SearchDto searchDto) {
//        int pageIndex = searchDto.getPageIndex();
//        int pageSize = searchDto.getPageSize();
//        if (pageIndex > 0) {
//            --pageIndex;
//        } else {
//            pageIndex = 0;
//        }
//
//        Pageable pageable = new PageRequest(pageIndex, pageSize, Sort.sort(T));
//
//        List<T> dtos = new ArrayList<>();
//        int count = 0;
//        return new PageImpl<T>(dtos, pageable, count);
//    }
//}
