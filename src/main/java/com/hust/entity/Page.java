package com.hust.entity;

/**
 * 封装分页相关信息
 */
public class Page {

    //当前页码:未设置此参数时,默认显示首页
    private int current =1;
    //每页显示上限:未设置此参数时,默认最多显示10条
    private int limit = 10;
    //数据总数(用于计算总页数)
    private int rows;
    //查询路径(用于复用分页连接)
    private String path;

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        //防止用户注入错误的页码信息
        if(current >= 1){
            this.current = current;
        }
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        //防止注入错误的显示上限参数,并限制每页显示的最大条数为100
        if(limit >= 1 && limit <= 100){
            this.limit = limit;
        }
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        //数据总数应当大于0
        if(rows >= 0){
            this.rows = rows;
        }
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    //获取当页的起始行
    public int getOffset(){
        //当前页码减一乘每页显示上限:(current-1)*limit
        return (current - 1) * limit;
    }
    //获取总页数
    public int getTotal(){
        //数据总数除于每页显示上限
        if(rows % limit == 0){
            return rows / limit;
        }else {
            return rows / limit + 1;
        }
    }
    //获取起始页码
    public int getFrom(){
        int from = current - 2;
        //return Math.max(from, 1);
        return from < 1 ? 1 : from ;
    }
    //获取结束页码
    public int getTo(){
        int to = current + 2;
        int total = getTotal();
        //return Math.min(to, total);
        return to > total ? total : to;
    }
}
