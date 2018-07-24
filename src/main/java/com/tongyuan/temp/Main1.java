package com.tongyuan.temp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by zhangcy on 2018/7/22
 * 第一行包含2个整数 N、M，分别表示候选球星数量以及选票数量。
 接下来有 M 行，每行是一个长度为 N 的字符串，每个字符串表示一张选票上的信息。每个字符串的第 k (0 <= k < N) 个字符，表示
 这张选票对第 k 个候选球星的评级。
 数据范围：
 1 <= N <= 50
 1 <= M <= 50
 字符串只包含小写英文字母(a-z)。
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<String> strs = new ArrayList<>(m);
        for (int i = 0; i < m; i++) {
            strs.add(sc.next());
        }
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if(isStronger(strs,i,j)){
                    count++;
                }
            }
            if(count== n-1){
                flag = true;
                System.out.println(i);
                break;
            }
        }
        if(!flag){
            System.out.println(-1);
        }
    }
    public static boolean isStronger(List<String> strs, int m, int n){
        int countm = 0;
        int countn = 0;
        for (int i = 0; i < strs.size(); i++) {
            if(strs.get(i).charAt(m) > strs.get(i).charAt(n)){
                countn++;
            }
            if(strs.get(i).charAt(m) < strs.get(i).charAt(n)){
                countm++;
            }
        }
        if(countm>countn){
            return true;
        }else{
            return false;
        }
    }

}
