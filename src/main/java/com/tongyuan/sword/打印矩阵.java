package com.tongyuan.sword;

/**
 * Created by zhangcy on 2018/7/22
 */
public class 打印矩阵 {
    /**
     * 1. 设m*n的矩阵，开始元素为（0，0），每次循环开始的坐标为（start，start）
     * 2. 循环结束的标志时start< rows/2 && start< cols/2
     * 3. 最后一层循环可能有四种情况，需要区分
     */
    public static void print(int[][] matrix,int rows, int cols) {
        for (int i = 0; i < rows/2 && i< cols/2; i++) {
            printOnce(matrix,rows,cols,i);
        }
    }
    public static void printOnce(int[][] matrix,int rows,int cols,int start) {
        int endx = rows-1-start;
        int endy = rows-1-start;
        for (int i = start; i <= endx; i++) {
            System.out.println(matrix[start][i]);
        }
        if(start<endy){
            for (int i = start+1; i < endy; i++) {
                System.out.println(matrix[i][endx]);
            }
        }
        if(start<endy && start<endx){
            for (int i = endx-1; i >= start ; i--) {
                System.out.println(matrix[endy][i]);
            }
        }
        if(start<endy-1 && start<endx){
            for (int i = endy-1; i >= start+1; i--) {
                System.out.println(matrix[start][i]);
            }
        }
    }
}
