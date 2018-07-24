package com.tongyuan.sword;

/**
 * Created by zhangcy on 2018/7/23
 * 例如：3456 一位一位分析
 *
 * 个位：若等于0，则为345，若大于0，则为346 ，这时base=1，former=0，符合下面的公式
 *
 * 十位：round=34，base=10，
 * 若十位为0，则为round
 * 若十位为1，则为round*base+former+1
 * 若十位大于1，则为（round+1）*base
 *
 * 百位：round=3，base=100
 *
 * 最高位（假设为千位）:base=1000,round=0, 若最高位为1，次数为former+1，若最高位大于1，次数为1000
 * 其实与上面是一样的
 *
 * 时间复杂度为logn
 */
public class 从1到n整数中1出现的次数 {
    public static int count1(int n){
        if(n<1)
            return 0;
        int count = 0;
        int base = 1;
        int round = n;
        while(round>0){
            int weight = round%10;
            round/=10;
            count += round*base;
            if(weight==1)
                count+=(n%base)+1;
            else if(weight>1)
                count+=base;
            base*=10;
        }
        return count;
    }


    public static void main(String[] args) {
        System.out.println(count1(987479));
    }
}
