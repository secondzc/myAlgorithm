package com.tongyuan.temp;

/**
 * Created by zhangcy on 2018/8/16
 *  2*i+1为左子节点
 *  从2*length-1开始，调整为下滤，
 *  调整好之后交换堆顶元素和最后的元素
 *  如果是从小到大排列，则第一步是一个大顶堆
 */
public class 堆排序s {
    public static void swap(int[] a,int i,int j){

    }
    public static void adjust(int[] a,int i,int j){//i为开始的节点下标，j为结束的下标
        int tmp = a[i];
        for (int k = 2*i+1; k < j; k=k+2) {
            if(k+1<j && a[k+1]>a[k]){
                k++;
            }
            if(a[k]>tmp){
                a[i]=a[k];
                i=k;
            }else{
                break;
            }
        }
        a[i] = tmp;
    }
    public static void sort(int[] a){
        for (int i = a.length/2-1; i >=0; i--) {
            adjust(a,i,a.length-1);
        }
        for (int i = a.length-1; i >0; i--) {
            swap(a,i,0);
            adjust(a,0,i);
        }
    }
}
