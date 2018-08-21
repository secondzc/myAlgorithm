package com.tongyuan.temp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by zhangcy on 2018/8/18
 * 山区里有N个村庄，第i个村庄的海拔高度为Ai。现在要在村庄之间修建道路，使得从每个村庄出发，都能到达其它所有
 * 村庄。在第i和第j个村庄之间修建道路的费用取决于海拔较高的村庄的高度，即费用为max{Ai，Aj}，那么修建道路的总费用最少是多少？
 */
public class 村庄修路 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nums.add(sc.nextInt());
        }
        int min = Integer.MAX_VALUE;
        int total=0;
        for (int i = 0; i < n; i++) {
            total+=nums.get(i);
            if(nums.get(i)<min){
                min=nums.get(i);
            }
        }
        total-=min;
        System.out.println(total);
    }
}
