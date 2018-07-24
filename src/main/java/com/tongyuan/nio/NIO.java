package com.tongyuan.nio;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by zhangcy on 2018/4/25
 */
public class NIO {
    public static void main(String[] args) throws Exception {
        RandomAccessFile aFile = new RandomAccessFile("/Users/zhangcy/Documents/test/test.txt", "rw");
        FileChannel inChannel = aFile.getChannel();

        //create buffer with capacity of 48 bytes
        ByteBuffer buf = ByteBuffer.allocate(48);

        //read和write是相对资源来说的，而不是相对buffer来说的
        int bytesRead = inChannel.read(buf); //read into buffer.
        while (bytesRead != -1) {

            buf.flip();  //make buffer ready for read

            while(buf.hasRemaining()){
                System.out.print((char) buf.get()); // read 1 byte at a time
            }

            buf.clear(); //make buffer ready for writing
            bytesRead = inChannel.read(buf);
        }
        aFile.close();
    }
}
