package com.tongyuan.designPattern.filter;

import java.util.List;

/**
 * Created by zhangcy on 2018/8/2
 */
public class Manager implements Leader {
    @Override
    public void handle(List<Leader> leaderList, int i) {
        System.out.println("manger handle");
        if(i++ < leaderList.size()){
            leaderList.get(i).handle(leaderList,i);
        }
    }
}
