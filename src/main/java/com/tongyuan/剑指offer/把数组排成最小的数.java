package com.tongyuan.剑指offer;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhangcy on 2018/7/23
 * 需要定义自己的排序规则，使得数组按照这个规则排列，得到的数最小，
 * 这个规则是，若mn<nm, m<n
 * 若mn>nm ,m>n
 * 若mn==nm，m=n
 *
 * 证明：1.先证明mn紧挨着，成立
 * 2.再证明若mn>nm 则 mxxn>nxxm（证明方法是mA1A2...n  将n不断和前面的A调换，再利用证明1）
 * 所以就证明了按照这个规则，最小
 */
public class 把数组排成最小的数 {
    public static List<String> getStrings(List<String> strings){
        Collections.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if((o1+o2).compareTo(o2+o1)>0){
                    return 1;
                }else if((o1+o2).compareTo(o2+o1)<0){
                    return -1;
                }else{
                    return 0;
                }
            }
        });
        return strings;
    }

    public static void main(String[] args) {
        List<String> strings = new LinkedList<>();
        strings.add("324");
        strings.add("3");
        System.out.println(getStrings(strings).toString());
    }
}
