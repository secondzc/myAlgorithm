package com.tongyuan.牛客;

/**
 * Created by zhangcy on 2018/8/20
 * 一个字符串增加或者修改一个字符为一次操作，若一个字符串经过n次操作之后得到另个字符串，则称为相似度为n
 */
public class 计算字符串相似度 {
    public static void main(String[] args) {
        System.out.println(cal("abcd","abed"));
    }
    public static int cal(String str1, String str2){
        if(str1==null && str2==null){
            return 0;
        }
        if(str1==null){
            return str2.length();
        }
        if(str2==null){
            return str1.length();
        }
        return cal(str1,str2,0,str1.length()-1,0,str2.length()-1);
    }

    public static int cal(String str1,String str2,int start1,int end1,int start2,int end2){
        if(start1>end1){
            if(start2>end2){
                return 0;
            }else{
                return end2-start2+1;
            }
        }
        if(start2>end2){
            if(start1>end1){
                return 0;
            }else{
                return end1-start1+1;
            }
        }
        if(str1.charAt(start1)==str2.charAt(start2)){
            return cal(str1,str2,start1+1,end1,start2+1,end2);
        }else{
            int t1 = cal(str1,str2,start1+1,end1,start2+2,end2);
            int t2 = cal(str1,str2,start1+2,end1,start2+2,end2);
            int t3 = cal(str1,str2,start1+2,end1,start2+1,end2);
            return Math.min(Math.min(t1,t2),t3)+1;
        }
    }
}
