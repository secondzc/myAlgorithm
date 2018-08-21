package com.tongyuan.temp;

import java.util.Scanner;

/**
 * Created by zhangcy on 2018/8/18
 * A23456789TJQK
 */
public class 扑克牌 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int[] times = new int[13];
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch=='A'){
                times[0]++;
            }else if(ch=='T'){
                times[9]++;
            }else if(ch=='J'){
                times[10]++;
            }else if(ch=='Q'){
                times[11]++;
            }else if(ch=='K'){
                times[12]++;
            }else{
                times[ch-'0'-1]++;
            }
        }

    }

}
