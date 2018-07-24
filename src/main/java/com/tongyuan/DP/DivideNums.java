package com.tongyuan.DP;

/**
 * Created by zhangcy on 2018/1/22
 * 有一个串，若一个数能被m整除，（串的长度为k），则第m位为Y，否则为N，
 * 输入：k
 * 输出：这个串的可能排列中数
 * 比如输入5，串可能是 YYYNY
 *
 * 若第i位为素数，dp[i]=dp[i-1]*2,若第i位不是素数且为a^b,则a a^2 a^3....a^b这一组加起来有b+1种情况，dp[i]=dp[i-1]*(b+1)/b,
 * 若第位不是素数且不能表示成a^b的形式，则dp[i]=dp[i-1]*2
 *
 */
import java.util.Scanner;
public class DivideNums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len=scanner.nextInt();
        long ans=1;
        boolean[] visited = new boolean[len+1];
        for(int i=2; i<=len; i++) {
            if(visited[i])
                continue;
            for(int j=2*i; j<=len; j+=i)
                visited[j] = true;
            int count=0;
            long k=i;  //int会溢出
            while(k<=len) {
                k*=i;
                count++;
            }
            ans=ans*(count+1)%1000000007;
        }
        System.out.println(ans);
    }
}
