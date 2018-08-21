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
 19 7 8 25

 输出例子1:
 2

 解题思路：这是一道贪心问题
 对于数组中的第i个元素，如果它后面有比它小的元素，这就说明第i个元素理应被移动到末尾去。
 另外，应该优先移动较小的元素，这样才能够保证较小元素最后排在最前面。

 实际上，这个问题没这么复杂。
 用一个备份数组b，把a中元素放到b中，对b数组进行排序。从第一个排好序的元素开始，即最小的元素开始与没排好序数组元素比较，检查有
 多少个已经是从小到大排好序的，位置可以不连续，但是大的元素必须在小的元素后面，统计出一共有 count个，这些元素是不需要移动的元素，一
 共有 n 个元素，所以需要移动 n - count 次
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

