package com.laowang.util;

/**
 * @author 隔壁老王
 */
public class PageUtil{
    private int page; //当前页
    private int rows; //行数
    private int index; //索引，分页函数的初始值
    private int countRows; //总行数
    private int countPages; //总页数
    private int prevPage; //上一页
    private int nextPage; //下一页
    private Object list; //PU携带的数据

   public PageUtil(String page,Integer rows, Integer countRows){
       this.rows =rows;
       this.countRows = countRows;
       initPage(page);
       initIndex();
       initCountPages();
       initPrevPage();
       initNextPage();
   }
    // 初始化页码
    private void initPage(String page) {
       if (page == null || "".equals(page)){
           this.page = 1;
       }else {
           this.page = Integer.parseInt(page);
       }
    }

    //初始化偏移量
    private void initIndex() {
       this.index = (this.page-1)*this.rows;
    }

    //初始化总页数
    private void initCountPages() {
       int mod = this.countRows % this.rows;
       if (mod == 0){
           this.countPages = this.countRows / this.rows;
       }else{
           this.countPages = this.countRows / this.rows + 1;
       }
    }

    //初始化当前页码的上一页
    private void initPrevPage() {
       if (this.page == 1){
           this.prevPage = 1;
       }else{
           this.prevPage = this.page - 1;
       }
    }

    //初始化当前页码的下一页
    private void initNextPage() {
        if(this.page == this.countPages){
            this.nextPage = this.countPages;
        }else{
            this.nextPage = this.page + 1;
        }
    }

    public int getPage() {
        return page;
    }

    public int getRows() {
        return rows;
    }

    public int getIndex() {
        return index;
    }

    public int getCountRows() {
        return countRows;
    }

    public int getCountPages() {
        return countPages;
    }

    public int getPrevPage() {
        return prevPage;
    }

    public int getNextPage() {
        return nextPage;
    }

    public Object getList() { return list; }

    public void setList(Object list) { this.list = list; }
}
