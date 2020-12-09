package com.chuankeji.bean;

import java.util.List;
import java.util.Map;

public class PageBen<T> {
    //当前页面数
    private  int curePage;
    //上一页
    private int prePage;
    //下一页
    private int nextPage;
    //总页数
    private int totalPage;
    //总记录数
    private int totalPeCords;
    //一页多少记录数
    private int pageSize;
    //查询开头记录数
    private int initialCount;
    //用户信息
    private List<T> list;

    public PageBen(int curePage, int totalPeCords, int pageSize) {
        this.curePage = curePage;
        this.totalPeCords = totalPeCords;
        this.pageSize = pageSize;
        totalPage = totalPeCords%pageSize == 0 ? totalPeCords/pageSize:totalPeCords/pageSize+1;

    }

    public PageBen() {

    }


    public int getCurePage() {
        return curePage;
    }

    public void setCurePage(int curePage) {
        this.curePage = curePage;
    }

    public int getPrePage() {
        //判断是不是第一页，如果不是就返回当前页面-1
        return curePage==1 ? curePage : curePage-1;
    }
    //返回Limt需要查询到的开头数
    public int getInitialCount(){
        return (curePage-1)*pageSize;
    }



    public int getNextPage() {
        //判断是不是第一页，如果不是就返回当前页面+1
        if(totalPage!=0){
            return curePage==totalPage?totalPage:curePage+1;
        }else{
            return curePage;
        }


    }


    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalPeCords() {
        return totalPeCords;
    }

    public void setTotalPeCords(int totalPeCords) {
        this.totalPeCords = totalPeCords;
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
