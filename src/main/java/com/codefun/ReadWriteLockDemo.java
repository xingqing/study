package com.codefun;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author 作者 :		E-mail:
 * @version 创建时间：2016-7-29 下午2:21:52
 */

public class ReadWriteLockDemo {


    public static void main(String[] args) {

        MyData data = new MyData(10, 10);
        RRunnable rr = new RRunnable(data);
        MRunnable mr = new MRunnable(data);
        MMRunnable mm = new MMRunnable(data);
        ThreadFactoryDemo factory = new ThreadFactoryDemo();
        factory.newThread(rr).start();
        factory.newThread(mr).start();
        factory.newThread(mm).start();

    }


    public static class RRunnable implements Runnable {

        private MyData data;

        public RRunnable(MyData data) {
            this.data = data;
        }

        @Override
        public void run() {
            Thread thread = Thread.currentThread();
            for (int i = 0; i < 10; i++) {
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.printf("%s, num1:%s num2:%s\n", thread.getName(), this.data.getNum1(), this.data.getNum2());
            }
        }

    }


    public static class MRunnable implements Runnable {

        private MyData data;

        public MRunnable(MyData data) {
            this.data = data;
        }

        @Override
        public void run() {

            Thread thread = Thread.currentThread();
            for (int i = 0; i < 10; i++) {
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Random random = new Random();
                int num1 = random.nextInt(100);
                int num2 = random.nextInt(100);

                System.out.println(thread.getName() + ":set");
                this.data.setNum1(num1);
                System.out.println(thread.getName() + ":set");
                this.data.setNum2(num2);
                System.out.printf("%s, num1:%s num2:%s\n", thread.getName(), this.data.getNum1(), this.data.getNum2());
            }
        }

    }

    public static class MMRunnable implements Runnable {

        private MyData data;

        public MMRunnable(MyData data) {
            this.data = data;
        }

        @Override
        public void run() {
            Thread thread = Thread.currentThread();
            for (int i = 0; i < 10; i++) {
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Random random = new Random();

                int num1 = random.nextInt(100);
                int num2 = random.nextInt(100);

                System.out.println(thread.getName() + ":set2");
                this.data.setValue(num1, num2);
                System.out.printf("%s, num1:%s num2:%s\n", thread.getName(), this.data.getNum1(), this.data.getNum2());
            }
        }

    }


    public static class MyData {
        private int num1;
        private int num2;
        private ReadWriteLock lock = new ReentrantReadWriteLock();

        public MyData(int num1, int num2) {
            this.num1 = num1;
            this.num2 = num2;
        }

        public int getNum1() {
            lock.readLock().lock();
            int value = num1;
            lock.readLock().unlock();
            return value;
        }

        public void setNum1(int num1) {
            lock.writeLock().lock();
            this.num1 = num1;
            lock.writeLock().unlock();
        }

        public int getNum2() {
            lock.readLock().lock();
            int value = num2;
            lock.readLock().unlock();
            return value;
        }

        public void setNum2(int num2) {
            lock.writeLock().lock();
            this.num2 = num2;
            lock.writeLock().unlock();
        }

        public void setValue(int num1, int num2) {
            lock.writeLock().lock();
            this.num1 = num1;
            this.num2 = num2;
            lock.writeLock().unlock();
        }


    }


}
