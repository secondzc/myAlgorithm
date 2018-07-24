package com.tongyuan.concurrent.actor模式.用jdk简化;


import com.tongyuan.concurrent.actor模式.用jdk简化.activeObject.ActiveObject;
import com.tongyuan.concurrent.actor模式.用jdk简化.activeObject.ActiveObjectFactory;

/**
 * Created by zhangcy on 2018/2/8
 */
public class Main {
    public static void main(String[] args) {
        ActiveObject activeObject = ActiveObjectFactory.createActiveObject();
        try{
            new MakerClientThread("alice",activeObject).start();
            new MakerClientThread("bobby",activeObject).start();
            new DisplayClientThread("chris",activeObject).start();
            Thread.sleep(5000);
        }catch(InterruptedException e){
        }finally{
            activeObject.shutdown();
        }
    }
}
