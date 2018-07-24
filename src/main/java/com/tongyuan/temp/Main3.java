package com.tongyuan.temp;

import java.util.*;

/**
 * Created by zhangcy on 2018/7/22
 * 第一行包含2个整数 N、K，分别表示手机号码数字个数以及靓号至少有 K 个数字相同。
 第二行包含 N 个字符，每个字符都是一个数字('0'-'9')，数字之间没有任何其他空白符。表示小多的手机号码。
 数据范围：
 2 <= K <= N <= 10000

 第一行包含一个整数，表示修改成一个靓号，最少需要的金额。
 第二行包含 N 个数字字符，表示最少花费修改的新手机号。若有多个靓号花费都最少，则输出字典序最小的靓号。
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int k = sc.nextInt();
        String phone = sc.next();
        int[] phones = new int[n];
        for (int i = 0; i < phone.length(); i++) {
            phones[i] = phone.charAt(i)-'0';
        }

        int minCost = Integer.MIN_VALUE;
        List<Integer> modify = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            List<Integer> modify1 = new ArrayList<>();
            int count = 0;
            TreeMap<Integer,Integer> moneys = new TreeMap<Integer,Integer>();  //<花费，位数>
            for (int j = 0; j < n; j++) { //j表示n位手机号的第j位
                moneys.put((Math.abs(phones[j]-i)),j);
            }
            for (int j = 0; j < k; j++) {
                Map.Entry<Integer,Integer> entry = moneys.firstEntry();
                count += entry.getKey();
                moneys.remove(entry.getKey());
                modify1.add(entry.getValue());
            }
            if(count<minCost){
                minCost = count;
                modify.addAll(modify1);
            }
        }
        System.out.println(minCost);
        //根据modify确定要修改的位数，并输出
    }
}
