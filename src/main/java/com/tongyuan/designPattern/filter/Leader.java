package com.tongyuan.designPattern.filter;

import java.util.List;

/**
 * Created by zhangcy on 2018/8/2
 */
public interface Leader {
    public void handle(List<Leader> leaderList, int i);
}
