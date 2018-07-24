package com.tongyuan.concurrent;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zhangcy on 2018/6/6
 */
public class 轮流打印 {
    public static String[] buildNum(){
        String[] strs = new String[26];
        for(int i=0;i<26;i++){
            strs[i] = String.valueOf(2*i+1)+String.valueOf(2*i+2);
        }
        return strs;
    }
    public static String[] buildChar(){
        String[] strs = new String[26];
        for(int i=0;i<26;i++){
            strs[i] = String.valueOf((char)('A'+i));
        }
        return strs;
    }

    static volatile Boolean numRunning = true;

    public static void main(String[] args) {

        String[] nums = buildNum();
        String[] strs = buildChar();
        Runnable numRunnable = new Runnable() {
            @Override
            public void run() {
                try{
                    for(int i=0;i<26;i++){
                        while(!numRunning){

                        }
                        System.out.print(nums[i]);
                        numRunning = false;
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        };
        Runnable strRunnable = new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 26; i++) {
                        while(numRunning){

                        }
                        System.out.print(strs[i]);
                        numRunning = true;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        final ExecutorService tpool = Executors.newFixedThreadPool(2);
        tpool.submit(numRunnable);
        tpool.submit(strRunnable);
        tpool.shutdown();
    }
}
