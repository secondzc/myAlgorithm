package com.tongyuan.牛客;

import java.util.*;

/**
 * Created by zhangcy on 2018/8/12
 *
 * 3
 1,10;32,45
 78,94;5,16
 80,100;200,220;16,32

 1,45;78,100;200,220
 */
public class 多个区间合并 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        List<String> strs = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String line = sc.next();
            String[] strings = line.split(";");
            for(String s:strings){
                strs.add(s);
            }
        }
        Collections.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                Integer i1 = Integer.parseInt(o1.split(",")[0]);
                Integer i2 = Integer.parseInt(o2.split(",")[0]);
                return i1.compareTo(i2);
            }
        });
        List<String> result = new ArrayList<>();
        result.add(strs.get(0));
        int max = Integer.parseInt(strs.get(0).split(",")[1]);
        for (int i = 1; i < strs.size(); i++) {
            Integer i1 = Integer.parseInt(strs.get(i).split(",")[0]);
            Integer i2 = Integer.parseInt(strs.get(i).split(",")[1]);
            if(max<i1){
                result.add(strs.get(i));
                max = i2;
            }else if(max<i2){
                int index = result.size()-1;
                String s = result.get(index);
                result.remove(index);
                String news = s.split(",")[0]+","+i2;
                result.add(news);
                max = i2;
            }
        }
        String res = "";
        for (int i = 0; i < result.size(); i++) {
            res = res+result.get(i)+";";
        }
        System.out.println(res.substring(0,res.length()-1));
    }
}
