package com.codefun;

import java.util.concurrent.Phaser;

/**
 * Created by Administrator on 2017/4/24.
 */
public class MyTest {

    public static void main(String[] args) {
        Phaser phaser = new Phaser(3) {// ����3�������̣߳�����ڹ��캯���и�ֵΪ3
            @Override
            protected boolean onAdvance(int phase, int registeredParties) {
                System.out.println("\n=========�����ķָ���=============");
                return registeredParties == 0;
            }
        };
        System.out.println("����ʼִ��");
        char a = 'a';
        for (int i = 0; i < 3; i++) { // ����������3���߳�
            new MyThread((char) (a + i), phaser).start();
        }

        while (!phaser.isTerminated()) {// ֻҪphaser���սᣬ���߳̾�ѭ���ȴ�
            Thread.yield();
        }
        System.out.println("�������");
    }
}

class MyThread extends Thread {
    private char c;
    private Phaser phaser;

    public MyThread(char c, Phaser phaser) {
        this.c = c;
        this.phaser = phaser;
    }

    @Override
    public void run() {
        while (!phaser.isTerminated()) {
            for (int i = 0; i < 10; i++) { // ����ǰ��ĸ��ӡ10��
                System.out.print(c + " ");
            }
            // ��ӡ�굱ǰ��ĸ�󣬽������Ϊ����������ĸ������b����Ϊe��������һ�׶δ�ӡ
            c = (char) (c + 3);
            if (c > 'z') {
                // �����������ĸz������phaser�ж�̬����һ���̣߳����˳�ѭ���������߳�
                phaser.arriveAndDeregister();
                break;
            } else {
                // ��֮���ȴ������̵߳���׶��յ㣬��һ�������һ���׶�
                phaser.arriveAndAwaitAdvance();
            }
        }
    }
}