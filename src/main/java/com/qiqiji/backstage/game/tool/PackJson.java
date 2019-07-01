package com.qiqiji.backstage.game.tool;

import java.util.List;

//把list组装成json的公共类
public class PackJson {
    //私有化构造器,防止实例化,单例模式
    private PackJson(){}

    public static String packJson(List<Object[]> list,int count,int totalPage){
        String stringJson = "";
        String stringJson0;
        if (list.size()>0){
            for(int i=0;i<list.size();i++){
                Object[] objects= list.get(i);
                System.out.println(objects[0]);
                String playId = String.valueOf(objects[0]);
                String scenarioName = String.valueOf(objects[1]);
                String playPeople = String.valueOf(objects[2]);
                String joinPeople = String.valueOf(objects[3]);
                String appointmentTime = String.valueOf(objects[4]);
                //{"playId":1,"scenarioName":军团战争,"playPeople":8,"joinPeople":3,"appointmentTime":2018-12-02 22:00:55.0}
                System.out.println("i="+i);
                if (i==0){
                    stringJson0 = "{\"playId\""+":"+playId+",\"scenarioName\""+":"+scenarioName+",\"playPeople\""+":"+playPeople+",\"joinPeople\""+":"+joinPeople+",\"appointmentTime\""+":"+appointmentTime+",\"count\""+":"+count+",\"totalPage\""+":"+totalPage+"}";
                }else {
                    stringJson0 = ",{\"playId\""+":"+playId+",\"scenarioName\""+":"+scenarioName+",\"playPeople\""+":"+playPeople+",\"joinPeople\""+":"+joinPeople+",\"appointmentTime\""+":"+appointmentTime+",\"count\""+":"+count+",\"totalPage\""+":"+totalPage+"}";
                }
                stringJson = stringJson + stringJson0;
            }
            stringJson = "["+stringJson+"]";
        }
        return stringJson;
    }

}
