package com.tongyuan.math;

import java.util.Scanner;

/**
 * Created by zhangcy on 2018/1/24
 * 小易拥有一个拥有魔力的手环上面有n个数字(构成一个环),当这个魔力手环每次使用魔力的时候就会发生一种奇特的变化：每个数字会变成自己跟后面一个数字的和(最后一个数字的后面一个数字是第一个),一旦某个位置的数字大于等于100就马上对100取模(比如某个位置变为103,就会自动变为3).现在给出这个魔力手环的构成，请你计算出使用k次魔力之后魔力手环的状态。
 输入描述:
 输入数据包括两行： 第一行为两个整数n(2 ≤ n ≤ 50)和k(1 ≤ k ≤ 2000000000),以空格分隔 第二行为魔力手环初始的n个数，以空格分隔。范围都在0至99.


 输出描述:
 输出魔力手环使用k次之后的状态，以空格分隔，行末无空格。

 输入例子1:
 3 2
 1 2 3

 输出例子1:
 8 9 7
 */
public class 矩阵快速幂 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int k = sc.nextInt();
        int[][] matrix = new int[1][n];
        for(int i=0;i<n;i++){
            matrix[0][i]=sc.nextInt();
        }
        int[][] matrix1 = new int[n][n];
        for(int i=1;i<n;i++){
            matrix1[i][i-1] = 1;
            matrix1[i][i] = 1;
        }
        matrix1[0][0]=1;
        matrix1[0][n-1] = 1;
        int[][] matrix2 = power(matrix1,k);
        int[][] result = multi(matrix,matrix2);
        for(int i=0;i<n-1;i++){
            System.out.print(result[0][i]+" ");
        }
        System.out.print(result[0][n-1]);
    }
    public static int[][] power(int[][] matrix,int k){
        if(k<=1){
            return matrix;
        }
        if((k&1)==1){
            return multi(matrix,power(matrix,k/2));
        }else{
            return multi(power(matrix,k/2),power(matrix,k/2));
        }
    }
    public static int[][] multi(int[][] a,int [][] b){
        int[][] c = new int[a.length][b[0].length];
        for(int i=0;i<a.length;i++){
            for(int j=0;j<b.length;j++){
                for(int k=0;k<a[0].length;k++){
                    c[i][j] +=a[i][k]*b[k][j];
                    if(c[i][j]>=100){
                        c[i][j]%=100;
                    }
                }
            }
        }
        return c;
    }
}
