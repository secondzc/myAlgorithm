package com.tongyuan.牛客;

/**
 * Created by zhangcy on 2018/7/30
 * 两排序数组的中位数,若总个数为偶数，则返回中间两个数中的前面一个
 * 二分法 时间复杂度为log(m+n)
 *
 */
public class 两排序数组的中位数 {
    //a,b两数组中某个范围的第k大的数
    public static int kth(int[] a,int start1, int length1, int[] b,int start2, int length2,int k){
        //默认后面数组的区间长度短
        if(length1<length2){
            return kth(b,start2,length2,a,start1,length1,k);
        }
        if(length2==0){
            return a[start1+length1-1];
        }
        int i = Math.min(k/2,length2); //b增加的偏移量
        int j = k-i; //a增加的偏移量
        if(a[start1+j]==b[start2+i]){
            return a[start1+j];
        }else if(a[start1+j]>b[start2+i]){//舍去b的前一部分
            return kth(a,start1,length1,b,start2+i,length2-i,k-i);
        }else{
            return kth(a,start1+j,length1-j,b,start2,length2,k-j);
        }
    }
    public static int kth(int[] a,int[] b){
        int length1 = a.length;
        int length2 = b.length;
        return kth(a,0,length1,b,0,length2,(length1+length2)/2+1);
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4};
        int[] b = {2,3,4};
        System.out.println(kth(a,b));
    }
}
