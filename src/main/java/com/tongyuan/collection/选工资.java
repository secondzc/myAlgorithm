package com.tongyuan.collection;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Created by zhangcy on 2018/6/5
 * 为了找到自己满意的工作，牛牛收集了每种工作的难度和报酬。牛牛选工作的标准是在难度不超过自身能力值的情况下，牛牛选择报酬最高的
 * 工作。在牛牛选定了自己的工作后，牛牛的小伙伴们来找牛牛帮忙选工作，牛牛依然使用自己的标准来帮助小伙伴们。牛牛的小伙伴太多了，于是他只
 * 好把这个任务交给了你。
 输入描述:
 每个输入包含一个测试用例。
 每个测试用例的第一行包含两个正整数，分别表示工作的数量N(N<=100000)和小伙伴的数量M(M<=100000)。
 接下来的N行每行包含两个正整数，分别表示该项工作的难度Di(Di<=1000000000)和报酬Pi(Pi<=1000000000)。
 接下来的一行包含M个正整数，分别表示M个小伙伴的能力值Ai(Ai<=1000000000)。
 保证不存在两项工作的报酬相同。


 输出描述:
 对于每个小伙伴，在单独的一行输出一个正整数表示他能得到的最高报酬。一个工作可以被多个人选择。

 输入例子1:
 3 3
 1 100
 10 1000
 1000000000 1001
 9 10 1000000000

 输出例子1:
 100
 1000
 1001


 思路：1.构造一个map，key为能力值，value为此能力值下能拿到的最多的钱，这个map的key需要进行一个排序，所以用到TreeMap
 2.插入map之前先对工作按照需要的能力值对工作进行排序处理（并不一定是需要的能力值越大的工作开出的工资越高）
 3.工作有两个属性，用二维数组来存储工作，排序要用到Arrays.sort()
 */
public class 选工资 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int jobNum = sc.nextInt();
        int personNum = sc.nextInt();
        TreeMap<Integer,Integer> map = new TreeMap<>();
        int[][] jobs = new int[jobNum][2];
        for(int i=0;i<jobNum;i++){
            jobs[i][0] = sc.nextInt();//所需能力值
            jobs[i][1] = sc.nextInt();//工资
        }
        //比较的时候是当成一维数组
        Arrays.sort(jobs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        for(int i=0;i<jobNum;i++){
            if(i==0){
                map.put(jobs[i][0],jobs[i][1]);
            }else{
                map.put(jobs[i][0],Math.max(jobs[i-1][1],jobs[i][1]));
            }
        }
        for(int i=0;i<personNum;i++){
            int capacity = sc.nextInt();
            //floorKey 返回小于等于给定键的最大值 ，ceilingKey返回大于等于给定键的最小值
            Integer cap = map.floorKey(capacity);
            if(cap!=null){
                System.out.println(map.get(cap));
            }else{
                System.out.println(0);
            }
        }
    }
}
