package com.tongyuan.temp;

import java.util.Scanner;

/**
 * Created by zhangcy on 2018/7/22
 * 复制可乐
 * Alice, Bob, Cathy, Dave
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 4;
        int totalSum = 4;
        while(totalSum < n){
            sum = sum*2;
            totalSum += sum;
        }
        int left = n-sum;
        if(left<=0){
            sum=2;
            left = n;
        }
        sum*=2;
        if(left<=sum/4){
            System.out.println("Alice");
        }else if(left<= sum/2){
            System.out.println("Bob");
        }else if(left<= (sum/4)*3){
            System.out.println("Cathy");
        }else{
            System.out.println("Dave");
        }
    }
}
