package com.qiqiji.backstage.game.tool;

public class GetTotalPage {
    //构造器私有化
    private GetTotalPage(){}
    //获取订单列表的总页数
    public static int getTotalPage(int pageSize, int count){
        int totalPage = 0;
        int totalCount = Integer.valueOf(count);
        if("0".equals(totalCount)){
            return totalPage;
        }
        totalPage = totalCount%pageSize == 0 ? totalCount/pageSize : totalCount/pageSize +1 ;
        if(totalPage<1){
            totalPage = 1;
        }
        return totalPage;
    }
}
