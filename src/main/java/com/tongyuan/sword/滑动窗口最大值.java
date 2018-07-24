package com.tongyuan.sword;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by zhangcy on 2018/7/24
 * 思路：要避免每个窗口都统计一次，
 * 如果一个字符大于前一个窗口的最大值，直接将它置为最大值，但是如果一个字符不大于前一个窗口的最大值，这个最大值就还是前一个窗口的最大值而不用管
 * 当前字符了吗？不是，因为前一个窗口比较大的值可能会滑过去，而当前字符可能会成为某个窗口的最大值。
 * 因此可以用从大到小的序列记录下来，如果当前字符大于这个序列中的某些值，则删除这些值，并将当前字符加入，否则直接加入。
 * 再判断序列第一个值是不是失效了，如果失效了，移除，一次查看第二、第三个值，若没失效，返回，即为滑动窗口最大值。
 */
public class 滑动窗口最大值 {

}
