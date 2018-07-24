package com.tongyuan.DP;

/**
 * Created by zhangcy on 2018/1/19
 * 动态规划求最长公共子串
 * 例子str1：abcd    str2 : acdesfd
 * a[m,n]记录两个串str1、str2的第m、n位之前的子串的最大公共子串的长度  a[m][0]=0 , a[0][n]=0 ,
 *
 * 设a[m-1][n-1]=t，则t<=a[m][n-1]<=t+1, t<=a[m-1][n]<=t+1, 设a[m-1][n-1]取到最长子串时取得的str1和str2的最后一位是
 * 第pos1和pos2位置。  1.若str1[m] == str2[n]则 a[m][n]=t+1
 * 2. if a[m][n-1]=t  then  str1[m]!=str2在pos2后的任意数字
 * 3. 同理 if a[m-1][n] = t then str2[n]!=str1在pos1后的任意数字
 * 由2.3可知，若a[m][n-1] 和a[m-1][n]有一个为t+1,则 a[m][n]=t+1,   若a[m][n-1] = a[m-1][n] = t,则a[m][n]取决于str1[m]和
 * str2[n]是否相等，若相等则为t+1,否则为t
 *
 *
 */

public class LCS {
    public Integer findLongest(String s1,String s2){
        int length1 = s1.length();
        int length2 = s2.length();
        Integer[][] a = new Integer[length1+1][length2+1];
        for(int i=0;i<length1;i++){
            a[i][0]=0;
        }
        for(int j=1;j<length2;j++){
            a[0][j]=0;
        }
        for(int i=1;i<=length1;i++){
            for(int j=1;j<=length2;j++){
//                if(a[i][j-1]>a[i-1][j-1] || a[i-1][j]>a[i-1][j-1]){
//                    a[i][j] = a[i-1][j-1]+1;
//                }else{
//                    if(s1.charAt(i)==s2.charAt(j)){
//                        a[i][j] = a[i-1][j-1]+1;
//                    }else{
//                        a[i][j] = a[i-1][j-1];
//                    }
//                }
                if(a[i][j-1]==a[i-1][j-1] && a[i-1][j]==a[i-1][j-1] && s1.charAt(i-1)!=s2.charAt(j-1)){
                    a[i][j] = a[i-1][j-1];
                }else{
                    a[i][j] = a[i-1][j-1]+1;
                }
            }
        }
        return a[length1][length2];
    }

    public static void main(String[] args) {
        LCS s=new LCS();
        System.out.println(s.findLongest("abced","acdefsd"));
    }
}
