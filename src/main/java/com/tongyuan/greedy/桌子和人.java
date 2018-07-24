package com.tongyuan.greedy;

import java.util.*;

/**
 * Created by zhangcy on 2018/1/29
 * 某餐馆有n张桌子，每张桌子有一个参数：a 可容纳的最大人数； 有m批客人，每批客人有两个参数:b人数，c预计消费金额。 在不允许拼桌的情况下，请实现一
 * 个算法选择其中一部分客人，使得总预计消费金额最大
 输入描述:
 输入包括m+2行。 第一行两个整数n(1 <= n <= 50000),m(1 <= m <= 50000) 第二行为n个参数a,即每个桌子可容纳的最大人数,以空格分隔,范围均
 在32位int范围内。 接下来m行，每行两个参数b,c。分别表示第i批客人的人数和预计消费金额,以空格分隔,范围均在32位int范围内。


 输出描述:
 输出一个整数,表示最大的总预计消费金额

 输入例子1:
 3 5
 2 4 2
 1 3
 3 5
 3 7
 5 9
 1 10

 输出例子1:
 20

 是否可以用贪心呢？可以证明是贪心的，单价最大的一批若选择，一定是对应能装下它的最小的桌子a，因为如果选了更大的桌子b，而用桌子a装了另外一批，
 那完全可以调换过来而总价值不变。若不选择单价最大的一批，而用a装了另外的一批，则在其他相同的条件下，用他来调换之，则总价值更大。所以，在一批中，
 总是选择能装下的价值最大的一批，形成了贪心。

 此题中，person可以用二维数组而不用一个类，对普通数组排序可以用Arrays.sort()
 */
public class 桌子和人 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int deskNum = sc.nextInt();
        int personNum = sc.nextInt();
        int[] desk = new int[deskNum];
        int[][] person = new int[personNum][2];
        for(int i=0;i<deskNum;i++){
            desk[i] = sc.nextInt();
        }
        for(int i=0;i<personNum;i++){
            person[i][0] = sc.nextInt();
            person[i][1] = sc.nextInt();
        }
        //桌子升序，人降序
        Arrays.sort(desk);
        Arrays.sort(person, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1]-o1[1];
            }
        });
        boolean[] visited = new boolean[deskNum];
        //从人中按花费顺序挑选，若没有能容下的桌子，则跳过，直到桌子用完或人遍历完
        int deskCount = 0;
        boolean alreadyFindDesk;
        int sumMoney = 0;
        for(int i=0;i<personNum && deskCount<deskNum;i++){
            alreadyFindDesk = false;
            for(int j=0;j<deskNum && !alreadyFindDesk;j++){
                if(desk[j]>=person[i][0] && !visited[j]){
                    visited[j] = true;
                    alreadyFindDesk = true;
                    deskCount++;
                    sumMoney+=person[i][1];
                }
            }
        }
        System.out.println(sumMoney);
    }
}
