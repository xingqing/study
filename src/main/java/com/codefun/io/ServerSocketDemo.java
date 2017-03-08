package com.codefun.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/1/23.
 */
public class ServerSocketDemo {


    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(7777);
            Socket soc = null;
            int i = 0;
            List<Socket>  clients = new ArrayList<Socket>();
            while (null != (soc = ss.accept())) {
                clients.add(soc);
                new Thread(new Receiver(soc,"¿Í»§¶Ë"+i++)).start();
            }


        } catch(IOException e){
            e.printStackTrace();
        }
    }

    static class Receiver implements Runnable{
        private Socket socket = null;
        private String role = null;
        public Receiver (Socket socket,String role){
            this.socket = socket;
            this.role = role;
        }
        @Override
        public void run() {

            BufferedReader bufferedReader = null;
            try {

                bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String str;
                while (null != (str = bufferedReader.readLine())) {
                    System.out.println(role+":"+str);
                }

            }catch (Exception e){
                e.printStackTrace();
            }finally {
                if(bufferedReader!= null){
                    try {
                        bufferedReader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    static class Sender implements Runnable{
        private Socket socket = null;
        public Sender (Socket socket){
            this.socket = socket;
        }
        @Override
        public void run() {
            PrintWriter pw = null;
            BufferedReader bufferedReader = null;
            try {
                pw= new PrintWriter(socket.getOutputStream());
                bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                String str;
                while (null != (str = bufferedReader.readLine())) {
                    pw.write(str+"\n");
                    pw.flush();
                }

            }catch (Exception e){
                e.printStackTrace();
            }finally {
                if(pw!= null){
                    pw.close();
                }
                if(bufferedReader!= null){
                    try {
                        bufferedReader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}




