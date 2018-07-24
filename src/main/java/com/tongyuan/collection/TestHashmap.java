package com.tongyuan.collection;

import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by zhangcy on 2018/5/9
 * 遍历map时删除元素的做法：更新迭代器
 * fail-fast的作用是一个线程在迭代时，若另外的线程改变了容器的结构，就会ConcurrentModificationException异常
 */
public class TestHashmap {
    public static void main(String[] args) {
        HashMap<String,Object> map = new HashMap<>();
        map.put("1",1);
        map.put("2",2);
        map.put("3",3);
        Iterator<String> it = map.keySet().iterator();
        while(it.hasNext()){
            String str = it.next();
            System.out.println(str);
            if(str.equals("1")){
                map.remove("1");
                //it = map.keySet().iterator();
            }
        }
    }
}
