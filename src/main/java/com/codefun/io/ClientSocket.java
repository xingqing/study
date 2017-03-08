package com.codefun.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by Administrator on 2017/1/23.
 */
public class ClientSocket {


    public static void main(String[] args) {

        try {
            Socket soc  = new Socket("127.0.0.1",7777);
            new Thread(new ServerSocketDemo.Receiver(soc,"·þÎñ¶Ë")).start();
            new Thread(new ServerSocketDemo.Sender(soc)).start();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }




}
