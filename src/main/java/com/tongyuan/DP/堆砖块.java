package com.tongyuan.DP;

/**
 * Created by zhangcy on 2018/1/25
 * 小易有n块砖块，每一块砖块有一个高度。小易希望利用这些砖块堆砌两座相同高度的塔。为了让问题简单，砖块堆砌就是简单的高度相加，某一块砖只能使用在一座塔中一次。小易现在让能够堆砌出来的两座塔的高度尽量高，小易能否完成呢。
 输入描述:
 输入包括两行： 第一行为整数n(1 ≤ n ≤ 50)，即一共有n块砖块 第二行为n个整数，表示每一块砖块的高度height[i] (1 ≤ height[i] ≤ 500000)


 输出描述:
 如果小易能堆砌出两座高度相同的塔，输出最高能拼凑的高度，如果不能则输出-1. 保证答案不大于500000。

 输入例子1:
 3 2 3 5

 输出例子1:
 5

！！！！！！！！！！！dp0[j] 中j = B-A+sum, dp1 的值表示当B-A+sum=j这种情况下，A的高度，（dp0表示这种情况下B的高度）
 若dp0的值为-1，表示这种情况不存在

 这个例子实际上是和二维数组类似，这类问题一般有三个关系，i、j、和函数值dp之间的关系
 这题中j表示A-B的长度（进行偏移）
 i表示使用前i个砖块
 函数值dp表示所求的最大高度（这题中若-1则最大高度不存在）
 */
import java.util.*;
public class 堆砖块 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] h = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            h[i] = in.nextInt();
            sum += h[i];
        }
        //本来想用二维数组来存放，但运行会超出内存，所以行不通
        int[] dp0 = new int[sum * 2 + 1], dp1 = new int[sum * 2 + 1];
        //dp0表示上次放砖时各个位置的情况，dp1表示这次放砖时应该变成的情况
        //dp平移sum位是因为B堆-A堆高度的范围在-sum至sum之间，所以平移sum位以便存储每个的值
        //所以也就是说j下标为sum时表示A、B堆高度相同时的情况，往左就是B堆较高的情况，往右就是A堆较高的情况
        for (int i = 0; i < sum*2 + 1; i++) dp0[i] = -1;
        dp0[sum] = 0;
        for (int i = 1; i <= n; i++) {
            int hg = h[i-1];
            //j表示B堆-A堆的高度差（由于平移的原因，sum即为0，往左一次加1，往右依次减1）
            //dp1[j]存放的值表示B目前所能存放的最大高度
            //dp1[j]是在上次的基础上（也就是dp0）进行变换的
            for (int j = 0; j < 2 * sum + 1; j++) {
                dp1[j] = dp0[j];
                //这是将hg的高度加载A上的情况，这时dp0[j-hg]和dp0[j]分别表示符合的两种情况，也就是说dp[j-hg]若进行了
                //这种操作之后就可以转变成dp[j]，现在就是要取更好的值
                if (j - hg >= 0 && dp0[j - hg] != -1) {
                    dp1[j] = Math.max(dp0[j - hg], dp1[j]);
                }
                //将hg加在B上
                if (j + hg <= 2 * sum && dp0[j + hg] != -1) {
                    dp1[j] = Math.max(dp0[j + hg] + hg, dp1[j]);
                }
            }
            //交换两个数组，确保dp0一直是上次的状态
            int[] t = dp0;
            dp0 = dp1;
            dp1 = t;
        }
        //最后一次变换完为dp0，所以对dp0进行求解
        if (dp0[sum] == 0) System.out.println(-1);
        else System.out.println(dp0[sum]);
    }
}