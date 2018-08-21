package com.tongyuan.temp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangcy on 2018/8/13
 */
public class Main1 {
        public static int[] plusOne(int[] digits) {
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<digits.length;i++){
                sb.append(digits[i]);
            }
            Integer num = Integer.parseInt(sb.toString());
            num++;
            String strNum = String.valueOf(num);
            System.out.println(strNum);
            List<Integer> result = new ArrayList<>();
            for(int i=0;i<strNum.length();i++){
                System.out.println(strNum.indexOf(i));
                String str = String.valueOf(strNum.indexOf(i));
                System.out.println(Integer.parseInt(str));
                result.add(Integer.parseInt(String.valueOf(strNum.indexOf(i))));
            }
            Object[] result1 =  result.toArray();
            int[] result2 = new int[result1.length];
            for(int i=0;i<result1.length;i++){
                result2[i] = (Integer)result1[i];
                System.out.println(result2[i]);
            }
            return result2;
        }

    public static void main(String[] args) {
        plusOne(new int[]{0});
    }
}
