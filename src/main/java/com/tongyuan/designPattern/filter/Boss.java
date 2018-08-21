package com.tongyuan.designPattern.filter;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by zhangcy on 2018/8/2
 */
public class Boss implements Leader {
    @Override
    public void handle(List<Leader> leaderList, int i) {
        System.out.println("boss handle");
        if(++i < leaderList.size()){
            leaderList.get(i).handle(leaderList,i);
        }
    }
}
