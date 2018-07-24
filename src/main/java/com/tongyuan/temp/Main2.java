package com.tongyuan.temp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by zhangcy on 2018/7/22
 * 一行输入，包含N个正整数，表示每个货物的重量，空格分隔。
 * 最少需要多少辆车 300容量
 *
 * 找出100和200和大于200和的货物，先处理
 * 对100多的，一定是两两配对，排序，从最小的开始，尽量配对大的
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> weights = new ArrayList<>();
        int count100 =0;
        int count200 = 0;
        int countMore200 = 0;
        while(sc.hasNext()){
            int num = sc.nextInt();
            if(num == 100){
                count100++;
            }else if(num == 200){
                count200++;
            }else if(num>200){
                countMore200++;
            }else{
                weights.add(num);
            }
        }
        int total = 0;
        total = total + count100/3;
        total += countMore200;
        if(count200>=((count100)%3)){
            total += count200;
        }else{
            for (int i = 0; i < (count100%3) - count200; i++) {
                weights.add(100);
            }
        }
        Collections.sort(weights);
        int i=0;
        int j=weights.size()-1;
        while(i<j){
            if(weights.get(i)+weights.get(j) <= 300){
                i++;
            }
            j--;
            total++;
        }
        if(i==j){
            total++;
        }
        System.out.println(total);
    }
}
