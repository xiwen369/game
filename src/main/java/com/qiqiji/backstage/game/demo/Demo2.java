package com.qiqiji.backstage.game.demo;
/**
 * 1.计算总页数
 * 2.实现分页-->上一页,下一页
 * */
public class Demo2 {
    public static void main(String[] args) {
        //计算总页数
        int totalPages;//总页数
        int count = 99;//总条数
        int pageSize = 10;//页大小
        totalPages = count % pageSize > 0 ? count / pageSize + 1 : count /pageSize;
        System.out.println("总页数=" + totalPages);

        //实现分页
        int previousPage;
        int nextPage;
        int currentPage = 9;
        previousPage = currentPage > 1 ? currentPage - 1 : currentPage;
        System.out.println("上一页=" + previousPage);
        nextPage = currentPage < 10 ? currentPage + 1 : currentPage;
        System.out.println("下一页=" + nextPage);
        //我改了代码222
        //新分子进入
        //int分支!!!
        //我在int分支上进行修改





    }
}
