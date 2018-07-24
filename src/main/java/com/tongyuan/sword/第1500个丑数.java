package com.tongyuan.sword;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhangcy on 2018/7/23
 * 只是由2.3.5组成的数是丑数，1也是丑数，找出第index个丑数
 * 用一个list来存储到前n个丑数，
 * t2 t3 t5 分别表示*2 *3 *5之后不再list中的丑数的最大下标，本方法可以依次找出前index个丑数
 *
 * 思路：证明找数组之外的丑数呢？它肯定是数组之内的乘过来的，数组的某个数可能是乘2或3或5，又保证是最小的那个，可用三个变量
 * 来记录乘2，3，5后刚好超出数组的丑数下标，再比较他们中最小的，以此来增长数组
 */
public class 第1500个丑数 {
    public int findUglyNum(int index){
        if(index<=5){
            return index;
        }
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        int t2 = 2;
        int t3 = 1;
        int t5 = 1;
        int count = 5;
        while(count<index){
            Integer num2 = list.get(t2)*2;
            Integer num3 = list.get(t3)*3;
            Integer num5 = list.get(t5)*5;
            Integer newNum = getMin(num2,num3,num5);
            list.add(newNum);
            while(list.get(t2)<newNum){
                t2++;
            }
            while(list.get(t3)<newNum){
                t3++;
            }
            while(list.get(t5)<newNum){
                t5++;
            }
            count++;
        }
        return list.get(index-1);
    }
    public Integer getMin(Integer m1, Integer m2, Integer m3){
        int min = m1<m2?m1:m2;
        return min<m3?min:m3;
    }

}
