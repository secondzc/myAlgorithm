package com.tongyuan.designPattern.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangcy on 2018/8/2
 */
public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss();
        Manager manager = new Manager();
        List<Leader> leaders = new ArrayList<>();
        leaders.add(manager);
        leaders.add(boss);
        leaders.get(0).handle(leaders,0);
    }
}
