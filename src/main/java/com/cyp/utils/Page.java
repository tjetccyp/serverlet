package com.cyp.utils;

import java.util.List;

public class Page<T> {
    private int currentPage;//当前页
    private int PageSize;//一页显示的数据数量
    private int totalData;//一共数据条数
    private List<T> data;

    public Page() {
    }

    public Page(int currentPage, int pageSize) {
        this.currentPage = currentPage;
        PageSize = pageSize;
    }
    //总页数
    public int sumPage(){
        return this.totalData%this.PageSize==0?this.totalData/this.PageSize:(this.totalData/this.PageSize+1);
    }
    //上一页
    public int prevPage(){
        return (this.currentPage-1)>0?this.currentPage-1:1;
    }
    //下一页
    public int nextPage(){
        return (this.currentPage+1)<=sumPage()?this.currentPage+1:sumPage();
    }
    //sql查询开始索引条数位置
    public int startIndex(){
        return (this.currentPage-1)*this.PageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return PageSize;
    }

    public void setPageSize(int pageSize) {
        PageSize = pageSize;
    }

    public int getTotalData() {
        return totalData;
    }

    public void setTotalData(int totalData) {
        this.totalData = totalData;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Page{" +
                "currentPage=" + currentPage +
                ", PageSize=" + PageSize +
                ", totalData=" + totalData +
                ", data=" + data +
                '}';
    }
}
