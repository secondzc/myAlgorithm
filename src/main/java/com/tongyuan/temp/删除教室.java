package com.tongyuan.temp;

import java.util.*;

/**
 * Created by zhangcy on 2018/8/18
 * 在中国某大学内，教室资源十分紧张，有n个社团同时申请了在某一天使用同一间教室，假设第i个社团占用该教室的时间记为[li,  ri]。
 * 根据学校的规定，教务部门必须且最多取消一个社团的预约，来满足另外n-1个社团的
 * 需求，问学校有多少种取消的方案。(若两社团占用时间分别为[l1, r1]和[l2,  r2]，此时若r1=l2，视为时间没有冲突)
 */
public class 删除教室 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        List<String> parts = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String part = sc.nextLine();
            parts.add(part);
        }
        List<String> partsCopy = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            partsCopy.add(parts.get(i));
        }
        Collections.sort(partsCopy, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.split(" ")[0].compareTo(o2.split(" ")[0]);
            }
        });
        int min=Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < partsCopy.size()-1; i++) {
            int right = Integer.parseInt(partsCopy.get(i).split(" ")[1]);
            int left = Integer.parseInt(partsCopy.get(i+1).split(" ")[0]);
            if(right>left){
                min = left;
                break;
            }
        }
        for (int i = partsCopy.size()-1; i >0; i--) {
            int right = Integer.parseInt(partsCopy.get(i-1).split(" ")[1]);
            int left = Integer.parseInt(partsCopy.get(i).split(" ")[0]);
            if(right>left){
                max = right;
            }
            break;
        }
        int resultCount = 0;
        String result="";
        for (int i = 0; i < n; i++) {
            int left = Integer.parseInt(parts.get(i).split(" ")[0]);
            int right = Integer.parseInt(parts.get(i).split(" ")[1]);
            if(left<=min && right>=max){
                resultCount++;
                result = result+(i+1)+" ";
            }
        }
        System.out.println(resultCount);
        if(resultCount>0){
            System.out.println(result);
        }
    }
}
