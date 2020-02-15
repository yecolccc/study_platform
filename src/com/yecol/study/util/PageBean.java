package com.yecol.study.util;

import java.util.List;

/**
 * 分页对象
 */
public class PageBean<T> {

    private int totalCount;//总记录数	数据库查
    private int totalPage;//总页数		根据总记录数和每页显示的条数来计算
    private int currentPage;//当前页码	前端传过来
    private int pageSize;//每页显示的条数	前端传过来
    
    private List<T> list;//每页显示的数据集合	数据库查

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
