package com.tongyuan.baidu;

import java.util.*;

/**
 度度熊有一个N个数的数组，他想将数组从小到大 排好序，但是萌萌的度度熊只会下面这个操作：
 任取数组中的一个数然后将它放置在数组的最后一个位置。
 问最少操作多少次可以使得数组从小到大有序？
 输入描述:
 首先输入一个正整数N，接下来的一行输入N个整数。(N <= 50, 每个数的绝对值小于等于1000)


 输出描述:
 输出一个整数表示最少的操作次数。

 输入例子1:
 4
 19 7 7 8 1 25 1 42 35
 1 1 42 35 7 7 8 19 25

 输出例子1:
 2

 这个答案思路很棒，若第一个数前面有比它大的，肯定是要移动的，以此类推，第二小的数和第一小的数之间的那部分也是要移动的
 也就是下面答案的辅助数组并匹配的思路
 辅助数组+两个指针，这种形式在哪里见过？
 */
public class 使数组有序 {

        public static void main (String args[]){

            Scanner scan = new Scanner(System.in);

            int n = scan.nextInt();

            int[] arr = new int[n];

            int[] sortArr = new int[n];

            for(int i = 0; i < n;  i++){

                arr[i] = scan.nextInt();

                sortArr[i] = arr[i];

            }

            Arrays.sort(sortArr);

            int count = 0;

            int j = 0;

            for(int i = 0;i < n; i++){

                if(arr[i] == sortArr[j]){

                    count++;

                    j++;

                }

            }

            System.out.println(n - count);

        }



    }

