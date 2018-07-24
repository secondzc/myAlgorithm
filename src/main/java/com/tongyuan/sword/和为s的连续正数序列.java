package com.tongyuan.sword;

/**
 * Created by zhangcy on 2018/7/24
 * 在排序数组中找和为给定值的数字
 * 从这题得到启发，我们定义两个指针ij， i指向1，j指向2，若小于s则移动j，若大于s则移动i，等于s则记录并再次移动j（因为可能有多组结果），
 * 直到不满足i<s/2 && i<j
 */
public class 和为s的连续正数序列 {
    public static void findSeq(int num){
        if(num<3){
            return ;
        }
        int i=1;
        int j=2;
        int sum = 3;
        while(i<j && i<=num/2){
            while(sum<num){
                j++;
                sum = sum+j;
            }
            if(sum==num){
                for (int k = i; k <= j; k++) {
                    System.out.print(k+ " ");
                }
                System.out.println();
                j++;
                sum = sum+j;
                continue;
            }
            while(sum>num && i<=num/2 && i<j){
                sum = sum-i;
                i++;
            }
        }
    }

    public static void main(String[] args) {
        findSeq(15);
    }
}
