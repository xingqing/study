package com.codefun.io;

import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/**
 * Created by Administrator on 2017/2/17.
 */
public class ScatterGather {


    public static void main(String[] args) {

        try {
            RandomAccessFile fromFile = new RandomAccessFile("c:/fromFile.txt", "rw");
            FileChannel fromChannel = fromFile.getChannel();

            RandomAccessFile toFile = new RandomAccessFile("c:/toFile.txt", "rw");
            FileChannel toChannel = toFile.getChannel();

            long position = 0;
            long count = fromChannel.size();

            toChannel.transferFrom(fromChannel,position, count);

        }catch (Exception e){
            e.printStackTrace();
        }


        try{
            RandomAccessFile fromFile = new RandomAccessFile("fromFile.txt", "rw");
            FileChannel      fromChannel = fromFile.getChannel();

            RandomAccessFile toFile = new RandomAccessFile("toFile.txt", "rw");
            FileChannel      toChannel = toFile.getChannel();

            long position = 0;
            long count = fromChannel.size();

            fromChannel.transferTo(position, count, toChannel);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
