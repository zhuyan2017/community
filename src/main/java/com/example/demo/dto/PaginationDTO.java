package com.example.demo.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PaginationDTO {
    private List<QuestionDTO> questions;
    private boolean showPrevious;
    private boolean showFirstPage;
    private boolean showNext;
    private boolean showEndPage;
    private Integer page;
    private Integer totalPage;
    private List<Integer> pages = new ArrayList<>();

    public void setPagination(Integer totalPage, Integer page, Integer size) {
        this.page = page;
        this.totalPage = totalPage;

        int pageRange = 3;
        for (int i = page - pageRange; i <= page + pageRange; i++) {
            if (i >= 1 && i <= totalPage) pages.add(i);
        }

        showPrevious = page > 1 ? true : false;
        showNext = page < totalPage ? true : false;
        showFirstPage = pages.contains(1) ? false : true;
        showEndPage = pages.contains(totalPage) ? false : true;
    }
}
